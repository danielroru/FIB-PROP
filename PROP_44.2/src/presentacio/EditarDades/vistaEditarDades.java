package presentacio.EditarDades;

import dominio.controladores.CtrlDomini;
import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class vistaEditarDades extends JFrame {

    String[] conjuntAules = {"No hi ha totes les dades carregades"};
    String[] conjuntAssignatures = {"No hi ha totes les dades carregades"};

    private JLabel titolVista = new JLabel("Editar Dades");
    private JLabel titolAula = new JLabel("Conjunt Aules:");
    private JLabel titolAssignatures = new JLabel("Conjunt Assignatures:");
    private JButton botoPlaEstudis = new JButton("Editar Pla Estudis");
    private JComboBox<String> aules = new JComboBox<String>(conjuntAules);
    private JComboBox<String> assignatures = new JComboBox<String>(conjuntAssignatures);
    private JButton endarrereButton = new JButton("Endarrere");

    public vistaEditarDades() {
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        if (complet) {
            String[] result = (CtrlPresentacio.llistarAssigs()).toArray(new String[CtrlPresentacio.llistarAssigs().size()]);
            assignatures = new JComboBox<String>(result);
        }

        if (complet) {
            String[] result = (CtrlPresentacio.llistarAules()).toArray(new String[CtrlPresentacio.llistarAules().size()]);
            aules = new JComboBox<String>(result);
        }

        /* Títol Vista */

        titolVista.setBounds(150,50,120,30);
        add(titolVista);

        /* Títol Aules */

        titolAula.setBounds(50,190,200,30);
        add(titolAula);

        /* Selecció Aules */


        aules.setBounds(50,220,300,30);
        add(aules);

        /* Títol Assignatures */

        titolAssignatures.setBounds(50,270,200,30);
        add(titolAssignatures);

        /* Selecció Assignatures */


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
                
                String aula = aules.getSelectedItem().toString();
                String[] resultat = iCtrlPresentacio.informacioAula(aula);
                CtrlPresentacio.anarVistaEditarAula(resultat);
                setVisible(false);
            }
        };

        ActionListener vistaAssignatura = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                String assignatura = assignatures.getSelectedItem().toString();
                String[] assig = iCtrlPresentacio.informacioAssignatura(assignatura);
                CtrlPresentacio.anarVistaEditarAssignatures(assig);
                setVisible(false);
            }
        };

        ActionListener vistaEditarPlaEstudis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacio.anarVistaEditarPlaEstudis();
                setVisible(false);
            }

        };

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacio.inicialitzarPresentacio();
                setVisible(false);
            }

        };

        botoPlaEstudis.addActionListener(vistaEditarPlaEstudis);
        aules.addActionListener(vistaAula);
        assignatures.addActionListener(vistaAssignatura);
        endarrereButton.addActionListener(vistaPrincipal);

    }

}
