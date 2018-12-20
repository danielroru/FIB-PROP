import java.util.*;

public class Main {

    public static void menuDriverCjtAssignatura() {
        System.out.println("1] Test Constructora Sense Paràmetres.");
        System.out.println("2] Test Donar Conjunt Assignatures");
        System.out.println("3] Test Donar Conjunt Nivells");
        System.out.println("4] Test Donar Nivell");
        System.out.println("5] Test Obtenir Assignatures");
        System.out.println("6] Test Obtenir Nivells");
        System.out.println("7] Test Afegir Nivells");
    }

    public static void main(String[] args) {
        int accio;
        boolean on = true;
        DriverCjtAssignatures driAssig = new DriverCjtAssignatures();
        Scanner scanner = new Scanner(System.in);
        menuDriverCjtAssignatura();
        do {
            System.out.println(" ");
            System.out.println("Indica Opció:");
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    driAssig.testConstructor1();
                    break;
                case 2:
                    driAssig.testGetConjuntAssignatures();
                    break;
                case 3:
                    driAssig.testGetCjtNivells();
                    break;
                case 4:
                    driAssig.testGetNivell();
                    break;
                case 5:
                    driAssig.testSetCjtAssig();
                    break;
                case 6:
                    driAssig.testSetCjtNivells();
                    break;
                case 7:
                    driAssig.testAfegirAssig();
                    break;
                default:
                    on = false;
                    break;
            }

        } while (on);
    }

}
