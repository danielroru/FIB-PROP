package dominio.swing.EditarDades.AltresVistesEditarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class vistaEditarAssignatures extends JFrame{

    private JLabel titol = new JLabel("Editar Aula");

    private JLabel nom = new JLabel("Nom: ");
    private JLabel HTeo = new JLabel("Hores Teoria: ");
    private JLabel HLab = new JLabel("Hores Laboratori: ");
    private JLabel HProb = new JLabel("Hores Problemes: ");
    private JLabel NGrupsT = new JLabel("Nº Grups Teoria: ");
    private JLabel NGrupsL = new JLabel("Nº Grups Laboratori: ");
    private JLabel NGrupsP = new JLabel("Nº Grups Problemes: ");
    private JLabel NGrupsFranjaMati = new JLabel("Nº Grups Franja Matí: ");
    private JLabel BHoresT = new JLabel("Blocs Hores Teoria: ");
    private JLabel BHoresL = new JLabel("Blocs Hores Laboratori: ");
    private JLabel BHoresP = new JLabel("Blocs Hores Problemes: ");
    private JLabel NAlumnesT = new JLabel("Nº Alumnes Teoria:");
    private JLabel NAlumnesL = new JLabel("Nº Alumnes Laboratori: ");
    private JLabel NAlumnesP = new JLabel("Nº Alumnes Problemes: ");
    private JLabel nivell = new JLabel("Nivell: ");


    private JTextField TNom = new JTextField();
    private JSpinner SHTeo = new JSpinner();
    private JSpinner SHLab = new JSpinner();
    private JSpinner SHProb = new JSpinner();
    private JSpinner SNGrupsT = new JSpinner();
    private JSpinner SNGrupsL = new JSpinner();
    private JSpinner SNGrupsP = new JSpinner();
    private JSpinner SNGrupsFranjaMati = new JSpinner();
    private JSpinner SBHoresT = new JSpinner();
    private JSpinner SBHoresL = new JSpinner();
    private JSpinner SBHoresP = new JSpinner();
    private JSpinner SNAlumnesT = new JSpinner();
    private JSpinner SNAlumnesL = new JSpinner();
    private JSpinner SNAlumnesP = new JSpinner();
    private JSpinner Snivell = new JSpinner();


    private JButton editarButton = new JButton("Editar");
    private JButton endarrereButton = new JButton("Endarrere");

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaEditarAssignatures() {

        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        /* Títol Editar Aula */

        titol.setBounds(350,20,200,30);
        add(titol);

        //----------------------------------------------------

        /* Editar Nom */

        nom.setBounds(50, 80, 100, 30);
        add(nom);

        TNom.setBounds(170, 80, 200, 30);
        add(TNom);

        //----------------------------------------------------

        /* Editar Hora Teoria */

        HTeo.setBounds(50, 110, 120,30);
        add(HTeo);

        SHTeo.setBounds(170, 110, 70, 30);
        add(SHTeo);

        /* Editar Hora Laboratori */

        HLab.setBounds(260, 110, 120,30);
        add(HLab);

        SHLab.setBounds(380, 110, 70, 30);
        add(SHLab);

        /* Editar Hora Problemes */

        HProb.setBounds(470, 110, 120,30);
        add(HProb);

        SHProb.setBounds(590, 110, 70, 30);
        add(SHProb);

        /* Editar Nombre Grups Franja Matí */

        /* Editar Blocs Hores Teoria */

        /* Editar Blocs Hores Laboratori */

        /* Editar Blocs Hores Problemes */

        /* Editar Nombre Alumnes Teoria */

        /* Editar Nombre Alumnes Laboratori */

        /* Editar Nombre Alumnes Problemes */

        /* Editar Nivell */

        /* Editar Botó Editar */

        editarButton.setBounds(50, 425, 100, 30);
        add(editarButton);

        /* Botó Endarrere */

        endarrereButton.setBounds(470, 425, 100, 30);
        add(endarrereButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.inicialitzarPresentacio();
                setVisible(false);
            }

        };

        endarrereButton.addActionListener(vistaPrincipal);

    }

}
