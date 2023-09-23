package org.apache.camel.order.model.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItem {

    private String id;

    @JsonProperty("idpurchaseorder")
    private int idPurchaseOrder;

    @JsonProperty("idproducts")
    private String idProducts;

    @JsonProperty("quantityorder")
    private String quanitityOrder;

    @JsonProperty("branchs_id")
    private int branchsId;

    public OrderItem() {
    }

    public OrderItem(String id, int idPurchaseOrder, String idProducts, String quanitityOrder, int branchsId) {
        this.id = id;
        this.idPurchaseOrder = idPurchaseOrder;
        this.idProducts = idProducts;
        this.quanitityOrder = quanitityOrder;
        this.branchsId = branchsId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdPurchaseOrder() {
        return idPurchaseOrder;
    }

    public void setIdPurchaseOrder(int idPurchaseOrder) {
        this.idPurchaseOrder = idPurchaseOrder;
    }

    public String getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(String idProducts) {
        this.idProducts = idProducts;
    }

    public String getQuanitityOrder() {
        return quanitityOrder;
    }

    public void setQuanitityOrder(String quanitityOrder) {
        this.quanitityOrder = quanitityOrder;
    }

    public int getBranchsId() {
        return branchsId;
    }

    public void setBranchsId(int branchsId) {
        this.branchsId = branchsId;
    }
}
