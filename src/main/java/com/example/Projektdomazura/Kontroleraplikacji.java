package com.example.Projektdomazura;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Kontroleraplikacji {
    static HashMap<Integer, Pracownik> pracownikHashMap = new HashMap();
    static MenadzerPracownikow menadzerPracownikow = new MenadzerPracownikow(pracownikHashMap);

    public static void dodajDoMenadzera() {
        menadzerPracownikow.dodajPracownika("Jakub", "Berbeś", "Sprzątacz", 100);
        menadzerPracownikow.dodajPracownika("Radek", "Stadnik", "Kelner", 60);
        menadzerPracownikow.dodajPracownika("Michał", "Jaca", "Menel", 420);
        menadzerPracownikow.dodajPracownika("Paweł", "Mazur", "Szef", 999999);
    }

    @GetMapping({"/dodaj"})
    public String form(Model model) {
        model.addAttribute("Pracownik", new Pracownik());
        return "dodaj";
    }

    @GetMapping({"/"})
    public String displayEmployees(Model model) {
        model.addAttribute("menadzerPracownikow", menadzerPracownikow);
        return "indeks";
    }

    @GetMapping({"/edytuj/{id}"})
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Pracownik pracownik = menadzerPracownikow.znajdzPracownikaPoID(id);
        model.addAttribute("pracownik", pracownik);
        return "edytuj";
    }

    @PostMapping({"/usun/{id}"})
    public String usunPracownika(@PathVariable("id") int id) {
        System.out.println(id);
        menadzerPracownikow.usunPracownika(menadzerPracownikow.znajdzPracownikaPoID(id));
        return "redirect:/";
    }

    @PostMapping({"/aktualizuj/{id}"})
    public String aktualizacjaPracownika(@PathVariable("id") String id, @ModelAttribute("pracownik") Pracownik aktualizujPracownika) {
        menadzerPracownikow.aktualizacjaPracownika(Integer.parseInt(id), aktualizujPracownika.getStanowisko(), aktualizujPracownika.getWyplata());
        return "redirect:/";
    }

    @PostMapping({"/znajdzponazwisku/szukaj"})
    public String znajdzPracownikaPoNazwisku(@RequestParam("nazwisko") String nazwisko, Model model) {
        model.addAttribute("nazwisko", nazwisko);
        model.addAttribute("menadzerPracownikow", menadzerPracownikow);
        return "szukajponazwisku";
    }

    @PostMapping({"/pracownik/zapisz"})
    public String addEmployeeToHashList(@RequestParam("imie") String imie,@RequestParam("nazwisko") String nazwisko,@RequestParam("stanowisko") String stanowisko,@RequestParam("wyplata") int wyplata) {
        System.out.println(imie+ " "+imie+ " "+nazwisko+ " "+stanowisko+ " "+ wyplata);
        menadzerPracownikow.dodajPracownika(imie, nazwisko, stanowisko, wyplata);
        return "redirect:/dodaj";
    }
}