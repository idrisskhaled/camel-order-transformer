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
                .log("An exception occurred: ${exception.message}")
                .to("log:errorRoute"); // Redirect the exception to an error route.

        from("file:src/data?noop=true")
                .routeId("orderRoute") // Set a custom route id
                .unmarshal().json(JsonLibrary.Jackson, SupplierOrder.class)// Unmarshal JSON to Java object
                .choice()
                    .when(simple("${body} == null"))
                        .stop() // Stop the route if body is empty
                    .otherwise() // Continue otherwise
                        .process(new OrderProcessor())
                        .marshal().json(JsonLibrary.Jackson)// Marshal the commande data to JSON
                        .to("file:target/messages?fileName=commande.json") // Output commande data to "commande.json"
                        .split().jsonpath("$..items")
                        .marshal().json(JsonLibrary.Jackson) // Convert each item to JSON
                        .transform().simple("{\"items\": ${body}}")
                        .to("file:target/messages?fileName=items.json") // Output each item to "items.json"
                .stop(); // Stop the entire route when finished

    }
}