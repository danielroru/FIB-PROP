package dominio.controladores;

import dominio.vistes.*;

public class CtrlPresentacio {

    private static CtrlPresentacio instance = new CtrlPresentacio();
    private static CtrlDomini cD = CtrlDomini.getInstance();
    private static VistaPrincipal vP = VistaPrincipal.getInstance();
    private static VistaEscriureHorari vEH = VistaEscriureHorari.getInstance();

    private CtrlPresentacio() {

    }

    public static CtrlPresentacio getInstance() {
        return instance;
    }


    public static void inicialitzarPresentacio() {
        int accio;
        do {
            vP.menuPrincipal();
            try {
                accio = vP.readint();
            }
            catch (Exception e) {
                accio = 0;
                System.out.println("Error al seleccionar la opció");
            }
            switch (accio) {
                case 1:
                    cD.carregarDades();
                    break;
                case 2:
                    cD.generarHorari();
                    break;
                case 3:
                    cD.guardarHorari();
                    break;
                case 4:
                    cD.carregarHorari();
                    break;
                default:
                    accio = 0;
                    break;
            }


        } while (accio != 0);
    }


    public static void imprimirHorari(String[] horari) {
        vEH.imprimirHorari(horari);
    }

}
