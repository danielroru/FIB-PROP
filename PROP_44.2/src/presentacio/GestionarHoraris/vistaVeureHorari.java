package presentacio.GestionarHoraris;

import com.sun.org.apache.bcel.internal.generic.NEW;
import dominio.controladores.CtrlPresentacio;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class vistaVeureHorari extends JFrame {

    static Object[][] data = {
            {"Hora", "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres"},
            {"8", "----", "----","----", "----", "----"},
            {"9", "----", "----","----", "----", "----"},
            {"10", "----", "----","----", "----", "----"},
            {"11", "----", "----","----", "----", "----"},
            {"12", "----", "----","----", "----", "----"},
            {"13", "----", "----","----", "----", "----"},
            {"14", "----", "----","----", "----", "----"},
            {"15", "----", "----","----", "----", "----"},
            {"16", "----", "----","----", "----", "----"},
            {"17", "----", "----","----", "----", "----"},
            {"18", "----", "----","----", "----", "----"},
            {"19", "----", "----","----", "----", "----"}

    };

    static String[] columnNames = {"Hora","Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres"};

    String[] conjuntAules = {"No hi ha totes les dades carregades"};

    String[] dies = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres"};
    String[] hores = {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};




    private JLabel titol = new JLabel("Generar Horari");
    private JLabel seleccioAules = new JLabel("Seleccionar Aula:");

    private JLabel titolOld = new JLabel("Informació Antiga:");
    private JComboBox OLDd = new JComboBox(dies);
    private JComboBox OLDh = new JComboBox(hores);
    private JComboBox OLDa = new JComboBox(conjuntAules);

    private JLabel titolNew = new JLabel("Informació Nova:");
    private JComboBox NEWd = new JComboBox(dies);
    private JComboBox NEWh = new JComboBox(hores);
    private JComboBox NEWa = new JComboBox(conjuntAules);

    private JButton modificarButton = new JButton("Modificar");
    private JButton endarrereButton = new JButton("Endarrere");
    private JTable horari = new JTable(data, columnNames);
    private JComboBox<String> aules = new JComboBox<String>(conjuntAules);
    private JTextField tf = new JTextField(128);

    private ArrayList<Pair<String, String[][][]>> horariImprimir;
    private Object[][] informacioHorari = new Object[14][6];

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    private String[] cjtAules;
    private String info;

    private void imprimirAula(String info) {

        informacioHorari[0][0] = "Hora";
        informacioHorari[0][1] = "Dilluns";
        informacioHorari[0][2] = "Dimarts";
        informacioHorari[0][3] = "Dimecres";
        informacioHorari[0][4] = "Dijous";
        informacioHorari[0][5] = "Divendres";

        String[][][] valor = null;

        for (Pair<String, String[][][]> a : horariImprimir) {
            if (a.getKey().equals(info))
                valor = a.getValue();


        }

        if (valor != null) {

            for (int hora = 0; hora < 12; ++hora) {
                informacioHorari[hora + 1][0] = 8 + hora;
                for (int dia = 0; dia < 5; ++dia) {
                    if (valor[dia][hora][0] != null)
                        informacioHorari[hora + 1][dia + 1] = valor[dia][hora][0] + " " + valor[dia][hora][1] + " " + valor[dia][hora][2];
                    else informacioHorari[hora + 1][dia + 1] = "----";

                }
            }
        }


    }

    public vistaVeureHorari(ArrayList<Pair<String, String[][][]>> horariImprimir, String seleccionar, boolean complet) {


        if (complet == true) {
            info = seleccionar;
            this.horariImprimir = horariImprimir;

            cjtAules = new String[horariImprimir.size()];
            int i = 0;

            for (Pair<String, String[][][]> aula : horariImprimir) {
                cjtAules[i] = aula.getKey();
                ++i;
            }

            if (seleccionar == null && horariImprimir.size() != 0) {
                Pair<String, String[][][]> aula = horariImprimir.get(0);
                info = aula.getKey();
            }

            imprimirAula(info);

            imprimirAula(info);

            aules = new JComboBox(cjtAules);
            OLDa = new JComboBox(cjtAules);
            NEWa = new JComboBox(cjtAules);
            aules.setSelectedItem(info);
            horari = new JTable(informacioHorari, columnNames);
        }
        setSize(700, 700);
        setLocationRelativeTo(null);
        setLayout(null);

        /* Títol */

        titol.setBounds(300,50,200,30);
        add(titol);


        /* Títol Selecció Aula*/

        seleccioAules.setBounds(50, 175, 150, 30);
        add(seleccioAules);

        /* Selecció Aula */

        aules.setBounds(200, 175, 280, 30);
        add(aules);


        /* Taula */

        horari.setBounds(50,250,600,210);
        add(horari);


        /* Modificar: OLD UAH */

        titolOld.setBounds(50,490,150,30);
        add(titolOld);

        OLDd.setBounds(50,520,100,30);
        add(OLDd);

        OLDh.setBounds(150,520,70,30);
        add(OLDh);

        OLDa.setBounds(220,520,290,30);
        add(OLDa);


        /* Modificar: NEW UAH */

        titolNew.setBounds(50,570,120,30);
        add(titolNew);

        NEWd.setBounds(50,600,100,30);
        add(NEWd);

        NEWh.setBounds(150,600,70,30);
        add(NEWh);

        NEWa.setBounds(220,600,290,30);
        add(NEWa);


        /* Botó Modificar */

        modificarButton.setBounds(530,520,120,30);
        add(modificarButton);

        /* Botó Endarrere */

        endarrereButton.setBounds(530,600,120,30);
        add(endarrereButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ActionListener modificarDades = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String oldDia = OLDd.getSelectedItem().toString();
                String oldHora = OLDh.getSelectedItem().toString();
                String oldAula = OLDa.getSelectedItem().toString();

                String newDia = NEWd.getSelectedItem().toString();
                String newHora = NEWh.getSelectedItem().toString();
                String newAula = NEWa.getSelectedItem().toString();

                iCtrlPresentacio.modificarDades(oldDia, oldHora, oldAula, newDia, newHora, newAula);
                setVisible(false);

            }
        };

        ActionListener seleccioAules = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = aules.getSelectedItem().toString();
                iCtrlPresentacio.vistaHorari(horariImprimir, info, true);
                setVisible(false);
            }
        };

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.vistaGestionarHoraris();
                setVisible(false);
            }

        };

        modificarButton.addActionListener(modificarDades);
        aules.addActionListener(seleccioAules);
        endarrereButton.addActionListener(vistaPrincipal);
    }

}
