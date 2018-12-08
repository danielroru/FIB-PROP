package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaPrincipal {

    private JButton sortirButton;
    private JButton generarHorariButton;
    private JButton carregarSetDeDadesButton;
    private JButton guardarHorariButton;
    private JButton carregarHorariButton;
    private JPanel menuPrincipal;

    static JFrame vista = new JFrame();

    private CtrlPresentacio iCtrlPresentacio;

    public vistaPrincipal(CtrlPresentacio pCtrPresentacio) {

        iCtrlPresentacio = pCtrPresentacio;

        // Inicialitzar components!

        vista.setContentPane(new vistaPrincipal().menuPrincipal);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public vistaPrincipal() {
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        carregarSetDeDadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void ferVisible() {
        vista.pack();
        vista.setVisible(true);
    }

    // Activar o desactivar
    public void canviarEstat(boolean estat) {
        vista.setEnabled(estat);
    }


}
