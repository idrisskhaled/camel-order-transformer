package org.apache.camel.order.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.order.model.input.*;
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

        // Return default object if the input does not contain 'contenu'
        if(contenu == null){
            return order;
        }

        // Get 'fournisseur' from 'contenu'
        Fournisseur fournisseur = contenu.getFournisseur();

        // Set 'order' properties from 'fournisseur' properties when 'fournisseur' is not null
        if(fournisseur != null){
            order.setContactId(fournisseur.getCode());
            order.setContactName(fournisseur.getNom());
        }

        // Get 'siteReception' from 'contenu'
        SiteReception siteReception = contenu.getSiteReception();

        // Set 'order' properties from 'siteReception' properties when 'siteReception' is not null
        if(siteReception != null){
            order.setBranchsId(siteReception.getSiteId());
            order.setBranchName(siteReception.getNomSite());
        }

        // Set 'order' non-nested properties
        order.setId(contenu.getId());
        order.setUserText5(contenu.getTypeMessage());
        order.setReference(contenu.getNumeroCommande());
        order.setDateOrder(contenu.getCreation());
        order.setDateReceiveEstimated(contenu.getDateReception());

        // Get 'lines' from 'contenu'
        Line[] lines = contenu.getLines();

        // If lines property is empty return 'order'
        if (lines.length == 0) return order;

        // Else, declare an array of 'OrderItem' that will contain the transformed 'lines'
        OrderItem[] orderItems = new OrderItem[lines.length];

        // Declare and initialise 'quantite' and 'weight' properties
        float quantite = 0;
        float weight = 0;

        // Loop over the 'lines' and create an OrderItem object for each Line
        for (int i = 0; i < lines.length; i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setIdPurchaseOrder((contenu.getId()));
            orderItem.setId(lines[i].getId());
            orderItem.setIdProducts(lines[i].getCodeProduit());
            quantite += lines[i].getQuantite();
            weight += lines[i].getWeight();
            orderItem.setQuanitityOrder(String.format("%.6f", lines[i].getQuantite()));
            orderItem.setBranchsId(supplierOrder.getContenu().getSiteReception().getSiteId());
            orderItems[i] = orderItem;
        }
        // Format and set 'quantite', 'quanitereceive' and 'weight' properties
        order.setQuantity(String.format("%.6f", quantite));
        order.setQuantityReceive(String.format("%.6f", quantite));
        order.setWeight(String.format("%.6f", weight));

        // Set 'items' property
        order.setItems(orderItems);

        return order;
    }
}