import java.util.*;

public class DriverAula {

    // Millorar

    public void testConstructor1() {
        System.out.println("Creem la classe Aula, construcora per defecte.");
        Aula a = new Aula();
        System.out.println("Aula s'ha creat correctament.");
    }

    public void testConstructor2() {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Creem la classe Aula, constructora amb paràmetres.");
        System.out.println("Indica el Id:");
        String id = scanner1.nextLine();
        System.out.println("Indica la capacitat:");
        //¿? Si l'usuari posa un Strin ¿? - S'ha de tenir en conta?
        int capacitat = scanner2.nextInt();
        System.out.println("Indica el tipos:");
        //¿? Si l'usuari posa un valor String que no es correcta ¿?
        //¿? Com agafem els valors dins el nostre codi ¿?
        //Enumeracio.TipusAula tipus = scanner1.nextLine();
        //Aula a = new Aula(id, capacitat, tipus);
        System.out.println("L'Aula se ha creat correctamente.");
    }

    public void testGetId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Consultar Id Aula:");
        Aula a = new Aula();
        a.setId("A1");
        String id = a.getId();
        if (id == "A1")
            System.out.println("El id s'ha consultat correctament i és "+id+".");
        else
            System.out.println("El id no s'ha consultat correctament.");
    }

    public void testGetCapacitat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Consultar Capacitat Aula:");
        Aula a = new Aula();
        a.setCapacitat(10);
        int capacitat = a.getCapacitat();
        if (capacitat == 10)
            System.out.println("El id s'ha consultat correctament i és "+capacitat);
        else
            System.out.println("La capacitat no s'ha consultat correctament.");
    }

    // Preguntar com consultar i entrar dades
    public void testGetTipusAula() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Consultar Tipus Aula:");
        Aula a = new Aula();
        //a.setTipus("TEORIA"); //¿? Com podem realitzar l'operació ¿?
        // tipus = a.getTipus(); ¿?¿?¿?
        // System.out.println("El id s'ha consultat correctament i és "+tipus);
    }

    public void testSetId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduir Id Aula:");
        Aula a = new Aula();
        String id = scanner.nextLine();
        a.setId(id);
        if (a.getId() == id)
            System.out.println("L'Id s'ha modificat correctament");
        else
            System.out.println("L'Id no s'ha modificat correctament");
    }

    public void testSetCapacitat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduir Capacitat Aula:");
        Aula a = new Aula();
        int capacitat = scanner.nextInt();
        a.setCapacitat(capacitat);
        if (a.getCapacitat() == capacitat)
            System.out.println("L'Id s'ha modificat correctament");
        else
            System.out.println("L'Id no s'ha modificat correctament");
    }

    // Correció ¿?- El fet de consultar enumeration -¿?
    public void testSetTipus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduir Capacitat Aula:");
        Aula a = new Aula();
        int capacitat = scanner.nextInt();
        a.setCapacitat(capacitat);
        if (a.getCapacitat() == capacitat)
            System.out.println("L'Id s'ha modificat correctament");
        else
            System.out.println("L'Id no s'ha modificat correctament");
    }

}
