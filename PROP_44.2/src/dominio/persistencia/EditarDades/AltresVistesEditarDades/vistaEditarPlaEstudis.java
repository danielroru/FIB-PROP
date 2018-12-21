package dominio.persistencia.EditarDades.AltresVistesEditarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class vistaEditarPlaEstudis extends JFrame {

    String horaInici = "8";
    String horaCanviFranja = "14";
    String horaFi = "20";

    private JLabel titolVista = new JLabel("Editar Pla Estudis");

    private JLabel titolHoraInici = new JLabel("Hora Inici:");
    private JLabel titolHoraCanviFranja = new JLabel("Hora Canvi Franja:");
    private JLabel titolHoraFi = new JLabel("Hora Fi:");

    private JTextField textHoraInici = new JTextField(horaInici);
    private JTextField textHoraCanviFranja = new JTextField(horaCanviFranja);
    private JTextField textHoraFi = new JTextField(horaFi);

    private JButton editarButton = new JButton("Editar");
    private JButton endarrereButton = new JButton("Endarrere");

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaEditarPlaEstudis() {

        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        /* Títol Vista */

        titolVista.setBounds(150,50,120,30);
        add(titolVista);

        /* ------------------------------------------------------ */

        /* Títol Hora Inici */

        titolHoraInici.setBounds(50,190,200,30);
        add(titolHoraInici);

        /* Text Hora Inici */

        textHoraInici.setBounds(50,220,300,30);
        add(textHoraInici);

        /* ------------------------------------------------------ */

        /* Títol Canvi Franja */

        titolHoraCanviFranja.setBounds(50,270,200,30);
        add(titolHoraCanviFranja);

        /* Text Canvi Franja */

        textHoraCanviFranja.setBounds(50,300,300,30);
        add(textHoraCanviFranja);

        /* ------------------------------------------------------ */

        /* Títol Hora Fi */

        titolHoraFi.setBounds(50, 350, 200, 30);
        add(titolHoraFi);

        /* Text Hora Fi */

        textHoraFi.setBounds(50, 380, 300, 30);
        add(textHoraFi);

        /* ------------------------------------------------------ */

        /* Botó Editar Dades */

        editarButton.setBounds(50,500,120,30);
        add(editarButton);

        /* Botó Endarrere */

        endarrereButton.setBounds(230,500,120,30);
        add(endarrereButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener editarInformacio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.anarVistaEditarDades();
                setVisible(false);
            }

        };

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.anarVistaEditarDades();
                setVisible(false);
            }

        };

        editarButton.addActionListener(editarInformacio);
        endarrereButton.addActionListener(vistaPrincipal);

    }



}
