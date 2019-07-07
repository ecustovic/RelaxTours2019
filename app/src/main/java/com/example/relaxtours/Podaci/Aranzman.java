package com.example.relaxtours.Podaci;

public class Aranzman {
    public int ID;
    public String Naziv;
    public String Termin;
    public String NacinPrevoza;
    public String HotelNaziv;
    public String HotelZ;
    public String Slika;
    public String Opis;
    public Double Cijena;
    public String Kontinent;

    public Aranzman(int id,String naziv, String termin, String nacinPrevoza, String hotelNaziv, String hotelZ, String slika, String opis, Double cijena,String kontinent) {
        Naziv = naziv;
        Termin = termin;
        NacinPrevoza = nacinPrevoza;
        HotelNaziv = hotelNaziv;
        HotelZ = hotelZ;
        Slika = slika;
        Opis = opis;
        Cijena = cijena;
        Kontinent = kontinent;
        ID = id;
    }

    public Aranzman(String tokyo, String s, String avion, String uhdhfj, String s1, String s2, String s3, double v, String asia) {
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getTermin() {
        return Termin;
    }

    public void setTermin(String termin) {
        Termin = termin;
    }

    public String getNacinPrevoza() {
        return NacinPrevoza;
    }

    public void setNacinPrevoza(String nacinPrevoza) {
        NacinPrevoza = nacinPrevoza;
    }

    public String getHotelNaziv() {
        return HotelNaziv;
    }

    public void setHotelNaziv(String hotelNaziv) {
        HotelNaziv = hotelNaziv;
    }

    public String getHotelZ() {
        return HotelZ;
    }

    public void setHotelZ(String hotelZ) {
        HotelZ = hotelZ;
    }

    public String getSlika() {
        return Slika;
    }

    public void setSlika(String slika) {
        Slika = slika;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public Double getCijena() {
        return Cijena;
    }

    public void setCijena(Double cijena) {
        Cijena = cijena;
    }
}
