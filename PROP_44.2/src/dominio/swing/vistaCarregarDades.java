package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class vistaCarregarDades extends JFrame{
    private JButton carregarDadesDUnaButton;
    private JButton carregarFitxerDePlaButton;
    private JButton carregarFitxerDAulesButton;
    private JButton carregarFitxerDAssignaturesButton;
    private JPanel carregaDades;
    private JButton endarreraButton;

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaCarregarDades() {
        setSize(400, 600);
        setLocationRelativeTo(null);
        setContentPane(carregaDades);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carregarDadesDUnaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                chooser.setDialogTitle("Selecciona la carpeta que conté el set de dades");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/persistencia/dades"));
                int returnValue = chooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooser.getSelectedFile();
                    System.out.println("Carpeta escollida: " + arxiu.getAbsolutePath());
                    CtrlPresentacio.carregarSetByCarpeta(arxiu.getAbsolutePath());
                }
            }
        });


        endarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener vistaPrincipal = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        iCtrlPresentacio.inicialitzarPresentacio();
                        setVisible(false);
                    }

                };
            }
        });
    }
}
