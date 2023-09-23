package org.apache.camel.order.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.order.model.input.Contenu;
import org.apache.camel.order.model.input.Line;
import org.apache.camel.order.model.input.SupplierOrder;
import org.apache.camel.order.model.output.Order;
import org.apache.camel.order.model.output.OrderItem;

public class OrderProcessor implements Processor {
    @Override
    public void process(Exchange exchange) {
        // Retrieve the SupplierOrder object from the exchange
        SupplierOrder supplierOrder = exchange.getIn().getBody(SupplierOrder.class);

        if (supplierOrder != null) {
                // Transform the SupplierOrder input object to an Order output object
                Order order = transform(supplierOrder);

                // Set the Order object as the body
                exchange.getIn().setBody(order);
        }
    }

    public Order transform(SupplierOrder supplierOrder) {
        Contenu contenu = supplierOrder.getContenu();
        Order order = new Order();
        order.setId(contenu.getId());
        order.setContactId(contenu.getFournisseur().getCode());
        order.setContactName(contenu.getFournisseur().getNom());
        order.setBranchsId(contenu.getSiteReception().getSiteId());
        order.setBranchName(contenu.getSiteReception().getNomSite());
        order.setUserText5(contenu.getTypeMessage());
        order.setReference(contenu.getNumeroCommande());
        order.setDateOrder(contenu.getCreation());
        order.setDateReceiveEstimated(contenu.getDateReception());
        Line[] lines = supplierOrder.getContenu().getLines();
        OrderItem[] orderItems = new OrderItem[lines.length];
        if (lines.length == 0) return order;
        float quantite = 0;
        float weight = 0;

        for (int i = 0; i < lines.length; i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setIdPurchaseOrder((supplierOrder.getContenu().getId()));
            orderItem.setId(lines[i].getId());
            orderItem.setIdProducts(lines[i].getCodeProduit());
            quantite += lines[i].getQuantite();
            weight += lines[i].getWeight();
            orderItem.setQuanitityOrder(String.format("%.6f", lines[i].getQuantite()));
            orderItem.setBranchsId(supplierOrder.getContenu().getSiteReception().getSiteId());
            orderItems[i] = orderItem;
        }
        order.setQuantity(String.format("%.6f", quantite));
        order.setQuantityReceive(String.format("%.6f", quantite));
        order.setWeight(String.format("%.6f", weight));
        order.setItems(orderItems);
        return order;
    }
}