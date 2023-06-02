package com.example.Projektdomazura;

public class Pracownik{


    public static int nId = 0;
    public String imie;
    public String nazwisko;
    public String stanowisko;
    public int idPracownika;
    public int wyplata;

    public Pracownik(String imie, String nazwisko, String stanowisko, int wyplata) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.idPracownika = nId++;
        this.wyplata = wyplata;
    }

    public Pracownik() {

    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public int getIdPracownika() {
        return idPracownika;
    }

    public int getWyplata() {
        return wyplata;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public void setWyplata(int wyplata) {
        this.wyplata = wyplata;
    }
}



