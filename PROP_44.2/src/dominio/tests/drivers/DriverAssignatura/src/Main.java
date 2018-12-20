import java.util.*;


public class Main {

    // Falta Posar Correquisits
    public static void menuDriverAssignatura() {
        System.out.println(" ");
        System.out.println("Menú Driver Assignatura");
        System.out.println("-----------------------");
        System.out.println("(El valor de l'opció ha de ser un número natural)");
        System.out.println(" ");
        System.out.println("1] Test Constructora Sense Paràmetres.");
        System.out.println("2] Test Constructora Amb Paràmetres");
        System.out.println("3] Test Clonadora");
        System.out.println("4] Test Obtenir Nom");
        System.out.println("5] Test Obtenir Hores Teoria");
        System.out.println("6] Test Obtenir Hores Laboratori");
        System.out.println("7] Test Obtenir Hores Problemes");
        System.out.println("8] Test Obtenir Número Grups Teoria");
        System.out.println("9] Test Obtenir Número Grups Laboratori");
        System.out.println("10] Test Obtenir Número Grups Problemes");
        System.out.println("11] Test Obtenir Alumnes Teoria");
        System.out.println("12] Test Obtenir Alumnes Laboratori");
        System.out.println("13] Test Obtenir Alumnes Problemes");
        System.out.println("14] Test Obtenir Grups Matin/Tardes");
        System.out.println("15] Test Obtenir Nivell");
        System.out.println("16] Test Obtenir Correquisits");
        System.out.println("17] Test Donar Nom");
        System.out.println("18] Test Donar Hores Teoria");
        System.out.println("19] Test Donar Hores Laboratori");
        System.out.println("20] Test Donar Hores Paràmetres");
        System.out.println("21] Test Donar Número Grups Teoria");
        System.out.println("22] Test Donar Número Grups Laboratori");
        System.out.println("23] Test Donar Número Grups Problemes");
        System.out.println("24] Test Donar Alumnes Teoria");
        System.out.println("25] Test Donar Alumnes Laboratori");
        System.out.println("26] Test Donar Alumnes Problema");
        System.out.println("27] Test Grups Matin/Tardes");
        System.out.println("28] Test Obtenir Nivell");
        System.out.println("29] Test Obtenir Correquisits");
        System.out.println("Per acabar introduir un altre valor.");
    }


