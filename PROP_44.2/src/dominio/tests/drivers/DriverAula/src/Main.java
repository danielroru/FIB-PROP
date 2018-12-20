import java.util.*;

public class Main {

    public static void menuDriverAula() {
        System.out.println(" ");
        System.out.println("Menú Driver Aula");
        System.out.println("-----------------");
        System.out.println("(El valor de l'opció ha de ser un número natural)");
        System.out.println(" ");
        System.out.println("1] Test Constructora Sense Paràmetres.");
        System.out.println("2] Test Constructora Amb Paràmetres");
        System.out.println("3] Test Obtenir Id");
        System.out.println("4] Test Obtenir Capacitat");
        System.out.println("5] Test Obtenir Tipus Aula");
        System.out.println("6] Test Donar Id");
        System.out.println("7] Test Donar Capacitat");
        System.out.println("8] Test Donar Tipus Aula");
        System.out.println("Per Test introduir un altre valor");
    }

    public static void main(String[] args) {
        int accio;
        boolean on = true;
        DriverAula driAula = new DriverAula();
        Scanner scanner = new Scanner(System.in);
        Aula aula = new Aula();
        menuDriverAula();
        do {
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("--------------");
            System.out.println("Indica Opció:");
            accio = scanner.nextInt();
            String id;
            int capacitat, tipusAula, opcioEnum;
            Enumeracio.TipusAula tipus;
            switch (accio) {
                case 1:
                    System.out.println("Creem la classe Assignatura, construcora per defecte.");
                    Aula a = new Aula();
                    aula = a;
                    System.out.println("Assignatura s'ha creat correctament.");
                    break;
                case 2:
                    System.out.println("Creem la classe Aula, constructora amb paràmetres.");
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
                    opcioEnum = scanner.nextInt();

                    switch (opcioEnum) {
                        case 1:
                            tipus = Enumeracio.TipusAula.TEORIA;
                            break;
                        case 2:
                            tipus = Enumeracio.TipusAula.LABORATORI;
                            break;
                        default:
                            tipus = Enumeracio.TipusAula.TEORIA;
                            break;
                    }
                    aula = new Aula(id, capacitat, tipus);
                    break;
                case 3:
                    id = aula.getId();
                    System.out.println("El id de l'aula és "+id+".");
                    break;
                case 4:
                    capacitat = aula.getCapacitat();
                    System.out.println("La capacitat de l'aula és "+capacitat+".");
                    break;
                case 5:
                    tipus = aula.getTipusAula();
                    System.out.println("El tipus de l'aula és "+tipus+".");
                    break;
                case 6:
                    System.out.println("Introudeix l'id de l'aula:");
                    id = scanner1.nextLine();
                    aula.setId(id);
                    break;
                case 7:
                    System.out.println("Introudeix la capacitat de l'aula:");
                    capacitat = scanner1.nextInt();
                    aula.setCapacitat(capacitat);
                    break;
                case 8:
                    System.out.println("Introudeix el tipus de l'aula:");
                    System.out.println("Opció [1]: L'aula es de Teoria.");
                    System.out.println("Opció [2]: L'aula es de Laboratori.");
                    System.out.println("[Valor per defecte serà Teoria]");
                    System.out.println("(El valor ha de ser un número natural)");
                    opcioEnum = scanner.nextInt();

                    switch (opcioEnum) {
                        case 1:
                            tipus = Enumeracio.TipusAula.TEORIA;
                            break;
                        case 2:
                            tipus = Enumeracio.TipusAula.LABORATORI;
                            break;
                        default:
                            tipus = Enumeracio.TipusAula.TEORIA;
                            break;
                    }
                    aula.setTipus(tipus);
                    break;
                default:
                    on = false;
                    break;
            }

        } while (on);
    }
}
