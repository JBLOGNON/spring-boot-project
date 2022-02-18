package com.example.weather.model;

import io.swagger.annotations.ApiModelProperty;

public class Ville {

    @ApiModelProperty(notes = "Name of the City",name="nomVille",required=true,value="Nice")
    private String nomVille;
    @ApiModelProperty(notes = "Zip Code of the City",name="codePostal",required=true,value="06000")
    private String codePostal;
    @ApiModelProperty(notes = "Country of the City",name="pays",required=true,value="France")
    private String pays;
    @ApiModelProperty(notes = "Weather of the City",name="meteo",required=true,value="Il fait 25°C")
    private String meteo;

    public Ville(String nomVille, String codePostal, String pays, String meteo) {
        this.nomVille = nomVille;
        this.codePostal = codePostal;
        this.pays = pays;
        this.meteo = meteo;
    }

    public String getNomVille() {
        return nomVille;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getPays() {
        return pays;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "nomVille='" + nomVille + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", pays='" + pays + '\'' +
                ", meteo='" + meteo + '\'' +
                '}';
    }
}
