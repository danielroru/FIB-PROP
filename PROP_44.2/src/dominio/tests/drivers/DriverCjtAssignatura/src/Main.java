import java.util.*;

public class Main {

    // La Classe Assignatura és un Stubs necessari per
    // analitzar Conjunt Assignatures.

    public static void menuDriverCjtAssignatura() {
        System.out.println(" ");
        System.out.println("Menú Driver Conjunt Assignatura");
        System.out.println("-------------------------------");
        System.out.println("(El valor de l'opció ha de ser un número natural)");
        System.out.println(" ");
        System.out.println("1] Test Constructora Sense Paràmetres.");
        System.out.println("2] Test Obtenir Assignatures");
        System.out.println("3] Test Obtenir Nivells");
        System.out.println("4] Test Obtenir Assignatura Per Nivell");
        System.out.println("5] Test Donar Assignatura");
        System.out.println("6] Test Afegir Assignatura");
        System.out.println("Per acabar amb el Test introduir un altre valor.");
    }

    public static void main(String[] args) {
        int accio;
        boolean on = true;
        Scanner scanner = new Scanner(System.in);
        ConjuntAssignatures cjtAssignatura = new ConjuntAssignatures();
        menuDriverCjtAssignatura();
        do {
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("--------------");
            System.out.println("Indica Opció:");
            accio = scanner.nextInt();

            switch (accio) {
                case 1:
                    System.out.println("Creem la classe Assignatura, construcora per defecte.");
                    ConjuntAssignatures aux = new ConjuntAssignatures();
                    cjtAssignatura = aux;
                    System.out.println("Assignatura s'ha creat correctament.");
                    break;
                case 2:
                    System.out.println("El Conjunt de les Assignatures són:");
                    System.out.println(" ");

                    if (cjtAssignatura.getAssignatures() != null) {
                        Iterator<Assignatura> it = cjtAssignatura.getAssignatures().iterator();
                        while (it.hasNext()) {
                            System.out.println("· " + it.next().getNom());
                        }
                    }
                    else System.out.println("Aquests Conjunt d'Assignatura és buit.");
                    break;
                case 3:
                    System.out.println("Introudeix el nivell que vols obtenir:");
                    System.out.println("(El valor de l'opció ha de ser un número natural)");
                    int nivell = scanner1.nextInt();
                    System.out.println("El Conjunt de Assignatures del Nivell "+nivell+" són:");
                    System.out.println(" ");
                    if (cjtAssignatura.getConjuntNivell(nivell) != null) {
                        System.out.println("Els Nivells de les assignatura són:");
                        Iterator<Assignatura> it = cjtAssignatura.getConjuntNivell(nivell).iterator();
                        while (it.hasNext()) {
                            System.out.println("· " + (it.next()).getNom());
                        }
                    }
                    else System.out.println("Aquests Nivell no té Assignatures.");
                    break;
                case 4:
                    // De la manera que està implementar la funció 3 i 4 fan el mateix ¿?
                    // És el fet de saber el núm d'assig que té aquest nivell i no les assig ¿?
                    System.out.println("[Comentar Marc]");
                    break;
                case 5:
                    // Preguntar Borja si tiene que poner nada mas.
                    System.out.println("Introudeix el nom de l'Assignatura:");
                    String nom = scanner2.nextLine();
                    Assignatura assig = cjtAssignatura.getAssignatura(nom);
                    if (assig != null)
                        System.out.println("La Assignatura "+assig.getNom()+" s'ha obtingut correctament.");
                    else
                        System.out.println("L'Assignatura no existeix dins el Conjunt Assignatures.");
                    break;
                case 6:
                    // afegirAssignatura
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
                    Assignatura auxAssig = new Assignatura(nom, nHT, nHL, nHP,
                            nGT, nGL, nGP, hBT, hBL, hBP, nAT, nAL, nAP, nGMati,
                            NNivell, correquisits);
                    cjtAssignatura.afegirAssignatura(auxAssig);
                    System.out.println("L'Assignatura s'ha afegir correctament.");
                    break;
                default:
                    on = false;
                    break;
            }

        } while (on);
    }
}