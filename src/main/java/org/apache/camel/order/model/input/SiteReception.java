package org.apache.camel.order.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SiteReception {

    @JsonProperty("site_id")
    private int siteId;

    @JsonProperty("nom_site")
    private String nomSite;

    private String telephone;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
