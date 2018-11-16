import java.util.*;

public class Main {

    public static void menuDriverPlaEstudis() {
        System.out.println(" ");
        System.out.println("Menú Driver Pla Estudis");
        System.out.println("-----------------------");
        System.out.println("(El valor de l'opció ha de ser un número natural)");
        System.out.println(" ");
        System.out.println("1] Test Constructora Sense Paràmetres");
        System.out.println("2] Test Obtenir Instancia Pla Estudi");
        System.out.println("3] Test Obtenir Hora Inici");
        System.out.println("4] Test Obtenir Hora Fi");
        System.out.println("5] Test Obtenir Hora Canvi Franja");
        System.out.println("6] Test Obtenir Conjunt Aules");
        System.out.println("7] Test Obtenir Conjunt Assignatures");
        System.out.println("8] Test Donar Hora Inici");
        System.out.println("9] Test Donar Hora Fi");
        System.out.println("10] Test Donar Hora Canvi Franja");
        System.out.println("11] Test Afegir Aula");
        System.out.println("12] Test Afegir Assignatura");
        System.out.println("Per acabar amb el Test introduir un altre valor.");
    }

    public static void main(String[] args) {
        int accio;
        boolean on = true;
        PlaEstudis plaEstudis = new PlaEstudis();;
        Scanner scanner = new Scanner(System.in);
        menuDriverPlaEstudis();
        int hInici, hFi, hCanviFranja;
        ConjuntAules cjtAula;
        ConjuntAssignatures cjtAssig;
        do {
            System.out.println("--------------");
            System.out.println("Indica Opció:");
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    System.out.println("Creem la classe Sessió, construcora per defecte.");
                    PlaEstudis pe = new PlaEstudis();
                    plaEstudis = pe;
                    System.out.println("Assignatura s'ha creat correctament.");
                    break;
                case 2:
                    // Que fa exactament¿?
                    // S'ha de posar?
                    // PlaEstudis pe = plaEstudis.getInstance();
                    break;
                case 3:
                    hInici = plaEstudis.getHoraInici();
                    System.out.println("L'hora d'inici és "+hInici+".");
                    break;
                case 4:
                    hFi = plaEstudis.getHoraFi();
                    System.out.println("L'hora de fi és "+hFi+".");
                    break;
                case 5:
                    hCanviFranja = plaEstudis.getHoraCanviFranja();
                    System.out.println("L'hora de canvi franja és "+hCanviFranja+".");
                    break;
                case 6:
                    cjtAula = plaEstudis.getConjuntAules();
                    System.out.println("L'operació de donar conjunt d'aules s'ha realitzat correctament.");
                    break;
                case 7:
                    cjtAssig = plaEstudis.getConjuntAssignatures();
                    System.out.println("L'operació de donar conjunt d'assignatures s'ha realitzat correctament.");
                    break;
                case 8:
                    System.out.println("Introdueix el nombre d'hora d'Inici:");
                    System.out.println("(El valor ha de ser un número natural)");
                    hInici = scanner.nextInt();
                    plaEstudis.setHoraInici(hInici);
                    break;
                case 9:
                    System.out.println("Introdueix el nombre d'hora de Fi:");
                    System.out.println("(El valor ha de ser un número natural)");
                    hFi = scanner.nextInt();
                    plaEstudis.setHoraInici(hFi);
                    break;
                case 10:
                    System.out.println("Introdueix el nombre d'hora de Canvi de Franja:");
                    System.out.println("(El valor ha de ser un número natural)");
                    hCanviFranja = scanner.nextInt();
                    plaEstudis.setHoraInici(hCanviFranja);
                    break;
                case 11:
                    Aula a = new Aula();
                    plaEstudis.afegirAula(a);
                    System.out.println("S'ha afagit l'aula correctament.");
                    break;
                case 12:
                    Assignatura assig = new Assignatura();
                    plaEstudis.afegirAssignatura(assig);
                    System.out.println("S'ha afagit l'assignatura correctament.");
                    break;
                default:
                    on = false;
                    break;
            }
        } while(on);

    }
}
