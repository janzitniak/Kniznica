package sk.tmconsulting.model;

import java.util.ArrayList;

public class Knihy {

    public ArrayList<Kniha> naplnKniznicuKnihami() {
        Kniha kniha1 = new Kniha(); // vytvorenie prazdnej knihy, cize objektu = instancie
        kniha1.setNazov("Já, robot"); // naplnili sme knihu1 nazvom
        kniha1.setMenoAutora("Isaac Asimov"); // naplninili sme knihu1 autorom
        kniha1.setRokVydania(1965);

        Kniha kniha2 = new Kniha(); // vytvorenie prazdnej knihy, cize objektu = instancie
        kniha2.setNazov("Duna"); // naplnili sme knihu1 nazvom
        kniha2.setMenoAutora("Frank P. Herbert"); // naplninili sme knihu1 autorom
        kniha2.setRokVydania(1970);


        ArrayList<Kniha> testovaciaKniznica = new ArrayList<Kniha>(); // vytvorili sme prazdne dynamicke pole = zoznam kniznice
        testovaciaKniznica.add(kniha1);
        testovaciaKniznica.add(kniha2);

        return testovaciaKniznica;
    }

}
