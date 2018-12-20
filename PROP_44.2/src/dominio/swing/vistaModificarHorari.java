package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vistaModificarHorari extends JFrame {

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();
    private JButton endarrereButton;
    private JPanel modificarHorari;

    public vistaModificarHorari() {
        setSize(400, 600);
        setLocationRelativeTo(null);
        setContentPane(modificarHorari);
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
