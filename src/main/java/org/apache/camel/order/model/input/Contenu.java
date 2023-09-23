package org.apache.camel.order.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contenu {

    @JsonProperty("type_message")
    private String typeMessage;

    private int id;

    private Fournisseur fournisseur;
    @JsonProperty("site_reception")

    private SiteReception siteReception;

    @JsonProperty("numero_commande")
    private String numeroCommande;

    @JsonProperty("numero_livraison")
    private String numeroLivraison;

    private String statut;

    private String creation;

    private String modification;

    @JsonProperty("date_reception")
    private String dateReception;

    @JsonProperty("lignes")
    private Line[] lines;

    public Line[] getLines() {
        return lines;
    }

    public void setLines(Line[] lines) {
        this.lines = lines;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public SiteReception getSiteReception() {
        return siteReception;
    }

    public void setSiteReception(SiteReception siteReception) {
        this.siteReception = siteReception;
    }

    public String getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public String getNumeroLivraison() {
        return numeroLivraison;
    }

    public void setNumeroLivraison(String numeroLivraison) {
        this.numeroLivraison = numeroLivraison;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getDateReception() {
        return dateReception;
    }

    public void setDateReception(String dateReception) {
        this.dateReception = dateReception;
    }

}
