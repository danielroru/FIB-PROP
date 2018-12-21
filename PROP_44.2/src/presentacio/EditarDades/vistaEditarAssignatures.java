package presentacio.EditarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaEditarAssignatures extends JFrame{

    private JLabel titol = new JLabel("Editar Assignatura ");

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

        nom.setBounds(50, 90, 100, 30);
        add(nom);

        TNom.setBounds(190, 90, 200, 30);
        add(TNom);

        //----------------------------------------------------

        /* Editar Hora Teoria */

        HTeo.setBounds(50, 130, 140,30);
        add(HTeo);

        SHTeo.setBounds(190, 130, 70, 30);
        add(SHTeo);

        /* Editar Hora Laboratori */

        HLab.setBounds(280, 130, 160,30);
        add(HLab);

        SHLab.setBounds(440, 130, 70, 30);
        add(SHLab);

        /* Editar Hora Problemes */

        HProb.setBounds(520, 130, 160,30);
        add(HProb);

        SHProb.setBounds(680, 130, 70, 30);
        add(SHProb);

        //----------------------------------------------------

        /* Editar N Grups Teoria */

        NGrupsT.setBounds(50, 170, 140,30);
        add(NGrupsT);

        SNGrupsT.setBounds(190, 170, 70, 30);
        add(SNGrupsT);

        /* Editar N Grups Laboratori */

        NGrupsL.setBounds(280, 170, 160,30);
        add(NGrupsL);

        SNGrupsL.setBounds(440, 170, 70, 30);
        add(SNGrupsL);

        /* Editar N Grups Problemes */

        NGrupsP.setBounds(520, 170, 160,30);
        add(NGrupsP);

        SNGrupsP.setBounds(680, 170, 70, 30);
        add(SNGrupsP);

        //----------------------------------------------------

        /* Editar Nombre Grups Franja Matí */

        NGrupsFranjaMati.setBounds(50, 210, 140, 30);
        add(NGrupsFranjaMati);

        SNGrupsFranjaMati.setBounds(190, 210, 200, 30);
        add(SNGrupsFranjaMati);

        //----------------------------------------------------

        /* Editar Blocs Hores Teoria */

        BHoresT.setBounds(50, 250, 140,30);
        add(BHoresT);

        SBHoresT.setBounds(190, 250, 70, 30);
        add(SBHoresT);

        /* Editar Blocs Hores Laboratori */

        BHoresL.setBounds(280, 250, 160,30);
        add(BHoresL);

        SBHoresL.setBounds(440, 250, 70, 30);
        add(SBHoresL);

        /* Editar Blocs Hores Problemes */

        BHoresP.setBounds(520, 250, 160,30);
        add(BHoresP);

        SBHoresP.setBounds(680, 250, 70, 30);
        add(SBHoresP);

        //----------------------------------------------------

        /* Editar Nombre Alumnes Teoria */

        NAlumnesT.setBounds(50, 290, 140,30);
        add(NAlumnesT);

        SNAlumnesT.setBounds(190, 290, 70, 30);
        add(SNAlumnesT);

        /* Editar Nombre Alumnes Laboratori */

        NAlumnesL.setBounds(280, 290, 160,30);
        add(NAlumnesL);

        SNAlumnesL.setBounds(440, 290, 70, 30);
        add(SNAlumnesL);

        /* Editar Nombre Alumnes Problemes */

        NAlumnesP.setBounds(520, 290, 160,30);
        add(NAlumnesP);

        SNAlumnesP.setBounds(680, 290, 70, 30);
        add(SNAlumnesP);

        //----------------------------------------------------

        /* Editar Nivell */


        nivell.setBounds(50, 330, 100, 30);
        add(nivell);

        Snivell.setBounds(190, 330, 200, 30);
        add(Snivell);

        //----------------------------------------------------

        /* Editar Botó Editar */

        editarButton.setBounds(50, 425, 100, 30);
        add(editarButton);

        /* Botó Endarrere */

        endarrereButton.setBounds(650, 425, 100, 30);
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
