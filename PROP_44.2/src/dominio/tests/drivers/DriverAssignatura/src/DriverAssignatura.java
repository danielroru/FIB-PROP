import java.util.*;

public class DriverAssignatura {

    public void testConstructor1() {
        System.out.println("Creem la classe Assignatura, construcora per defecte.");
        Assignatura a = new Assignatura();
        System.out.println("Assignatura s'ha creat correctament.");
    }

    public void testConstructor2() {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Creem la classe Assignatura, construcora amb paràmetres.");
        System.out.println("Indica el nom:");
        String nom = scanner1.nextLine();

        System.out.println("Indica les hores de teoria:");
        Integer nHT = scanner1.nextInt();
        System.out.println("Indica les hores de laboratori:");
        Integer nHL = scanner1.nextInt();
        System.out.println("Indica les hores de problemes:");
        Integer nHP = scanner1.nextInt();

        System.out.println("Indica els grups de teoria:");
        Integer nGT = scanner1.nextInt();
        System.out.println("Indica els grups de laboratori:");
        Integer nGL = scanner1.nextInt();
        System.out.println("Indica els grups de problemes:");
        Integer nGP = scanner1.nextInt();

        // ¿?¿?¿?¿? -> Preguntar Aquest Atribut Que Fa.
        System.out.println("Indica les hores del bloc de teoria:");
        Integer hBT = scanner1.nextInt();
        System.out.println("Indica les hores del bloc de laboratori:");
        Integer hBL = scanner1.nextInt();
        System.out.println("Indica les hores del bloc de problemes:");
        Integer hBP = scanner1.nextInt();

        System.out.println("Número Alumnes Teoria:");
        Integer nAT = scanner1.nextInt();
        System.out.println("Número Alumnes Laboratori:");
        Integer nAL = scanner1.nextInt();
        System.out.println("Número Alumnes Problemes:");
        Integer nAP = scanner1.nextInt();
        //¿?¿?¿?
        System.out.println("Número Grups Matins:");
        Integer nGMati = scanner1.nextInt();
        Integer nGTard = nGT - nGMati;

        System.out.println("Número Nivell:");
        Integer NNivell = scanner1.nextInt();

        System.out.println("Correquisists:");
        Set<String> correquisits = new HashSet<>();
        int accio = 1;
        while (accio == 1) {
            System.out.println("Opció [1] Afegir Assignatura Correquisist");
            System.out.println("Altre Valor Acabar Correquisits");
            accio = scanner1.nextInt();
            if (accio == 1) {
                String assig = scanner2.nextLine();
                correquisits.add(assig);
            }
        }

        // ¿?¿?¿? Mirar es fet de grup Tardes
        Assignatura a = new Assignatura(nom, nHT, nHL, nHP,
                nGT, nGL, nGP, hBT, hBL, hBP, nAT, nAL, nAP, nGMati,
                NNivell, correquisits);

        System.out.println("L'Assignatura s'ha creat correctament.");
    }

    public void testClonadora() {
        System.out.println("Creem un clon d'Assignatura.");
        Assignatura a1 = new Assignatura();
        Assignatura a2 = new Assignatura(a1);
        System.out.println("S'ha creat correctament.");
    }

    public void testGetNom() {
        System.out.println("Consultar Nom d'Assignatura:");
        Assignatura a = new Assignatura();
        a.setNom("PROP");
        String nom = a.getNom();
        if ("PROP" == nom)
            System.out.println("El nom s'ha consultat correctament i és "+nom+".");
        else
            System.out.println("El nom no s'ha consultat correctament.");

    }

    public void testGetHoresTeoria() {
        System.out.println("Consultar Hores Teoria d'Assignatura:");
        Assignatura a = new Assignatura();
        a.setnHoresT(2);
        Integer nHT = a.getnHoresT();
        if (2 == nHT)
            System.out.println("Les hores Teoria s'ha consultat correctament i és "+nHT+".");
        else
            System.out.println("Les hores Teoria no s'ha consultat correctament.");
    }

    public void testGetHoresLaboratori() {
        System.out.println("Consultar Hores Laboratori d'Assignatura:");
        Assignatura a = new Assignatura();
        a.setnHoresL(2);
        Integer nHL = a.getnHoresL();
        if (2 == nHL)
            System.out.println("Les hores Laboratori s'ha consultat correctament i és "+nHL+".");
        else
            System.out.println("Les hores Laboratori no s'ha consultat correctament.");
    }

