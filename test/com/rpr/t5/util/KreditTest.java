package com.rpr.t5.util;

import com.rpr.t5.Banka;
import com.rpr.t5.Korisnik;
import com.rpr.t5.Racun;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KreditTest {

 /* @Test
    void ispisiSveKorisnikeBezPrekoracenjaTest(){

    Banka banka = new Banka();
      Korisnik k1 = banka.kreirajNovogKorisnika("Korisnik1", "Korisnicic1");
      Korisnik k2 = banka.kreirajNovogKorisnika("Korisnik2", "Korisnicic2");
      Korisnik k3 = banka.kreirajNovogKorisnika("Korisnik3", "Korisnicic3");
      Korisnik k4 = banka.kreirajNovogKorisnika("Korisnik4", "Korisnicic4");
      banka.kreirajRacun(k1);
      banka.kreirajRacun(k2);
      banka.kreirajRacun(k3);
      banka.kreirajRacun(k4);
      k1.getRacun().izvrsiUplatu(200.0);
      k2.getRacun().izvrsiUplatu(500.0);
      k4.getRacun().izvrsiUplatu(150.0);

  }*/

  @Test
  void proracunKreditneSposobnostiTest(){
    Banka banka = new Banka();
    Korisnik k1 = banka.kreirajNovogKorisnika("Korisnik1", "Korisnicic1");
    banka.kreirajRacun(k1);
    KreditnaSposobnost fja = (Racun racun) ->{
      if(racun.getStanjeRacuna().doubleValue() > 500){
        return racun.getStanjeRacuna().doubleValue()/3;
      }
      else{
        return 0d;
      }
    };
    Korisnik k2 = banka.kreirajNovogKorisnika("Korisnik2", "Korisnicic2");
    banka.kreirajRacun(k2);
    k2.getRacun().izvrsiUplatu(650.0);

    Double value = Kredit.proracunKreditneSposobnosti(fja, k1);
    Double value1 = Kredit.proracunKreditneSposobnosti(fja, k2);
    assertEquals(0, value);
    assertEquals(217.0, Math.round(value1));
  }

  @Test
  void odobriPrekoracenjeTest(){
    Banka banka = new Banka();
    Korisnik k1 = banka.kreirajNovogKorisnika("Korisnik1", "Korisnicic1");
    Korisnik k2 = banka.kreirajNovogKorisnika("Korisnik2", "Korisnicic2");
    banka.kreirajRacun(k1);
    banka.kreirajRacun(k2);
    k1.getRacun().izvrsiUplatu(10500.0);
    k2.getRacun().izvrsiUplatu(500.0);
    Kredit.odobriPrekoracenje(banka.getKorisnici());
    assertTrue(k1.getRacun().provjeriOdobrenjePrekoracenja());
    assertFalse(k2.getRacun().provjeriOdobrenjePrekoracenja());
  }

  @Test
  void odobriPrekoracenjeTest1(){
    Banka banka = new Banka();
    Korisnik k1 = banka.kreirajNovogKorisnika("Korisnik1", "Korisnicic1");
    banka.kreirajRacun(k1);
    k1.getRacun().izvrsiUplatu(11000.0);
    k1.getRacun().izvrsiIsplatu(5000.00);

    assertFalse(k1.getRacun().provjeriOdobrenjePrekoracenja());
  }
}