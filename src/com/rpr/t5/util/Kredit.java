package com.rpr.t5.util;

import com.rpr.t5.Korisnik;

public class Kredit {
    public static Double proracunKreditneSposobnosti(KreditnaSposobnost funkcija, Korisnik korisnik) {
        return funkcija.provjeri(korisnik.getRacun());
    }
}
