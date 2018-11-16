import java.util.*;

public class Main {

    public static void menuDriverCjtAssignatura() {
        System.out.println("1] Test Constructora Sense Paràmetres.");
        System.out.println("2] Test Donar Conjunt Assignatures");
        System.out.println("3] Test Donar Conjunt Nivells");
        System.out.println("4] Test Donar Nivell");
    }

    public static void main(String[] args) {
        int accio;
        boolean on = true;
        DriverAula driAula = new DriverAula();
        Scanner scanner = new Scanner(System.in);
        menuDriverAula();
        do {
            System.out.println(" ");
            System.out.println("Indica Opció:");
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    driAula.testConstructor1();
                    break;
                case 2:
                    driAula.testConstructor2();
                    break;
                case 3:
                    driAula.testGetId();
                    break;
                case 4:
                    driAula.testGetCapacitat();
                    break;
                default:
                    on = false;
                    break;
            }

        } while (on);
    }
}
