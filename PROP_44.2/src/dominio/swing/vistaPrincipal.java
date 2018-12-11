package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class vistaPrincipal {

    private JButton sortirButton;
    private JButton gestionarDadesButton;
    private JButton carregarSetDeDadesButton;
    private JButton gestionarHorariButton;
    private JPanel menuPrincipal;

    static JFrame vista = new JFrame();

    private CtrlPresentacio iCtrlPresentacio;

    public vistaPrincipal(CtrlPresentacio pCtrPresentacio) {

        iCtrlPresentacio = pCtrPresentacio;

        vista.setContentPane(menuPrincipal);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        carregarSetDeDadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                chooser.setDialogTitle("Selecciona el set d'Assignatures");
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/persistencia"));
                int returnValue = chooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooser.getSelectedFile();
                    System.out.println("Arxiu escollit: " + arxiu.getAbsolutePath());
                    iCtrlPresentacio.carregarSetDades(arxiu.getAbsolutePath());
                }
            }

        });
        gestionarDadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaGestionarDades vista2 = new vistaGestionarDades(iCtrlPresentacio);
                vista2.ferVisible();
            }
        });
        gestionarHorariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaResultatHorari vista2 = new vistaResultatHorari(iCtrlPresentacio);
                vista2.ferVisible();
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
