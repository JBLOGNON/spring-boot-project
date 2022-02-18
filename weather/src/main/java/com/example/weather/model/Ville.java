package com.example.weather.model;

public class Ville {

    private String nomVille;
    private String codePostal;
    private String pays;
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
