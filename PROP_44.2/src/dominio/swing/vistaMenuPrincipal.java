package dominio.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaMenuPrincipal {
    private JButton sortirButton;
    private JButton generarHorariButton;
    private JButton carregarSetDeDadesButton;
    private JButton guardarHorariButton;
    private JButton carregarHorariButton;
    private JPanel menuPrincipal;

    static public JFrame getVista() {
        return vista;
    }

    static JFrame vista = new JFrame();

    public vistaMenuPrincipal() {
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        carregarSetDeDadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaCarregarSetDades.loadCarregarSetDades();
            }
        });
    }

    public static void main(String[] args) {
        vista.setContentPane(new vistaMenuPrincipal().menuPrincipal);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.pack();
        vista.setVisible(true);
    }
}
