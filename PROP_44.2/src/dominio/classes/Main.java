package dominio.classes;

import dominio.controladores.*;

public class Main {


    public static void main(String[] args) {
        // menuGenerarHorari();

        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        CtrlPresentacio.inicialitzarPresentacio();
                    }
                }
        );
    }
}
