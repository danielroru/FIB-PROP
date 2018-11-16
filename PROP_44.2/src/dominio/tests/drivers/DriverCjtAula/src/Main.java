import java.util.*;

public class Main {

    // La Classe Aula és un Stubs necessari per
    // analitzar Conjunt Aules.

    public static void menuDriverCjtAssignatura() {
        System.out.println(" ");
        System.out.println("Menú Driver Conjunt Aules");
        System.out.println("-------------------------------");
        System.out.println("(El valor de l'opció ha de ser un número natural)");
        System.out.println(" ");
        System.out.println("1] Test Constructora Sense Paràmetres.");
        System.out.println("2] Test Obtenir Conjunt Aules.");
        System.out.println("3] Test Donar  Conjunt Aules");
        System.out.println("4] Test Afegir Aula");
        System.out.println("Per acabar amb el Test introduir un altre valor.");
    }

    // ¿?¿? Preguntar Perquè Peta
    public static Aula crearAula() {
        String id;
        int capacitat, opcioEnum;
        Enumeracio.TipusAula tipus;
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el Id:");
        id = scanner1.nextLine();
        System.out.println("Indica la capacitat:");
        System.out.println("(El valor ha de ser un número natural)");
        capacitat = scanner2.nextInt();
        System.out.println("Indica el tipos:");
        System.out.println("Opció [1]: L'aula es de Teoria.");
        System.out.println("Opció [2]: L'aula es de Laboratori.");
        System.out.println("[Valor per defecte serà Teoria]");
        System.out.println("(El valor ha de ser un número natural)");
        opcioEnum = scanner2.nextInt();

        if (opcioEnum == 1)
            tipus = Enumeracio.TipusAula.TEORIA;
        else if (opcioEnum == 2)
            tipus = Enumeracio.TipusAula.LABORATORI;
        else
            tipus = Enumeracio.TipusAula.TEORIA;
        System.out.println("(El valor ha de ser un número natural)");
        // Peta Aquí
        Aula aula = new Aula(id, capacitat, tipus);
        return aula;
    }

    public static void main(String[] args) {
        int accio;
        boolean on = true;
        Scanner scanner = new Scanner(System.in);
        ConjuntAules cjtAules = new ConjuntAules();
        ConjuntAules aux;
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
                    aux = new ConjuntAules();
                    cjtAules = aux;
                    System.out.println("Assignatura s'ha creat correctament.");
                    break;
                case 2:
                    System.out.println("El Conjunt de les Aules són:");
                    System.out.println(" ");

                    if (cjtAules.getAules() != null) {
                        Iterator<Aula> it = cjtAules.getAules().iterator();
                        while (it.hasNext()) {
                            System.out.println("· " + it.next().getId());
                        }
                    }
                    else System.out.println("Aquests Conjunt d'Aules és buit.");
                    break;
                case 3:
                    aux = new ConjuntAules();
                    System.out.println("Creem un Conjunt d'Aules:");
                    System.out.println("");
                    System.out.println("Opció [1]: Crear Aula.");
                    System.out.println("Opció Per Defecte: Sortir.");
                    System.out.println("(El valor de l'opció ha de ser un número natural)");
                    do {
                        System.out.println("Indica Opció:");
                        accio = scanner.nextInt();
                        switch (accio) {
                            case 1:
                                Aula a = crearAula();
                                aux.afegirAula(a);
                                break;
                            default:
                                cjtAules = aux;
                                on = false;
                                break;
                        }
                    } while (on);
                    on = true;
                    break;
                case 4:
                    Aula a = crearAula();
                    cjtAules.afegirAula(a);
                    break;
                default:
                    on = false;
                    break;
            }

        } while (on);
    }
}