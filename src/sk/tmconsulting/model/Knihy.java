package sk.tmconsulting.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Knihy {


    // vratime ArrayList s naplnenymi udajmi
    public ArrayList<Kniha> naplnKniznicuKnihami() {
        Kniha kniha1 = new Kniha(); // vytvorenie prazdnej knihy, cize objektu = instancie
        kniha1.setNazov("Já, robot"); // naplnili sme knihu1 nazvom
        kniha1.setMenoAutora("Isaac Asimov"); // naplninili sme knihu1 autorom
        kniha1.setRokVydania(1965);

        Kniha kniha2 = new Kniha(); // vytvorenie prazdnej knihy, cize objektu = instancie
        kniha2.setNazov("Duna"); // naplnili sme knihu1 nazvom
        kniha2.setMenoAutora("Frank P. Herbert"); // naplninili sme knihu1 autorom
        kniha2.setRokVydania(1970);


        ArrayList<Kniha> kniznicaPole = new ArrayList<Kniha>(); // vytvorili sme prazdne dynamicke pole = zoznam kniznice
        kniznicaPole.add(kniha1); // naplnili sme dynam. pole knihou1
        kniznicaPole.add(kniha2); // a knihou2

        return kniznicaPole; // metoda vracia nase naplnene pole
    }

    public ArrayList<Kniha> vyhladaneKnihy(ArrayList<Kniha> kniznicaSoVsetkymiKnihami, String hladanyNazov) {
        // musime naprogramovat logiku ako ma vyhladat knihy podla hladanyNazov
        ArrayList<Kniha> najdeneKnihy = new ArrayList<Kniha>(); // najdeneKnihy je kolekcia, cize ArrayList najdenych knihy, na zaciatku je prazdna

        for(Kniha kniha:kniznicaSoVsetkymiKnihami) { // prechadzame kazdou knihou v ArrayList-e kniznicaSoVsetkymiKnihami
            // a v jej nazve hladame cez prikaz (metodu) contains ci obsahuje slovo v premennej hladanyNazov
            // ak ten nazov alebo jej cast tam je, tak ...
            if (kniha.getNazov().toLowerCase().contains(hladanyNazov.toLowerCase())) {
                najdeneKnihy.add(kniha); // ... pridame do najdeneKnihy danu knihu
            }
        }

        return najdeneKnihy; // zatial vraciame null, cize "nic"
    }

}
