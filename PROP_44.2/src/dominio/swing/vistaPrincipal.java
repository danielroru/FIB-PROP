package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaPrincipal extends JFrame{

    private JButton carregarDadesButton;
    private JButton generarHorariButton;
    private JButton guardarHorariButton;
    private JButton carregarHorariButton;
    private JButton modificarHorariButton;
    private JButton editarDadesButton;
    private JButton sortirButton;

    private JPanel panelContinguts;

    private CtrlPresentacio pCtrPresentacio = CtrlPresentacio.getInstance();

    boolean valor = false;

    //private int iPanelActivo = 0;

    //static JFrame frameVista = new JFrame("Generador d'horaris");


    public vistaPrincipal() {
        carregarDadesButton = new JButton();
        generarHorariButton  = new JButton();
        guardarHorariButton  = new JButton();
        carregarDadesButton  = new JButton();
        carregarDadesButton = new JButton();
        modificarHorariButton  = new JButton();
        editarDadesButton = new JButton();
        sortirButton = new JButton();

        panelContinguts = new JPanel();
        setSize(400, 600);
        setLocationRelativeTo(null);
        setContentPane(panelContinguts);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ActionListener carregarDades = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCtrPresentacio.vistaCarregarDades();
                setVisible(false);
            }

        };

        ActionListener generarHorari = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCtrPresentacio.vistaGenerarHorari();
                setVisible(false);
            }

        };

        ActionListener guardarHorari = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCtrPresentacio.vistaGuardarHorari();
                setVisible(false);
            }

        };

        ActionListener carregarHorari = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCtrPresentacio.vistaCarregarHorari();
                setVisible(false);
            }

        };

        ActionListener modificarHorari = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCtrPresentacio.vistaModificarHorari();
                setVisible(false);
            }

        };

        ActionListener editarDades = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCtrPresentacio.vistaEditarDades();
                setVisible(false);
            }

        };

        ActionListener sortir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        };
        carregarDadesButton.addActionListener(carregarDades);
        generarHorariButton.addActionListener(generarHorari);
        guardarHorariButton.addActionListener(guardarHorari);
        carregarHorariButton.addActionListener(carregarHorari);
        modificarHorariButton.addActionListener(modificarHorari);
        editarDadesButton.addActionListener(editarDades);
        sortirButton.addActionListener(sortir);
    }
}
