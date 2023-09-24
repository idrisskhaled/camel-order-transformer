package org.apache.camel.order.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.order.model.input.SupplierOrder;
import org.apache.camel.order.processor.OrderProcessor;

public class OrderRoute extends RouteBuilder {
    @Override
    public void configure() {
        onException(Exception.class)
                .handled(true) // Mark the exception as handled.
                .log("An exception occurred: ${exception.message}");

        from("file:src/data?noop=true")
                .routeId("orderRoute") // Set a custom route id
                .choice()
                    .when(body().isNull())
                        .log("No data was found, the body is empty.") // Log if the file is empty
                        .to("log:output")
                    .otherwise() // Continue otherwise
                        .unmarshal().json(JsonLibrary.Jackson, SupplierOrder.class) // Unmarshal JSON to Java object
                        .process(new OrderProcessor())
                        .marshal().json(JsonLibrary.Jackson) // Marshal the commande data to JSON
                        .to("file:target/messages?fileName=commande-${header.CamelFileName}") // Output commande data to "commande.json"
                        .split().jsonpath("$..items")
                        .marshal().json(JsonLibrary.Jackson) // Convert each item to JSON
                        .transform().simple("{\"items\": ${body}}")
                        .to("file:target/messages?fileName=items-${header.CamelFileName}") // Output items to "items.json"
                .endChoice()
                .stop();

    }
}