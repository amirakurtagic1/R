package com.rpr.t5.util;

import com.rpr.t5.Korisnik;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Kredit {
    public static Double proracunKreditneSposobnosti(KreditnaSposobnost funkcija, Korisnik korisnik) {
        return funkcija.provjeri(korisnik.getRacun());
    }

    public static void ispisiSveKorisnikeBezPrekoracenja(List<Korisnik> listaKorisnika) {
        listaKorisnika.stream().filter(value -> value.getRacun().getStanjeRacuna().doubleValue() > 0).forEach(value -> System.out.println(value));
    }

    public static void odobriPrekoracenje(List<Korisnik> listaKorisnika){
        listaKorisnika.stream().filter(value -> value.getRacun().getStanjeRacuna().doubleValue() > 10000).forEach(value -> value.getRacun().setOdobrenjePrekoracenja(true));
        listaKorisnika.stream().filter(value -> value.getRacun().getStanjeRacuna().doubleValue() < 10000).forEach(value -> value.getRacun().setOdobrenjePrekoracenja(false));

    }
}
