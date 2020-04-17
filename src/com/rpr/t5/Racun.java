package com.rpr.t5;

public class Racun {
    private final Long brojRacuna;
    private final Osoba korisnikRacuna;
    private Double stanjeRacuna;
    private boolean odobrenjePrekoracenja;

    public Racun(Long brojRacuna, Osoba korisnikRacuna) {
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna = korisnikRacuna;
        this.stanjeRacuna = 0d;
        this.odobrenjePrekoracenja = false;
    }

    public void izvrsiUplatu(double v) {
        stanjeRacuna = stanjeRacuna + v;
        System.out.println(stanjeRacuna);
    }

    public Number getStanjeRacuna() {
        return stanjeRacuna;
    }

    public String getBrojRacuna() {
        return brojRacuna.toString();
    }
}
