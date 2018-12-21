package presentacio;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaPrincipal extends JFrame {

    private JLabel titolVista = new JLabel("Generador Horaris");

    private JButton carregarDadesButton = new JButton("Carregar Dades");
    private JButton generarHorariButton = new JButton("Gestionar Horaris");
    private JButton editarDadesButton = new JButton("Editar Dades");
    private JButton sortirButton = new JButton("Sortir");


    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();




    public vistaPrincipal() {

        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Menú Principal");

        /* Títol Vista */

        titolVista.setBounds(100,50,120,30);
        add(titolVista);


        /* Botó Carregar Dades */

        carregarDadesButton.setBounds(50,150,200,30);
        add(carregarDadesButton);

        /* Botó Gestio Horaris */

        generarHorariButton.setBounds(50,190,200,30);
        add(generarHorariButton);

        /* Botó Editar Dades */

        editarDadesButton.setBounds(50,230,200,30);
        add(editarDadesButton);


        /* Botó Sortir */

        sortirButton.setBounds(50,270,200,30);
        add(sortirButton);



        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ActionListener carregarDades = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.vistaCarregarDades();
                setVisible(false);
            }
        };


        ActionListener gestionarHoraris = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.vistaGestionarHoraris();
                setVisible(false);
            }

        };

        ActionListener editarDades = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.anarVistaEditarDades();
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
        generarHorariButton.addActionListener(gestionarHoraris);
        editarDadesButton.addActionListener(editarDades);
        sortirButton.addActionListener(sortir);
    }
}