    public static void main(String[] args) {
        int accio;
        boolean on = true;
        String nom;
        int HT, HL, HP, nGrupsT, nGrupsL, nGrupsP, AT, AL, AP;
        int GTotals, GMatins, GTardes, nivell;
        Assignatura assig = new Assignatura();
        Scanner scanner = new Scanner(System.in);
        menuDriverAssignatura();
        do {
            System.out.println("--------------");
            System.out.println("Indica Opció:");
            accio = scanner.nextInt();
            switch (accio) {

                // Creadora Per Defecte
                case 1:
                    System.out.println("Creem la classe Assignatura, construcora per defecte.");
                    Assignatura a = new Assignatura();
                    assig = a;
                    System.out.println("Assignatura s'ha creat correctament.");
                    break;

                // Creadora Per Paràmetres
                case 2:
                    Scanner scanner1 = new Scanner(System.in);
                    Scanner scanner2 = new Scanner(System.in);

                    System.out.println("Creem la classe Assignatura, construcora amb paràmetres.");
                    System.out.println("Indica el nom:");
                    nom = scanner1.nextLine();

                    System.out.println("Indica les hores de teoria:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nHT = scanner1.nextInt();
                    System.out.println("Indica les hores de laboratori:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nHL = scanner1.nextInt();
                    System.out.println("Indica les hores de problemes:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nHP = scanner1.nextInt();

                    System.out.println("Indica els grups de teoria:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nGT = scanner1.nextInt();
                    System.out.println("Indica els grups de laboratori:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nGL = scanner1.nextInt();
                    System.out.println("Indica els grups de problemes:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nGP = scanner1.nextInt();

                    // ¿?¿?¿?¿? -> Preguntar Aquest Atribut Que Fa.
                    System.out.println("Indica les hores del bloc de teoria:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer hBT = scanner1.nextInt();
                    System.out.println("Indica les hores del bloc de laboratori:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer hBL = scanner1.nextInt();
                    System.out.println("Indica les hores del bloc de problemes:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer hBP = scanner1.nextInt();

                    System.out.println("Número Alumnes Teoria:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nAT = scanner1.nextInt();
                    System.out.println("Número Alumnes Laboratori:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nAL = scanner1.nextInt();
                    System.out.println("Número Alumnes Problemes:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nAP = scanner1.nextInt();
                    //¿?¿?¿?
                    System.out.println("Número Grups Matins:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer nGMati = scanner1.nextInt();
                    Integer nGTard = nGT - nGMati;

                    System.out.println("Número Nivell:");
                    System.out.println("(El valor ha de ser un número natural)");
                    Integer NNivell = scanner1.nextInt();

                    System.out.println("Correquisists:");
                    Set<String> correquisits = new HashSet<>();
                    accio = 1;
                    while (accio == 1) {
                        System.out.println("Opció [1] Afegir Assignatura Correquisist");
                        System.out.println("Altre Valor Acabar Correquisits");
                        accio = scanner1.nextInt();
                        if (accio == 1) {
                            String assignatura = scanner2.nextLine();
                            correquisits.add(assignatura);
                        }
                    }
                    // ¿?¿?¿? Mirar es fet de grup Tardes
                    Assignatura aux = new Assignatura(nom, nHT, nHL, nHP,
                            nGT, nGL, nGP, hBT, hBL, hBP, nAT, nAL, nAP, nGMati,
                            NNivell, correquisits);
                    assig = aux;
                    System.out.println("L'Assignatura s'ha creat correctament.");
                    break;

                // Aquí hi ha la clonadora.
                case 3:
                    System.out.println("Creem un clon d'Assignatura.");
                    Assignatura a1 = new Assignatura();
                    assig = new Assignatura(a1);
                    System.out.println("S'ha creat correctament.");
                    break;


                // Aquí Comencen els Getters.

                case 4:
                    nom = assig.getNom();
                    System.out.println("El nom de l'assignatura és "+nom+".");
                    break;
                case 5:
                    HT = assig.getnHoresT();
                    System.out.println("El nombre de hores de teoria de l'assignatura és "+HT+".");
                    break;
                case 6:
                    HL = assig.getnHoresL();
                    System.out.println("El nombre de hores de laboratori de l'assignatura és "+HL+".");
                    break;
                case 7:
                    HP = assig.getnHoresP();
                    System.out.println("El nombre de hores de problemes de l'assignatura és "+HP+".");
                    break;
                case 8:
                    nGrupsT = assig.getnGrupsT();
                    System.out.println("El nombre de grups de teoria de l'assignatura és "+nGrupsT+".");
                    break;
                case 9:
                    nGrupsL = assig.getnGrupsL();
                    System.out.println("El nombre de grups de laboratori de l'assignatura és "+nGrupsL+".");
                    break;
                case 10:
                    nGrupsP = assig.getnGrupsP();
                    System.out.println("El nombre de grups de laboratori de l'assignatura és "+nGrupsP+".");
                    break;
                case 11:
                    AT = assig.getnAlumnesT();
                    System.out.println("El nombre d'alumnes de teoria de l'assignatura és "+AT+".");
                    break;
                case 12:
                    AL = assig.getnAlumnesT();
                    System.out.println("El nombre d'alumnes de laboratori de l'assignatura és "+AL+".");
                    break;
                case 13:
                    AP = assig.getnAlumnesT();
                    System.out.println("El nombre d'alumnes de problemes de l'assignatura és "+AP+".");
                    break;
                case 14:
                    // Tardes es pot implementar ?¿?¿?¿
                    GMatins = assig.getnGrupsMati();
                    GTotals = assig.getnGrupsT() + assig.getnGrupsL() + assig.getnGrupsP();
                    GTardes = GTotals - GMatins;
                    System.out.println("El nombre de grups de matins és "+GMatins+".");
                    System.out.println("El nombre de grups de tardes és "+GTardes+".");
                    break;
                case 15:
                    nivell = assig.getNivell();
                    System.out.println("El nombre de grups de nivells és "+nivell+".");
                    break;
                case 16:
                    Set<String> c = new HashSet<>();
                    c = assig.getCorrequisits();
                    System.out.println(" ");
                    if (c != null) {
                        System.out.println("Els correquisits de l'assignatura són:");
                        Iterator<String> it = c.iterator();
                        while (it.hasNext()) {
                            System.out.println("· " + it.next());
                        }
                    }
                    else System.out.println("Aquesta Assignatura no té correquisits.");
                    break;

                // Aquí Comencen els Setters.

                case 17:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    nom = scanner.nextLine();
                    assig.setNom(nom);
                    break;
                case 18:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    HT = scanner.nextInt();
                    assig.setnHoresT(HT);
                    break;
                case 19:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    HL = scanner.nextInt();
                    assig.setnHoresP(HL);
                    break;
                case 20:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    HP = scanner.nextInt();
                    assig.setnHoresP(HP);
                    break;
                case 21:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    nGrupsT = scanner.nextInt();
                    assig.setnGrupsT(nGrupsT);
                    break;
                case 22:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    nGrupsL = scanner.nextInt();
                    assig.setnGrupsT(nGrupsL);
                    break;
                case 23:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    nGrupsP = scanner.nextInt();
                    assig.setnGrupsT(nGrupsP);
                    break;
                case 24:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    AT = scanner.nextInt();
                    assig.setnGrupsT(AT);
                    break;
                case 25:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    AL = scanner.nextInt();
                    assig.setnGrupsL(AL);
                    break;
                case 26:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    AP = scanner.nextInt();
                    assig.setnGrupsT(AP);
                    break;
                case 27:
                    // ¿?¿?¿?
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    GMatins = scanner.nextInt();
                    GTardes = scanner.nextInt();
                    assig.setnGrupsMati(GMatins);
                    break;
                case 28:
                    System.out.println("Introdueix el nom de l'Assignatura:");
                    System.out.println("(El valor ha de ser un número natural)");
                    nivell = scanner.nextInt();
                    assig.setNivell(nivell);
                    break;
                case 29:
                    Scanner scan1 = new Scanner(System.in);
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Correquisists:");
                    Set<String> correq = new HashSet<>();
                    accio = 1;
                    while (accio == 1) {
                        System.out.println("Opció [1] Afegir Assignatura Correquisist");
                        System.out.println("Altre Valor Acabar Correquisits");
                        accio = scan1.nextInt();
                        if (accio == 1) {
                            String assignatura = scan2.nextLine();
                            correq.add(assignatura);
                        }
                    }
                    assig.setCorrequisits(correq);
                    break;
                default:
                    on = false;
                    break;
            }

        } while (on);
    }
}
