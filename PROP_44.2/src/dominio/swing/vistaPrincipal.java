package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = jfc.showOpenDialog(null);
                // int returnValue = jfc.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    System.out.println(selectedFile.getAbsolutePath());
                }
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
