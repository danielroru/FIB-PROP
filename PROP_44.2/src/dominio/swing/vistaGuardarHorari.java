package dominio.swing.C_GuardarHorari;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaGuardarHorari extends JFrame{

    private JLabel titol = new JLabel("Guardar Horari");
    private JLabel seleccioDades = new JLabel("Nom del fitxer: ");
    private JTextField documentCarregar = new JTextField();
    private JButton endarrereButton = new JButton("Endarrere");

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaGuardarHorari() {

        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        /* Títol */

        titol.setBounds(150,30,200,30);
        add(titol);

        /* Títol Document Guardar */

        seleccioDades.setBounds(50, 110, 150, 30);
        add(seleccioDades);

        /* Selecció Aula */

        documentCarregar.setBounds(50, 140, 200, 30);
        add(documentCarregar);

        /* Botó Endarrere */

        endarrereButton.setBounds(230,220,120,30);
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

        ActionListener carregarInformacio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.carregarDades(documentCarregar.getText());
                setVisible(false);
            }

        };

        endarrereButton.addActionListener(vistaPrincipal);
        documentCarregar.addActionListener(carregarInformacio);
    }


}
