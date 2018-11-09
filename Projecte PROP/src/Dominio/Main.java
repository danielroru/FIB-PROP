package Dominio;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    /////////////////////////////////////////////////////////////////
    /// MENÚ GESTIÓ CONFIGURACIÓ
    /////////////////////////////////////////////////////////////////

    public static void menuGestioConfiguracio(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            escriureMenuGestioConfiguracio();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    //configuracioAules(CD);
                    break;
                case 2:
                    configuracioAssignatures(CD);
                    break;
                case 3:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

import JSON.JSONArray;
import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;

        // Gestió
        /*
        public static void configuracioAules(CapaDomini CD) {
            Scanner scanner = new Scanner(System.in);
            boolean on = true;
            int accio;

            while (on) {
                escriureMenuAula();
                accio = scanner.nextInt();
                switch (accio) {
                    case 1:
                        llistarAules(CD);
                        break;
                    case 2:
                        afegirAula(CD);
                        break;
                    case 3:
                        modificarAula(CD);
                        break;
                    case 4:
                        eliminarAula(CD);
                        break;
                    case 5:
                        on = false;
                        break;
                    default:
                        escriureError(1);
                        break;
                }
            }
        }
        */
        // Operacions

        /*
        public static void llistarAules(CapaDomini CD) {
            System.out.println("Llista d'aules:");
            System.out.println(" ");

            int nTeoria = 0;
            int nLaboratori = 0;

            for(Aula a : CD.llistarAules()){
                Aula.TipusAula tipus = a.getTipusAula();
                System.out.println("    ID:         " + a.getId());
                System.out.println("    Capacitat:  " + a.getCapacitat());
                System.out.println("    Tipus:      " + tipus);
                System.out.println(" ");

                if (tipus == Aula.TipusAula.TEORIA) {
                    nTeoria++;
                }
                else {
                    nLaboratori++;
                }
            }

            System.out.println("    Número de classes de teoria:  " + nTeoria);
            System.out.println("    Número de classes de laboratori: " + nLaboratori);
            System.out.println(" ");
        }

        public static void afegirAula(CapaDomini CD) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("ID de l'aula:");
            String id = scanner.nextLine();
            System.out.println("Capacitat de l'aula:");
            int capacitat = scanner.nextInt();

            System.out.println("Tipus de l'aula:");
            System.out.println("    Teoria      -> 1");
            System.out.println("    Laboratori  -> 2");

            Aula.TipusAula tipus = null;
            int numTipusAula = scanner.nextInt();

            if (numTipusAula == 1 || numTipusAula == 2) {
                tipus = numTipusAula == 1 ? Aula.TipusAula.TEORIA : Aula.TipusAula.LABORATORI;
            }

            CD.afegirAula(id, capacitat, tipus);
            System.out.println("-- AULA AFEGIDA CORRECTAMENT --");
        }

        public static void modificarAula(CapaDomini CD) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("ID de l'aula:");
            String id = scanner.nextLine();

            CD.modificarAula(id);
        }

        public static void eliminarAula(CapaDomini CD) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("ID de l'aula:");
            String id = scanner.nextLine();

            CD.eliminarAula(id);
            System.out.println("-- AULA ELIMINADA CORRECTAMENT --");
        }
        */
        /////////////////////////////////////////////////////////////////
        /// ASSIGNATURES
        /////////////////////////////////////////////////////////////////

        // Gestió

        public static void configuracioAssignatures(CapaDomini CD) {
            Scanner scanner = new Scanner(System.in);
            boolean on = true;
            int accio;

            while (on) {
                escriureMenuAssignatura();
                accio = scanner.nextInt();
                switch (accio) {
                    case 1:
                        llistarAssignatures(CD);
                        break;
                    case 2:
                        afegirAssignatura(CD);
                        break;
                    case 3:
                        modificarAssignatura(CD);
                        break;
                    case 4:
                        eliminarAssignatura(CD);
                        break;
                    case 5:
                        on = false;
                        break;
                    default:
                        escriureError(1);
                        break;
                }
            }
        }

        // Operacions

        public static void llistarAssignatures(CapaDomini CD) {

        }

        public static void afegirAssignatura(CapaDomini CD) {

        }

        public static void modificarAssignatura(CapaDomini CD) {

        }

        public static void eliminarAssignatura(CapaDomini CD) {

        }

public class Main {

    /////////////////////////////////////////////////////////////////
    /// GENERAR HORARI
    /////////////////////////////////////////////////////////////////

    private void menuGenerarHorari() {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            accio = scanner.nextInt();
            switch (accio) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

    private static void generarHorari () {

    }

    private static void mostrarHorari () {

    }


    private static void escriureMenuPrincipal() {
        System.out.println("");
        System.out.println("1] Gestió Configuració");
        System.out.println("2] Generar Horari");
        System.out.println("3] Gestió Pla d'Estudis");
        System.out.println("0] Sortir de l'aplicació");
    }

    private static void escriureError(int nError) {
        switch (nError){
            case 1:
                System.out.println("Error: Indica una de les opcions!");
                break;
        }
    }

    public static void main(String[] args) {

        PlaEstudis pe = new PlaEstudis();

        JSONParser parser = new JSONParser();
>>>>>>> 667ed0551a4d9dbc069cc04cb44ab1d981bc9823

        try {
            JSONArray arrayAules = (JSONArray) parser.parse(new FileReader("./src/Dades/aules.json"));

            for (int i = 0; i < arrayAules.size(); i++) {

                Aula a = new Aula();

                JSONObject jsonObject = (JSONObject) arrayAules.get(i);

                String id = (String) jsonObject.get("id");

                Integer capacitat = (int) (long) jsonObject.get("capacitat");

                String tipus = (String) jsonObject.get("tipus");

                a.setId(id);
                a.setCapacitat(capacitat);
                Enumeracio.TipusAula tAula = tipus == "TEORIA" ? Enumeracio.TipusAula.TEORIA : Enumeracio.TipusAula.LABORATORI;
                a.setTipus(tAula);

                pe.afegirAula(a);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
