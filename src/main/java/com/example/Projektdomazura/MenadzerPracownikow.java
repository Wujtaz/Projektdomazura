package com.example.Projektdomazura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MenadzerPracownikow {
    private final HashMap<Integer, Pracownik> pracownicy;

    public HashMap<Integer, Pracownik> getPracownicy() {
        return this.pracownicy;
    }

    public MenadzerPracownikow(HashMap<Integer, Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public void dodajPracownika(String imie, String nazwisko, String stanowisko, int wyplata) {
        Pracownik pracownik = new Pracownik(imie, nazwisko, stanowisko, wyplata);
        Integer kluczPracownika = pracownik.getIdPracownika();
        this.pracownicy.put(kluczPracownika, pracownik);
    }

    public void usunPracownika(Pracownik pracownik) {
        if (this.pracownicy.containsKey(pracownik.getIdPracownika())) {
            this.pracownicy.remove(pracownik.getIdPracownika());
        } else {
            System.out.println("Pracownik o takim ID nie istnieje");
        }

    }

    public void aktualizacjaPracownika(int idPracownika, String noweStanowisko, int nowaWyplata) {
        if (znajdzPracownikaPoID(idPracownika) != null){
            Pracownik e = znajdzPracownikaPoID(idPracownika);
            e.setStanowisko(noweStanowisko);
            e.setWyplata(nowaWyplata);
        } else {
            System.out.println("Pracownik o takim ID nie istnieje");
        }

    }

    public Pracownik znajdzPracownikaPoID(int idPracownika) {
        if (this.pracownicy.containsKey(idPracownika)) {
            return (Pracownik) this.pracownicy.get(idPracownika);
        } else {
            System.out.println("Nie znaleziono pracownika o danym ID");
            return null;
        }
    }

    public void listaWszystkichPracownikow() {
        ArrayList<Pracownik> listaPracownikow = new ArrayList(this.pracownicy.values());
        Iterator var2 = listaPracownikow.iterator();

        while(var2.hasNext()) {
            Pracownik pracownik = (Pracownik) var2.next();
            System.out.println(pracownik);
        }

    }

    public HashSet<Pracownik> znajdzPracownikaPoNazwisku(String nazwisko) {
        HashSet<Pracownik> listaPracownikow = new HashSet(this.pracownicy.values());
        Iterator<Pracownik> pracownikIterator = listaPracownikow.iterator();

        while(pracownikIterator.hasNext()) {
            Pracownik pracownik = (Pracownik) pracownikIterator.next();
            if (!pracownik.getNazwisko().equals(nazwisko)) {
                pracownikIterator.remove();
            }
        }

        return listaPracownikow;
    }
}