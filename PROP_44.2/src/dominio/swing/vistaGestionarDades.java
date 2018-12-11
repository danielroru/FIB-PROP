package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaGestionarDades {
    private JPanel vGestio;
    private JButton assignaturesButton;
    private JButton aulesButton;
    private JButton enrereButton;

    private JFrame vista;

    private CtrlPresentacio ctrlPresentacio;


    public vistaGestionarDades(CtrlPresentacio ctrlPresentacioi) {


        //ctrlPresentacio = ctrlPresentacioi;

        vGestio = new JPanel();

        vista = new JFrame();

        vista.setContentPane(vGestio);


        assignaturesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaModificarAula vista2 = new vistaModificarAula(vista);
                vista2.esVisible(true);
            }
        });
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void ferVisible() {
        vista.pack();
        vista.setVisible(true);
    }

    // Activar o desactivar
    public void canviarEstat(boolean estat) {
        vista.setEnabled(estat);
    }
}
