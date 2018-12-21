package dominio.swing.EditarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaEditarDades extends JFrame {

    String[] conjuntAules = {"No hi ha totes les dades carregades"};
    String[] conjuntAssignatures = {"No hi ha totes les dades carregades"};

    private JLabel titolVista = new JLabel("Editar Dades");
    private JLabel titolAula = new JLabel("Conjunt Aules:");
    private JLabel titolAssignatures = new JLabel("Conjunt Assignatures:");
    private JButton botoPlaEstudis = new JButton("Editar Pla Estudis");
    private JComboBox aules = new JComboBox(conjuntAules);
    private JComboBox assignatures = new JComboBox(conjuntAssignatures);
    private JButton endarrereButton = new JButton("Endarrere");

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaEditarDades(boolean valid) {
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        /* Títol Vista */

        titolVista.setBounds(150,50,120,30);
        add(titolVista);

        /* Títol Aules */

        titolAula.setBounds(50,190,200,30);
        add(titolAula);

        /* Selecció Aules */


        if (valid) {
            String[] idAules = iCtrlPresentacio.llistarAules();
            aules = new JComboBox(idAules);
        }

        aules.setBounds(50,220,300,30);
        add(aules);

        /* Títol Assignatures */

        titolAssignatures.setBounds(50,270,200,30);
        add(titolAssignatures);

        /* Selecció Assignatures */


        if (valid) {
            String[] nomAssig = iCtrlPresentacio.llistarAssigs();
            aules = new JComboBox(nomAssig);
        }

        assignatures.setBounds(50,300,300,30);
        add(assignatures);

        /* Botó Modificar Dades */

        botoPlaEstudis.setBounds(50, 370, 300, 30);
        add(botoPlaEstudis);

        /* Botó Endarrere */

        endarrereButton.setBounds(230,500,120,30);
        add(endarrereButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener vistaAula = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.vistaEditarAula();
                setVisible(false);
            }
        };

        ActionListener vistaAssignatura = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.vistaEditarAssignatures();
                setVisible(false);
            }
        };

        ActionListener vistaEditarPlaEstudis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.vistaEditarPlaEstudis();
                setVisible(false);
            }

        };

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.inicialitzarPresentacio();
                setVisible(false);
            }

        };

        botoPlaEstudis.addActionListener(vistaEditarPlaEstudis);
        aules.addActionListener(vistaAula);
        assignatures.addActionListener(vistaAssignatura);
        endarrereButton.addActionListener(vistaPrincipal);

    }

}
