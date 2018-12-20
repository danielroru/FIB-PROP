package dominio.swing.CarregarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class vistaCarregarDades extends JFrame{

    private JLabel titol = new JLabel("Carregar Dades");

    private JButton carregarAssignaturesButton = new JButton("Carregar Assignatures");
    private JButton carregarAulesButton = new JButton("Carregar Aules");
    private JButton carregarPlaEstudisButton = new JButton("Carregar Pla Estudis");

    private JButton endarrereButton = new JButton("Endarrere");

    private CtrlPresentacio iCtrlPresentacio = CtrlPresentacio.getInstance();

    public vistaCarregarDades() {

        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        // Títol

        titol.setBounds(100,70,200,30);
        add(titol);

        // Carregar Assignatures

        carregarAssignaturesButton.setBounds(50, 150, 200, 30);
        add(carregarAssignaturesButton);

        // Carregar Aules

        carregarAulesButton.setBounds(50, 190, 200, 30);
        add(carregarAulesButton);

        // Carregar Pla Estudis

        carregarPlaEstudisButton.setBounds(50, 230, 200, 30);
        add(carregarPlaEstudisButton);

        // Botó Endarrere

        endarrereButton.setBounds(50,270,200,30);
        add(endarrereButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ActionListener carregarAssignatures = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooserAssig = new JFileChooser();
                chooserAssig.setDialogTitle("Seleccionar Assignatures");
                chooserAssig.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/persistencia"));
                int returnValue = chooserAssig.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooserAssig.getSelectedFile();
                    iCtrlPresentacio.carregarDadesAssignatures(arxiu.getAbsolutePath());
                }
            }
        };

        ActionListener carregarAules = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooserAules = new JFileChooser();;
                chooserAules.setDialogTitle("Seleccionar Aules");
                chooserAules.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/persistencia"));
                int returnValue = chooserAules.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooserAules.getSelectedFile();
                    iCtrlPresentacio.carregarDadesAules(arxiu.getAbsolutePath());
                }
            }
        };


        ActionListener carregarPlaEstudis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooserPlaEstudis = new JFileChooser();;
                chooserPlaEstudis.setDialogTitle("Seleccionar Pla Estudis");
                chooserPlaEstudis.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/persistencia"));
                int returnValue = chooserPlaEstudis.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooserPlaEstudis.getSelectedFile();
                    iCtrlPresentacio.carregarDadesPlaEstudis(arxiu.getAbsolutePath());
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

        carregarAssignaturesButton.addActionListener(carregarAssignatures);
        carregarAulesButton.addActionListener(carregarAules);
        carregarPlaEstudisButton.addActionListener(carregarPlaEstudis);
        endarrereButton.addActionListener(vistaPrincipal);

    }

}
