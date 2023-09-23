package org.apache.camel.order.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Line {

    private String id;

    @JsonProperty("code_produit")
    private String codeProduit;

    @JsonProperty("libelle_fr")
    private String libelleFr;

    private float quantite;

    private float weight;

    private String unite;

    private int lieu;

    @JsonProperty("nb_jour_dlc_apres_decongelation")
    private int nbJourDlcApresDecongelation;

    @JsonProperty("nb_jour_dlv")
    private int nbJourDlv;

    @JsonProperty("nb_jour_blocage")
    private int nbJourBlocage;

    private boolean fragile;

    @JsonProperty("numero_lot")
    private String numeroLot;

    private String dlc;

    private String categorie;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getLibelleFr() {
        return libelleFr;
    }

    public void setLibelleFr(String libelleFr) {
        this.libelleFr = libelleFr;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getLieu() {
        return lieu;
    }

    public void setLieu(int lieu) {
        this.lieu = lieu;
    }

    public int getNbJourDlcApresDecongelation() {
        return nbJourDlcApresDecongelation;
    }

    public void setNbJourDlcApresDecongelation(int nbJourDlcApresDecongelation) {
        this.nbJourDlcApresDecongelation = nbJourDlcApresDecongelation;
    }

    public int getNbJourDlv() {
        return nbJourDlv;
    }

    public void setNbJourDlv(int nbJourDlv) {
        this.nbJourDlv = nbJourDlv;
    }

    public int getNbJourBlocage() {
        return nbJourBlocage;
    }

    public void setNbJourBlocage(int nbJourBlocage) {
        this.nbJourBlocage = nbJourBlocage;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public String getNumeroLot() {
        return numeroLot;
    }

    public void setNumeroLot(String numeroLot) {
        this.numeroLot = numeroLot;
    }

    public String getDlc() {
        return dlc;
    }

    public void setDlc(String dlc) {
        this.dlc = dlc;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

}
