package presentacio.EditarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class vistaEditarAula extends JFrame {


    private JLabel titolVista = new JLabel("Editar Aula");

    private JLabel titolID = new JLabel("ID:");
    private JLabel titolCapacitat = new JLabel("Capacitat:");
    private JLabel titolTipusAula = new JLabel("Tipus D'Aula:");
    private JLabel titolTeoria = new JLabel("Teoria");
    private JLabel titolLaboratori = new JLabel("Laboratori");

    private JTextField textID = new JTextField();
    private JTextField textCapacitat = new JTextField();
    ButtonGroup group = new ButtonGroup();
    private JRadioButton teoriaRadioButton = new JRadioButton();
    private JRadioButton laboratoriRadioButton = new JRadioButton();

    private JButton editarButton = new JButton("Editar");
    private JButton endarrereButton = new JButton("Endarrere");

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaEditarAula(String[] aula, boolean complet) {
        group.add(teoriaRadioButton);
        group.add(laboratoriRadioButton);

        if (aula[2].equals("TEORIA")){
            teoriaRadioButton.setSelected(true);
        }
        else laboratoriRadioButton.setSelected(true);

        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        /* Títol Vista */

        titolVista.setBounds(150,50,120,30);
        add(titolVista);

        /* ------------------------------------------------------ */

        /* ID */

        titolID.setBounds(50,250,100,30);
        add(titolID);

        if(complet) textID = new JTextField(aula[0]);
        textID.setBounds(150,250,200,30);
        add(textID);

        /* Capacitat */

        if(complet) textCapacitat = new JTextField(aula[1]);
        titolCapacitat.setBounds(50,300,100,30);
        add(titolCapacitat);

        textCapacitat.setBounds(150,300,200,30);
        add(textCapacitat);

        /* Radio Button */

        titolTipusAula.setBounds(50,350,100,30);
        add(titolTipusAula);

        /* Teoria*/

        titolTeoria.setBounds(150,380,120,30);
        add(titolTeoria);

        teoriaRadioButton.setBounds(150,350,120,30);
        add(teoriaRadioButton);

        /* Laboratori */

        titolLaboratori.setBounds(270,380,120,30);
        add(titolLaboratori);

        laboratoriRadioButton.setBounds(270,350,120,30);
        add(laboratoriRadioButton);


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

                String[] aula = new String[3];

                aula[0] = textID.getText();
                aula[1] = textCapacitat.getText();
                System.out.println(group.getSelection());
                if (teoriaRadioButton.isSelected()) {
                    aula[2] = "TEORIA";
                } else {
                    aula[2] = "LABORATORI";
                }

                iCtrlPresentacio.guardarAula(aula);
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
