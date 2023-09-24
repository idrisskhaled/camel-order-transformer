package org.apache.camel.order.model.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    private int id;

    @JsonProperty("contact_id")
    private String contactId;

    private String reference;

    @JsonProperty("datevalidationprovider")
    private String dateValidationProvider;

    @JsonProperty("dateorder")
    private String dateOrder;

    @JsonProperty("datereceive_estimated")
    private String dateReceiveEstimated;

    @JsonProperty("branchs_id")
    private int branchsId;

    @JsonProperty("user_text_5")
    private String userText5;

    private String weight;

    @JsonProperty("branch_name")
    private String branchName;

    private String quantity;

    @JsonProperty("quantityreceive")
    private String quantityReceive;

    @JsonProperty("contact_name")
    private String contactName;

    private OrderItem[] items;

    public Order() {
        quantity = "0,000000";
        quantityReceive = "0,000000";
        weight = "0,000000";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDateValidationProvider() {
        return dateValidationProvider;
    }

    public void setDateValidationProvider(String dateValidationProvider) {
        this.dateValidationProvider = dateValidationProvider;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDateReceiveEstimated() {
        return dateReceiveEstimated;
    }

    public void setDateReceiveEstimated(String dateReceiveEstimated) {
        this.dateReceiveEstimated = dateReceiveEstimated;
    }

    public int getBranchsId() {
        return branchsId;
    }

    public void setBranchsId(int branchsId) {
        this.branchsId = branchsId;
    }

    public String getUserText5() {
        return userText5;
    }

    public void setUserText5(String userText5) {
        this.userText5 = userText5;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityReceive() {
        return quantityReceive;
    }

    public void setQuantityReceive(String quantityReceive) {
        this.quantityReceive = quantityReceive;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public OrderItem[] getItems() {
        return items;
    }

    public void setItems(OrderItem[] items) {
        this.items = items;
    }
}
