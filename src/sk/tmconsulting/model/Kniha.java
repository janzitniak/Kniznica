package sk.tmconsulting.model;

import java.util.ArrayList;

public class Kniha {
    // zadefinovali sme si premenne, cize fields triedy
    private String nazov;
    private String menoAutora;
    private int rokVydania;


    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getMenoAutora() {
        return menoAutora;
    }

    public void setMenoAutora(String menoAutora) {
        this.menoAutora = menoAutora;
    }

    public int getRokVydania() {
        return rokVydania;
    }

    public void setRokVydania(int rokVydania) {
        this.rokVydania = rokVydania;
    }

}
