package com.rpr.t5;

import java.util.ArrayList;
import java.util.List;

public class Banka {
    private static Long brojRacuna = 1000000000000000L;
    private List<Uposlenik> uposleni;
    private List<Korisnik> korisnici;

    public Banka() {
        uposleni = new ArrayList<>();
        korisnici = new ArrayList<>();
    }

    public List<Uposlenik> getUposleni() {
        return uposleni;
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public Korisnik kreirajNovogKorisnika(String ime, String prezime) {
        Korisnik noviKorisnik = new Korisnik(ime, prezime);
        korisnici.add(noviKorisnik);
        return noviKorisnik;
    }

//dodala
    public static Long getBrojRacuna() {
        return brojRacuna;
    }
//dodala
    public static void setBrojRacuna(Long brojRacuna) {
        Banka.brojRacuna = brojRacuna;
    }
//dodala
    public void kreirajRacun(Korisnik k1) {
        brojRacuna +=1;
        Racun racun = new Racun(brojRacuna, k1);
        k1.setRacun(racun);
      //  System.out.println(k1.getRacun());
    }
//dodala
    public void dodajNovogUposlenog(String ime, String prezime) {
        Uposlenik noviUposlenik = new Uposlenik(ime, prezime);
        uposleni.add(noviUposlenik);
     //   System.out.println(uposleni.get(0));
    }
}
