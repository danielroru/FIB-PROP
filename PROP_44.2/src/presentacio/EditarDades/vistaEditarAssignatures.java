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


    public vistaEditarAssignatures(String[] assignatura, boolean complet) {

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

        if (complet) TNom = new JTextField(assignatura[0]);
        TNom.setBounds(190, 90, 200, 30);
        add(TNom);

        //----------------------------------------------------

        /* Editar Hora Teoria */

        // (Integer)miJSpinner.getValue();

        HTeo.setBounds(50, 130, 140,30);
        add(HTeo);

        if (complet) SHTeo.setValue(Integer.valueOf(assignatura[2]));
        SHTeo.setBounds(190, 130, 70, 30);
        add(SHTeo);

        /* Editar Hora Laboratori */

        HLab.setBounds(280, 130, 160,30);
        add(HLab);

        if (complet) SHLab.setValue(Integer.valueOf(assignatura[3]));
        SHLab.setBounds(440, 130, 70, 30);
        add(SHLab);

        /* Editar Hora Problemes */

        HProb.setBounds(520, 130, 160,30);
        add(HProb);

        if (complet) SHProb.setValue(Integer.valueOf(assignatura[4]));
        SHProb.setBounds(680, 130, 70, 30);
        add(SHProb);

        //----------------------------------------------------

        /* Editar N Grups Teoria */

        NGrupsT.setBounds(50, 170, 140,30);
        add(NGrupsT);

        if (complet) SNGrupsT.setValue(Integer.valueOf(assignatura[5]));
        SNGrupsT.setBounds(190, 170, 70, 30);
        add(SNGrupsT);

        /* Editar N Grups Laboratori */

        NGrupsL.setBounds(280, 170, 160,30);
        add(NGrupsL);

        if (complet) SNGrupsL.setValue(Integer.valueOf(assignatura[6]));
        SNGrupsL.setBounds(440, 170, 70, 30);
        add(SNGrupsL);

        /* Editar N Grups Problemes */

        NGrupsP.setBounds(520, 170, 160,30);
        add(NGrupsP);

        if (complet) SNGrupsP.setValue(Integer.valueOf(assignatura[7]));
        SNGrupsP.setBounds(680, 170, 70, 30);
        add(SNGrupsP);

        //----------------------------------------------------

        /* Editar Nombre Grups Franja Matí */

        NGrupsFranjaMati.setBounds(50, 210, 140, 30);
        add(NGrupsFranjaMati);

        if (complet) SNGrupsFranjaMati.setValue(Integer.valueOf(assignatura[8]));
        SNGrupsFranjaMati.setBounds(190, 210, 200, 30);
        add(SNGrupsFranjaMati);

        //----------------------------------------------------

        /* Editar Blocs Hores Teoria */

        BHoresT.setBounds(50, 250, 140,30);
        add(BHoresT);

        if (complet) SBHoresT.setValue(Integer.valueOf(assignatura[12]));
        SBHoresT.setBounds(190, 250, 70, 30);
        add(SBHoresT);

        /* Editar Blocs Hores Laboratori */

        BHoresL.setBounds(280, 250, 160,30);
        add(BHoresL);

        if (complet) SBHoresL.setValue(Integer.valueOf(assignatura[13]));
        SBHoresL.setBounds(440, 250, 70, 30);
        add(SBHoresL);

        /* Editar Blocs Hores Problemes */

        BHoresP.setBounds(520, 250, 160,30);
        add(BHoresP);

        if (complet) SBHoresP.setValue(Integer.valueOf(assignatura[14]));
        SBHoresP.setBounds(680, 250, 70, 30);
        add(SBHoresP);

        //----------------------------------------------------

        /* Editar Nombre Alumnes Teoria */

        NAlumnesT.setBounds(50, 290, 140,30);
        add(NAlumnesT);

        if (complet) SNAlumnesT.setValue(Integer.valueOf(assignatura[9]));
        SNAlumnesT.setBounds(190, 290, 70, 30);
        add(SNAlumnesT);

        /* Editar Nombre Alumnes Laboratori */

        NAlumnesL.setBounds(280, 290, 160,30);
        add(NAlumnesL);

        if (complet) SNAlumnesL.setValue(Integer.valueOf(assignatura[10]));
        SNAlumnesL.setBounds(440, 290, 70, 30);
        add(SNAlumnesL);

        /* Editar Nombre Alumnes Problemes */

        NAlumnesP.setBounds(520, 290, 160,30);
        add(NAlumnesP);

        if (complet) SNAlumnesP.setValue(Integer.valueOf(assignatura[11]));
        SNAlumnesP.setBounds(680, 290, 70, 30);
        add(SNAlumnesP);

        //----------------------------------------------------

        /* Editar Nivell */


        nivell.setBounds(50, 330, 100, 30);
        add(nivell);

        if (complet) Snivell.setValue(Integer.valueOf(assignatura[1]));
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

                String[] info = new String[15];
                info[0] = TNom.getText();
                info[1] = String.valueOf(Snivell.getValue());
                info[2] = String.valueOf(SHTeo.getValue());
                info[3] = String.valueOf(SHLab.getValue());
                info[4] = String.valueOf(SHProb.getValue());
                info[5] = String.valueOf(SNGrupsT.getValue());
                info[6] = String.valueOf(SNGrupsL.getValue());
                info[7] = String.valueOf(SNGrupsP.getValue());
                info[8] = String.valueOf(SNGrupsFranjaMati.getValue());
                info[9] = String.valueOf(SNAlumnesT.getValue());
                info[10] = String.valueOf(SNAlumnesL.getValue());
                info[11] = String.valueOf(SNAlumnesP.getValue());
                info[12] = String.valueOf(SBHoresT.getValue());
                info[13] = String.valueOf(SBHoresL.getValue());
                info[14] = String.valueOf(SBHoresP.getValue());


                CtrlPresentacio.guardarAssignatura(info);

                CtrlPresentacio.anarVistaEditarDades();
                setVisible(false);
            }

        };

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacio.anarVistaEditarDades();
                setVisible(false);
            }

        };

        editarButton.addActionListener(editarInformacio);
        endarrereButton.addActionListener(vistaPrincipal);

    }

}
