package dominio.swing.vistaEditarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaEditarDades extends JFrame {

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();
    private JPanel editarDades;
    private JButton endarrereButton;

    public vistaEditarDades() {
        setSize(400, 600);
        setLocationRelativeTo(null);
        setContentPane(editarDades);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iCtrlPresentacio.inicialitzarPresentacio();
                setVisible(false);
            }

        };

        endarrereButton.addActionListener(vistaPrincipal);

    }
}
