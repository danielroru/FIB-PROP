import java.util.*;

public class DriverCjtAssignatures {

    // És Stubs Assignatura per el fet que deriva d'una altra classe ¿?

    public void testConstructor1() {
        System.out.println("Creem la classe Conjunt d'Assignatures, construcora per defecte.");
        ConjuntAssignatures a = new ConjuntAssignatures();
        System.out.println("Aula s'ha creat correctament.");
    }

    /*
    // No el tenim implementat
    public void testConstructor2() {

    }*/

    public void testGetConjuntAssignatures() {
        System.out.println("Donem el conjunt d'Assignatures totals.");
        ConjuntAssignatures StubsAssig = new ConjuntAssignatures();
        for (int i = 0; i < 10; ++i) {
            Assignatura a = new Assignatura();
            StubsAssig.afegirAssignatura(a);
        }
        Set<Assignatura> Aux = StubsAssig.getConjuntAssignatures();
        System.out.println("La operació s'ha realitzat correctament.");
    }

    public void testGetCjtNivells() {
        System.out.println("Donem el conjunt de Nivells totals.");
        ConjuntAssignatures StubsAssig = new ConjuntAssignatures();
        for (int i = 0; i < 10; ++i) {
            // Tindrem el nivell 0 "Valor per defecte".
            Assignatura a = new Assignatura();
            StubsAssig.afegirAssignatura(a);
        }
        HashMap<Integer, Set<Assignatura>> Aux = StubsAssig.getCjtNivells();
        System.out.println("La operació s'ha realitzat correctament.");
    }

    public void testGetNivell() {
        System.out.println("Donem el Nivell indicat totals.");
        ConjuntAssignatures StubsAssig = new ConjuntAssignatures();
        for (int i = 0; i < 10; ++i) {
            // Tindrem el nivell 0 "Valor per defecte".
            Assignatura a = new Assignatura();
            StubsAssig.afegirAssignatura(a);
        }
        Set<Assignatura> Aux = StubsAssig.getNivell(0);
        System.out.println("La operació s'ha realitzat correctament.");
    }

    public void testSetCjtAssig() {
        System.out.println("Obtenim un conjunt de Assignatures.");
        Set<Assignatura> aux = new HashSet<>();
        for (int i = 0; i < 10; ++i) {
            // Tindrem el nivell 0 "Valor per defecte".
            Assignatura a = new Assignatura();
            aux.add(a);
        }
        ConjuntAssignatures StubsAssig = new ConjuntAssignatures();
        StubsAssig.setCjtAssig(aux);
        System.out.println("La operació s'ha realitzat correctament.");
    }

    public void testSetCjtNivells() {
        System.out.println("Obtenim un conjunt de Nivells, amb les seva Assignatura associada.");
        HashMap<Integer,Set<Assignatura>> auxMap = new HashMap<>();
        Set<Assignatura> auxSet = new HashSet<>();
        for (int i = 0; i < 10; ++i) {
            // Tindrem el nivell 0 "Valor per defecte".
            Assignatura a = new Assignatura();
            auxSet.add(a);
        }
        auxMap.put(0, auxSet);
        ConjuntAssignatures StubsAssig = new ConjuntAssignatures();
        StubsAssig.setCjtNivells(auxMap);
        System.out.println("La operació s'ha realitzat correctament.");
    }

    public void testAfegirAssig() {
        System.out.println("S'afegeix una assignatura en el Conjunt Assignatures.");
        ConjuntAssignatures StubsAssig = new ConjuntAssignatures();
        Assignatura a = new Assignatura();
        StubsAssig.afegirAssignatura(a);
        System.out.println("La operació s'ha realitzat correctament.");
    }

}
