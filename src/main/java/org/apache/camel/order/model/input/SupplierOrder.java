package org.apache.camel.order.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SupplierOrder {

    private int id;

    @JsonProperty("message_type")
    private String messageType;

    private String creation;

    private int exported;

    private Contenu contenu;

    // Getters and setters for the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public int getExported() {
        return exported;
    }

    public void setExported(int exported) {
        this.exported = exported;
    }

    public Contenu getContenu() {
        return contenu;
    }

    public void setContenu(Contenu contenu) {
        this.contenu = contenu;
    }
}


