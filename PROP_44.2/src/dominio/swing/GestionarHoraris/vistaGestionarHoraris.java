package dominio.swing.GestionarHoraris;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class vistaGestionarHoraris extends JFrame {


    private JLabel titolVista = new JLabel("Gestionar Horaris");

    private JButton generarHorariButton = new JButton("Generar Horari");
    private JButton guardarHorariButton = new JButton("Guardar Horari");
    private JButton carregarHorariButton = new JButton("Carregar Horari");

    private JButton endarrereButton = new JButton("Endarrere");

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaGestionarHoraris() {
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        /* Títol Vista */

        titolVista.setBounds(100,50,200,30);
        add(titolVista);

        /* Botó Generar Horari */

        generarHorariButton.setBounds(50, 150, 200, 30);
        add(generarHorariButton);

        /* Botó Guardar Horari */

        guardarHorariButton.setBounds(50, 190, 200, 30);
        add(guardarHorariButton);

        /* Botó Carregar Horari */

        carregarHorariButton.setBounds(50, 230, 200, 30);
        add(carregarHorariButton);

        /* Botó Endarrere */

        endarrereButton.setBounds(50,270,200,30);
        add(endarrereButton);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener generarHorari = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.generarHorari();
                setVisible(false);
            }

        };

        ActionListener guardarHorari = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooserGuardarHorari = new JFileChooser();;
                chooserGuardarHorari.setDialogTitle("Guardar Horari");
                chooserGuardarHorari.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/persistencia/Horaris"));
                int returnValue = chooserGuardarHorari.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooserGuardarHorari.getSelectedFile();
                    iCtrlPresentacio.guardarHorari(arxiu.getAbsolutePath());
                }
            }

        };

        ActionListener carregarHorari = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooserCarregarHorari = new JFileChooser();;
                chooserCarregarHorari.setDialogTitle("Carregar Horari");
                chooserCarregarHorari.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/persistencia/Horaris"));
                int returnValue = chooserCarregarHorari.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooserCarregarHorari.getSelectedFile();
                    iCtrlPresentacio.carregarHorari(arxiu.getAbsolutePath());
                }
            }

        };

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.inicialitzarPresentacio();
                setVisible(false);
            }

        };

        generarHorariButton.addActionListener(generarHorari);
        guardarHorariButton.addActionListener(guardarHorari);
        carregarHorariButton.addActionListener(carregarHorari);
        endarrereButton.addActionListener(vistaPrincipal);

    }

}
