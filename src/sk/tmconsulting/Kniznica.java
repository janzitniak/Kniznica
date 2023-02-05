package sk.tmconsulting;

import sk.tmconsulting.model.Kniha;
import sk.tmconsulting.model.Knihy;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Scanner;
// TODO Prestavka do 20:26
/*
Vytvorte knižnicu (Library), kde bude môcť používateľ zadať knihy (nazov, autora, počet strán, rok vydania, cena) cez konzolu
kým nezadá slovo koniec. Opakovanie na ArrayList.

Aplikacia po spusteni zobrazi menu s možnosťami:
(1) Zadaj novú knihu *
(2) Zobraz všetky knihy *
(3) Zobraz konkrétnu knihu (podľa názvu knihy) *
(4) Zadaj index knihy, ktorú zobrazujeme
(5) Zobraz názov poslednej knihy
(6) Zobraz názov prvej knihy
(7) Zobraz počet všetkých kníh
(8) Vymaž konkrétnu knihu (podľa indexu)
(9) Zadaj index knihy, ktorú odstraňujeme
(10) Vymaž všetky knihy
Koniec = skončí zadávanie novej knihy

Aplikacia caka zadanie konkretnej moznosti a nasledne reaguje.

*/



public class Kniznica {
    public static void main(String[] args) {
        //naplnTestovacimiUdajmi(); // zavolame metodu naplnTestovacimiUdajmi, ktora naplni kniznicu testovacimi udajmi a vypise jej zoznam

        // Popis aplikacie z pohladu pouzivatela
        // 1.krok: Zobraz menu s polozkou (1) Zadaj novú knihu *  (2) Zobraz všetky knihy   (3) Zobraz konkrétnu knihu (podľa názvu knihy) *
        // TODO 2.krok: Ak sme zadali cislo (1) Zadaj novú knihu, tak poziadame uzivatela, aby zadal udaje a nasledne opat zobrazime menu s polozkami

        // naplnKniznicuKnihami(); // tuto metodu nemozeme volat priamo

        Knihy objektKnihy = new Knihy(); // objekt Knihy
        //objektKnihy.naplnKniznicuKnihami(); // zavola metodu naplnKniznicuKnihami z triedy Knihy

        // my sme naplnili ArrayList testovacimi kniha cez metodu naplnKniznicuKnihami z triedy Knihy
        ArrayList<Kniha> kniznica = objektKnihy.naplnKniznicuKnihami();

        //ArrayList<Kniha> kniznica = new ArrayList<Kniha>(); // tu vytvorime kolekciu knih, ktora je prazdna
        while (true) {
            System.out.println("\n\nVyber si z menu:");
            System.out.println("(1) Zadaj novu knihu");
            System.out.println("(2) Zobraz všetky knihy");
            System.out.println("(3) Zobraz konkrétne knihy (vyhľadávanie podľa názvu = fulltext)");
            System.out.println("(9) Koniec");

            Scanner scn = new Scanner(System.in); // inicializacia "konzoly" a vstupu (pisania)

            // try, catch vyuzijeme na "osetrenie" chyby, resp. jej "zablokovanie"
            int cisloMenu = 0;
            try {
               cisloMenu = scn.nextInt();
            } catch (Exception e) { // ignorovanie chyby
                //System.out.println("Pravdepodobne si napísal písmeno namiesto čísla, zopakuj znovu!");
            }


            if (cisloMenu == 1) {
                // ak je cisloMenu = 1 tak tu nieco urobime
                Scanner scn1 = new Scanner(System.in); // vytvarame pre istotu novy scanner, aby sme mohli ziskat udaje z "konzolu" = Run dialog

                System.out.println("Stlačil si čislo 1");
                // Aplikacia by mala vypisat, resp. sa opytat na zadanie: Zadaj nazov knihy, potom Zadaj autora knihy a nasledne Zadaj rok vydania

                System.out.println("Zadaj názov knihy");
                String nazov = scn1.nextLine(); // nextLine je pre String, teda text

                System.out.println("Zadaj meno autora");
                String menoAutora = scn1.nextLine();

                System.out.println("Zadaj rok vydania");
                int rokVydania = scn1.nextInt();

                Kniha kniha = new Kniha(); // vytvorili prazdnu knihu, cize objekt = instanciu triedy Kniha
                kniha.setNazov(nazov); // prazdnu knihu naplname nazvom
                kniha.setMenoAutora(menoAutora); // a menom autora
                kniha.setRokVydania(rokVydania); // a rokom vydania


                kniznica.add(kniha); // a do kolekcie knih vlozime naplnenu knihu

            } else if (cisloMenu == 2) {
                // ak je cisloMenu = 2 tak tiez tu nieco urobime
                System.out.println("Stlačil si číslo 2");
                for (Kniha vystup:kniznica) {
                    System.out.println("Nazov knihy: " + vystup.getNazov());
                    System.out.println("Meno autora: " + vystup.getMenoAutora());
                    System.out.println("Rok vydania: " + vystup.getRokVydania());
                }
            } else if (cisloMenu == 3) {
                // ak je cisloMenu = 3 tak tiez tu nieco urobime
                System.out.println("Stlačil si číslo 3");

                // od pouzivatela budeme chciet zadanie nazvu knihy, ktory ma vyhladat
                // ak aplikacia najde v nazvoch knih dany nazov, tak vypise zoznam vsetkych najdenych knih
                System.out.println("Zadaj hľadané slovo = názov knihy, fulltext");
                Scanner scn2 = new Scanner(System.in); // inicializacia "konzoly"
                String nazovHladanychKnih = scn2.nextLine(); // ocakavany vstup od pouzivatela vo forme textu
                ArrayList<Kniha> najdeneKnihy = objektKnihy.vyhladaneKnihy(kniznica, nazovHladanychKnih); // null je prazdny

                System.out.println("Nájdené knihy");
                for(Kniha najdenaKniha:najdeneKnihy) {
                    System.out.println("Názov nájdenej knihy: " + najdenaKniha.getNazov());
                    System.out.println("Autor nájdenej knihy: " + najdenaKniha.getMenoAutora());
                    System.out.println("Rok vydania: " + najdenaKniha.getRokVydania());
                    System.out.println();
                }

            } else if (cisloMenu == 9) {
                break; // ukoncime nekonecny cyklus while(true) ak pouzivatel zada cislo 9
            } else {
                System.out.println("Prepáč, zadal si nesprávne číslo, zopakuj znovu!");
            }

        }

    }
}