    public void testGetHoresProblema() {
        System.out.println("Consultar Hores Problemes d'Assignatura:");
        Assignatura a = new Assignatura();
        a.setnHoresP(2);
        Integer nHP = a.getnHoresP();
        if (2 == nHP)
            System.out.println("Les hores Problemes s'ha consultat correctament i és "+nHP+".");
        else
            System.out.println("Les hores Problemes no s'ha consultat correctament.");
    }

    public void testGetNumeroGrupsTeoria() {
        System.out.println("Consultar Número Grups Teoria:");
        Assignatura a = new Assignatura();
        a.setnGrupsT(2);
        Integer nGT = a.getnGrupsT();
        if (2 == nGT)
            System.out.println("Les hores Teoria s'ha consultat correctament i és "+nGT+".");
        else
            System.out.println("Les hores Teoria no s'ha consultat correctament.");
    }

    public void testGetNumeroGrupsLaboratori() {
        System.out.println("Consultar Número Grups Laboratori:");
        Assignatura a = new Assignatura();
        a.setnGrupsL(2);
        Integer nGL = a.getnGrupsL();
        if (2 == nGL)
            System.out.println("Les hores Laboratori s'ha consultat correctament i és "+nGL+".");
        else
            System.out.println("Les hores Laboratori no s'ha consultat correctament.");
    }

    public void testGetNumeroGrupsProblemes() {
        System.out.println("Consultar Número Grups Problemes:");
        Assignatura a = new Assignatura();
        a.setnGrupsP(2);
        Integer nGP = a.getnGrupsP();
        if (2 == nGP)
            System.out.println("Les hores Problemes s'ha consultat correctament i és "+nGP+".");
        else
            System.out.println("Les hores Problemes no s'ha consultat correctament.");
    }

    public void testGetAlumnesTeoria() {
        System.out.println("Consultar Número Alumnes Teoria:");
        Assignatura a = new Assignatura();
        a.setnAlumnesT(2);
        Integer nAT = a.getnAlumnesT();
        if (2 == nAT)
            System.out.println("Número d'alumnes Teoria s'ha consultat correctament i és "+nAT+".");
        else
            System.out.println("Número d'alumnes Teoria no s'ha consultat correctament.");
    }

    public void testGetAlumnesLaboratorio() {
        System.out.println("Consultar Número Alumnes Laboratorio:");
        Assignatura a = new Assignatura();
        a.setnAlumnesL(2);
        Integer nAL = a.getnAlumnesL();
        if (2 == nAL)
            System.out.println("Número d'alumnes Laboratori s'ha consultat correctament i és "+nAL+".");
        else
            System.out.println("Número d'alumnes Laboratori no s'ha consultat correctament.");
    }

    public void testGetAlumnesProblemes() {
        System.out.println("Consultar Número Alumnes Laboratorio:");
        Assignatura a = new Assignatura();
        a.setnAlumnesP(2);
        Integer nAP = a.getnAlumnesP();
        if (2 == nAP)
            System.out.println("Número d'alumnes Laboratori s'ha consultat correctament i és "+nAP+".");
        else
            System.out.println("Número d'alumnes Laboratori no s'ha consultat correctament.");
    }
    // ¿?¿?¿?¿?
    public void testGetGrupsMatinTardes() {
        System.out.println("Consultar Grups Matins i Tardes:");
        Assignatura a = new Assignatura();
        a.setnGrupsMati(2);
        Integer nGMati = a.getnGrupsMati();
        if (2 == nGMati)
            // --- Falta Posar Tardes
            System.out.println("Grups Matins i Tardes s'ha consultat correctament i és "+nGMati+".");
        else
            System.out.println("Grups Matins i Tardes no s'ha consultat correctament.");
    }

    public void testGetNivell() {
        System.out.println("Consultar Nivell:");
        Assignatura a = new Assignatura();
        a.setNivell(2);
        Integer nivell = a.getNivell();
        if (2 == nivell)
            // --- Falta Posar Tardes
            System.out.println("El nivell s'ha consultat correctament i és "+nivell+".");
        else
            System.out.println("El nivell no s'ha consultat correctament.");
    }

    /////////////////////////////////////////

