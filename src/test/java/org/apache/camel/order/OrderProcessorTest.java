package org.apache.camel.order;


import org.apache.camel.order.model.input.*;
import org.apache.camel.order.model.output.Order;
import org.apache.camel.order.processor.OrderProcessor;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class OrderProcessorTest {

    @Test
    public void testTransformWithAllProperties() {
        // Create a SupplierOrder object for testing
        SupplierOrder supplierOrder = createSupplierOrder(true,true,true,true);

        // Create an instance of OrderProcessor
        OrderProcessor orderProcessor = new OrderProcessor();

        // Invoke the transform method
        Order order = orderProcessor.transform(supplierOrder);

        // Add assertions to check the properties of the Order object
        assertEquals(2, order.getId());
        assertEquals("mock code", order.getContactId());
        assertEquals("mock nom", order.getContactName());
        assertEquals(150, order.getBranchsId());
        assertEquals("mock nom site", order.getBranchName());
        assertEquals("mock type", order.getUserText5());
        assertEquals("15454545", order.getReference());
        assertEquals("mock creation", order.getDateOrder());
        assertEquals("mock date reception", order.getDateReceiveEstimated());
        assertEquals("120,000000", order.getQuantity());
        assertEquals("120,000000", order.getQuantityReceive());
        assertEquals("mock id", order.getItems()[0].getId());
        assertEquals(2, order.getItems()[0].getIdPurchaseOrder());
        assertEquals("mock code produit", order.getItems()[0].getIdProducts());
        assertEquals("120,000000", order.getItems()[0].getQuanitityOrder());
        assertEquals(150, order.getItems()[0].getBranchsId());
    }

    @Test
    public void testTransformWithoutContenu() {
        // Create a SupplierOrder object for testing
        SupplierOrder supplierOrder = createSupplierOrder(false,false,false,false);

        // Create an instance of OrderProcessor
        OrderProcessor orderProcessor = new OrderProcessor();

        // Invoke the transform method
        Order order = orderProcessor.transform(supplierOrder);

        // Add assertions to check the properties of the Order object
        assertEquals(0, order.getId());
        assertEquals(null, order.getContactId());
        assertEquals(null, order.getContactName());
        assertEquals(0, order.getBranchsId());
        assertEquals(null, order.getReference());
        assertEquals("0,000000", order.getWeight());
        assertEquals(null, order.getItems());
    }


    @Test
    public void testTransformWithoutFournisseur() {
        // Create a SupplierOrder object for testing
        SupplierOrder supplierOrder = createSupplierOrder(true,false,true,true);

        // Create an instance of OrderProcessor
        OrderProcessor orderProcessor = new OrderProcessor();

        // Invoke the transform method
        Order order = orderProcessor.transform(supplierOrder);

        // Add assertions to check the properties of the Order object
        assertEquals(2, order.getId());
        assertEquals(null, order.getContactId());
        assertEquals(null, order.getContactName());
        assertEquals(150, order.getBranchsId());
        assertEquals("mock nom site", order.getBranchName());
        assertEquals("mock type", order.getUserText5());
        assertEquals("15454545", order.getReference());
        assertEquals("mock creation", order.getDateOrder());
        assertEquals("mock date reception", order.getDateReceiveEstimated());
        assertEquals("120,000000", order.getQuantity());
        assertEquals("120,000000", order.getQuantityReceive());
        assertEquals("mock id", order.getItems()[0].getId());
        assertEquals(2, order.getItems()[0].getIdPurchaseOrder());
        assertEquals("mock code produit", order.getItems()[0].getIdProducts());
        assertEquals("120,000000", order.getItems()[0].getQuanitityOrder());
        assertEquals(150, order.getItems()[0].getBranchsId());
    }


    @Test
    public void testTransformWithoutLines() {
        // Create a SupplierOrder object for testing
        SupplierOrder supplierOrder = createSupplierOrder(true,true,false,true);

        // Create an instance of OrderProcessor
        OrderProcessor orderProcessor = new OrderProcessor();

        // Invoke the transform method
        Order order = orderProcessor.transform(supplierOrder);

        // Add assertions to check the properties of the Order object
        assertEquals(2, order.getId());
        assertEquals("mock code", order.getContactId());
        assertEquals("mock nom", order.getContactName());
        assertEquals(150, order.getBranchsId());
        assertEquals("mock nom site", order.getBranchName());
        assertEquals("mock type", order.getUserText5());
        assertEquals("15454545", order.getReference());
        assertEquals("mock creation", order.getDateOrder());
        assertEquals("mock date reception", order.getDateReceiveEstimated());
        assertEquals("0,000000", order.getQuantity());
        assertEquals("0,000000", order.getWeight());
        assertEquals("0,000000", order.getQuantityReceive());
        assertEquals(null, order.getItems());
    }

    @Test
    public void testTransformWithoutSiteReception() {
        // Create a SupplierOrder object for testing
        SupplierOrder supplierOrder = createSupplierOrder(true,true,true,false);

        // Create an instance of OrderProcessor
        OrderProcessor orderProcessor = new OrderProcessor();

        // Invoke the transform method
        Order order = orderProcessor.transform(supplierOrder);

        /// Add assertions to check the properties of the Order object
        assertEquals(2, order.getId());
        assertEquals("mock code", order.getContactId());
        assertEquals("mock nom", order.getContactName());
        assertEquals(0, order.getBranchsId());
        assertEquals(null, order.getBranchName());
        assertEquals("mock type", order.getUserText5());
        assertEquals("15454545", order.getReference());
        assertEquals("mock creation", order.getDateOrder());
        assertEquals("mock date reception", order.getDateReceiveEstimated());
        assertEquals("120,000000", order.getQuantity());
        assertEquals("120,000000", order.getQuantityReceive());
        assertEquals("mock id", order.getItems()[0].getId());
        assertEquals(2, order.getItems()[0].getIdPurchaseOrder());
        assertEquals("mock code produit", order.getItems()[0].getIdProducts());
        assertEquals("120,000000", order.getItems()[0].getQuanitityOrder());
        assertEquals(0, order.getItems()[0].getBranchsId());
    }

    // Helper method to create a sample SupplierOrder object for testing
    private SupplierOrder createSupplierOrder(Boolean hasContenu, Boolean hasFrournisseur, Boolean hasLines, Boolean hasSiteReception) {
        SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setCreation("mock creation date");
        supplierOrder.setExported(1);
        supplierOrder.setId(1);
        supplierOrder.setMessageType("mock message type");

        if(hasContenu){
            Contenu contenu = new Contenu();
            contenu.setCreation("mock creation");
            contenu.setId(2);
            contenu.setDateReception("mock date reception");
            contenu.setModification("mock modification");
            contenu.setNumeroCommande("15454545");
            contenu.setStatut("mock statut");
            contenu.setTypeMessage("mock type");
            contenu.setNumeroLivraison("mock num livraison");
            if(hasFrournisseur){
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setCode("mock code");
                fournisseur.setNom("mock nom");
                fournisseur.setTelephone("mock telephone");
                contenu.setFournisseur(fournisseur);
            }
            if(hasLines){
                Line[] lines = new Line[1];
                Line line = new Line();
                line.setId("mock id");
                line.setCategorie("mock categorie");
                line.setCodeProduit("mock code produit");
                line.setDlc("mock dlc");
                line.setFragile(true);
                line.setLibelleFr("mock libelle fr");
                line.setLieu(5);
                line.setNbJourBlocage(5);
                line.setNbJourDlcApresDecongelation(3);
                line.setWeight(130);
                line.setQuantite(120);
                lines[0] = line;
                contenu.setLines(lines);
            }
            if(hasSiteReception){
                SiteReception siteReception = new SiteReception();
                siteReception.setSiteId(150);
                siteReception.setNomSite("mock nom site");
                siteReception.setTelephone("mock tel site");
                contenu.setSiteReception(siteReception);
            }
            supplierOrder.setContenu(contenu);
        }
        return supplierOrder;
    }
}
