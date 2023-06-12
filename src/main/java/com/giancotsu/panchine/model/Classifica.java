package com.giancotsu.panchine.model;

public class Classifica {

    private String nomeGiocatore;
    private String cognomeGiocatore;
    private Integer vittorie;
    private Integer pareggi;
    private Integer sconfitte;
    private Integer goalFatti;
    private Integer goalSubiti;
    private Integer tiriTotali;
    private Integer punti;

    public Classifica(){
        this.vittorie=0;
        this.pareggi=0;
        this.sconfitte=0;
        this.goalFatti=0;
        this.goalSubiti=0;
        this.tiriTotali=0;
        this.punti=0;
    }

    public Classifica(String nomeGiocatore, String cognomeGiocatore, Integer vittorie, Integer pareggi, Integer sconfitte, Integer goalFatti, Integer goalSubiti, Integer tiriTotali, Integer punti) {
        this.nomeGiocatore = nomeGiocatore;
        this.cognomeGiocatore = cognomeGiocatore;
        this.vittorie = vittorie;
        this.pareggi = pareggi;
        this.sconfitte = sconfitte;
        this.goalFatti = goalFatti;
        this.goalSubiti = goalSubiti;
        this.tiriTotali = tiriTotali;
        this.punti = punti;
    }

    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

    public void setNomeGiocatore(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
    }

    public String getCognomeGiocatore() {
        return cognomeGiocatore;
    }

    public void setCognomeGiocatore(String cognomeGiocatore) {
        this.cognomeGiocatore = cognomeGiocatore;
    }

    public Integer getVittorie() {
        return vittorie;
    }

    public void setVittorie(Integer vittorie) {
        this.vittorie = vittorie;
    }

    public Integer getPareggi() {
        return pareggi;
    }

    public void setPareggi(Integer pareggi) {
        this.pareggi = pareggi;
    }

    public Integer getSconfitte() {
        return sconfitte;
    }

    public void setSconfitte(Integer sconfitte) {
        this.sconfitte = sconfitte;
    }

    public Integer getGoalFatti() {
        return goalFatti;
    }

    public void setGoalFatti(Integer goalFatti) {
        this.goalFatti = goalFatti;
    }

    public Integer getGoalSubiti() {
        return goalSubiti;
    }

    public void setGoalSubiti(Integer goalSubiti) {
        this.goalSubiti = goalSubiti;
    }

    public Integer getTiriTotali() {
        return tiriTotali;
    }

    public void setTiriTotali(Integer tiriTotali) {
        this.tiriTotali = tiriTotali;
    }

    public Integer getPunti() {
        return punti;
    }

    public void setPunti(Integer punti) {
        this.punti = punti;
    }
}