    public void testSetNom() {
        System.out.println("Introduir Nom d'Assignatura:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        String nom = scanner.nextLine();
        a.setNom(nom);
        if (a.getNom() == nom)
            System.out.println("El nom s'ha modificat correctament");
        else
            System.out.println("El nom no s'ha modificat correctament");

    }

    public void testSetHoresTeoria() {
        System.out.println("Introduir Hores Teoria d'Assignatura:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer HT = scanner.nextInt();
        a.setnHoresT(HT);
        if (a.getnHoresT() == HT)
            System.out.println("Les hores Teoria s'ha modificat correctament");
        else
            System.out.println("Les hores Teoria no s'ha modificat correctament");
    }

    public void testSetHoresLaboratori() {
        System.out.println("Introduir Hores Laboratori d'Assignatura:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer HL = scanner.nextInt();
        a.setnHoresL(HL);
        if (a.getnHoresL() == HL)
            System.out.println("Les hores Laboratori s'ha modificat correctament");
        else
            System.out.println("Les hores Laboratori no s'ha modificat correctament");
    }

    public void testSetHoresProblema() {
        System.out.println("Introduir Hores Problemes d'Assignatura:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer HP = scanner.nextInt();
        a.setnHoresP(HP);
        if (a.getnHoresP() == HP)
            System.out.println("Les hores Problemes s'ha modificat correctament");
        else
            System.out.println("Les hores Problemes no s'ha modificat correctament");
    }

    public void testSetNumeroGrupsTeoria() {
        System.out.println("Introduir Número Grups Teoria:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer nGT = scanner.nextInt();
        a.setnGrupsT(nGT);
        if (a.getnGrupsT() == nGT)
            System.out.println("Els grups de Teoria s'ha modificat correctament");
        else
            System.out.println("Els grups de Teoria no s'ha modificat correctament");
    }

    public void testSetNumeroGrupsLaboratori() {
        System.out.println("Introduir Número Grups Laboratori:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer nGT = scanner.nextInt();
        a.setnGrupsT(nGT);
        if (a.getnGrupsT() == nGT)
            System.out.println("Els grups de Laboratori s'ha modificat correctament");
        else
            System.out.println("Els grups de Laboratori no s'ha modificat correctament");
    }

    public void testSetNumeroGrupsProblemes() {
        System.out.println("Introduir Número Grups Problemes:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer nGT = scanner.nextInt();
        a.setnGrupsT(nGT);
        if (a.getnGrupsT() == nGT)
            System.out.println("Els grups de Problemes s'ha modificat correctament");
        else
            System.out.println("Els grups de Problemes no s'ha modificat correctament");
    }

    public void testSetAlumnesTeoria() {
        System.out.println("Introduir Número Alumnes Teoria:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer nAT = scanner.nextInt();
        a.setnAlumnesT(nAT);
        if (a.getnAlumnesT() == nAT)
            System.out.println("El número d'alumnes de Teoria s'ha modificat correctament");
        else
            System.out.println("El número d'alumnes de Teoria no s'ha modificat correctament");
    }

    public void testSetAlumnesLaboratorio() {
        System.out.println("Introduir Número Alumnes Laboratorio:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer nAL = scanner.nextInt();
        a.setnAlumnesL(nAL);
        if (a.getnAlumnesL() == nAL)
            System.out.println("El número d'alumnes de Laboratori s'ha modificat correctament");
        else
            System.out.println("El número d'alumnes de Laboratori no s'ha modificat correctament");
    }

    public void testSetAlumnesProblemes() {
        System.out.println("Introduir Número Alumnes Laboratorio:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer nAP = scanner.nextInt();
        a.setnAlumnesP(nAP);
        if (a.getnAlumnesP() == nAP)
            System.out.println("El número d'alumnes de Problemes s'ha modificat correctament");
        else
            System.out.println("El número d'alumnes de Problemes no s'ha modificat correctament");
    }
    // ¿?¿?¿?¿? - Preguntar - ¿?¿?¿?¿?¿?
    public void testSetGrupsMatinTardes() {
        System.out.println("Introduir Grups Matins i Tardes:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer nGMati = scanner.nextInt();
        a.setnGrupsMati(nGMati);
        if (a.getnGrupsMati() == nGMati)
            System.out.println("Les hores Problemes s'ha modificat correctament");
        else
            System.out.println("Les hores Problemes no s'ha modificat correctament");
    }


    public void testSetNivell() {
        System.out.println("Introduir Nivell:");
        Scanner scanner = new Scanner(System.in);
        Assignatura a = new Assignatura();
        Integer nivell = scanner.nextInt();
        a.setNivell(nivell);
        if (a.getNivell() == nivell)
            System.out.println("Les hores Problemes s'ha modificat correctament");
        else
            System.out.println("Les hores Problemes no s'ha modificat correctament");
    }

}
