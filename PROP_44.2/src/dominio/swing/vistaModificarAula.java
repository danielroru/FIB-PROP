package dominio.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaModificarAula {
    private JPanel vistaModificarAula;
    private JTextField valorID;
    private JFormattedTextField valorCapacitat;
    private JRadioButton teoriaRadioButton;
    private JRadioButton laboratoriRadioButton;

    private JButton guardarButton;
    private JButton cancelarButton;

    private JFrame vista;

    public vistaModificarAula(JFrame vistap) {

        vista = vistap;

        vistap.setContentPane(vistaModificarAula);

        ButtonGroup group = new ButtonGroup();

        group.add(teoriaRadioButton);
        group.add(laboratoriRadioButton);


        teoriaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void esVisible(Boolean accio) {
        vista.pack();
        vista.setVisible(accio);
    }

    // Activar o desactivar
    public void canviarEstat(boolean estat) {
        vista.setEnabled(estat);
    }



}
