package presentacio.EditarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class vistaEditarPlaEstudis extends JFrame {



    private JLabel titolVista = new JLabel("Editar Pla Estudis");

    private JLabel titolHoraInici = new JLabel("Hora Inici:");
    private JLabel titolHoraCanviFranja = new JLabel("Hora Canvi Franja:");
    private JLabel titolHoraFi = new JLabel("Hora Fi:");

    private JTextField textHoraInici = new JTextField();
    private JTextField textHoraCanviFranja = new JTextField();
    private JTextField textHoraFi = new JTextField();

    private JButton editarButton = new JButton("Editar");
    private JButton endarrereButton = new JButton("Endarrere");

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaEditarPlaEstudis(boolean complet) {

        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        if (complet) {
            String[] horas = iCtrlPresentacio.cercaInfoPE();
            textHoraInici = new JTextField(horas[0]);
            textHoraCanviFranja = new JTextField(horas[1]);
            textHoraFi = new JTextField(horas[2]);
        }

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
                String[] info = new String[3];
                info[0] = textHoraInici.getText();
                info[1] = textHoraCanviFranja.getText();
                info[2] = textHoraFi.getText();
                iCtrlPresentacio.editarInformacio(info);
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
