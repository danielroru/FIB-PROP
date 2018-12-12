package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import java.awt.*;

public class vistaPrincipal {

    private JButton gestionarDadesButton = new JButton("Gestionar Dades");
    private JButton carregarSetDeDadesButton = new JButton("Carregar Dades");
    private JButton gestionarHorariButton = new JButton("Gestionar Horari");

    private JPanel panelContinguts = new JPanel();
    private JPanel panelBotons = new JPanel();
    private JPanel panelInformacio = new JPanel();
    private JPanel panelInformacioA = new JPanel();
    private JPanel panelInformacio1 = new JPanel();

    private int iPanelActivo = 0;

    static JFrame frameVista = new JFrame("Generador d'horaris");

    private CtrlPresentacio iCtrlPresentacio;

    public vistaPrincipal(CtrlPresentacio pCtrPresentacio) {

        iCtrlPresentacio = pCtrPresentacio;

        //frameVista.setContentPane(panelContinguts);
        inicialitzarComponents();
        frameVista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**carregarSetDeDadesButton.addActionListener(new ActionListener() {
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
        });**/
    }


    public void ferVisible() {
        frameVista.pack();
        frameVista.setVisible(true);
    }

    private void inicialitzarComponents() {
        inicialitzarFrame();
        inicialitzarPanelContinguts();
        inicialitzarPanelInformacio();
        inicialitzarPanelInformacio1();
    }

    private void inicialitzarFrame() {
        frameVista.setMinimumSize(new Dimension(700,400));
        frameVista.setPreferredSize(frameVista.getMinimumSize());
        frameVista.setResizable(false);
        // Posicion y operaciones por defecto
        frameVista.setLocationRelativeTo(null);
        frameVista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Se agrega panelContenidos al contentPane (el panelContenidos se
        // podria ahorrar y trabajar directamente sobre el contentPane)
        JPanel contentPane = (JPanel) frameVista.getContentPane();
        contentPane.add(panelContinguts);
    }

    private void inicialitzarPanelContinguts() {
        panelContinguts.setLayout(new BorderLayout());

        panelContinguts.add(panelInformacio1,BorderLayout.NORTH);
        //panelContinguts.add(panelInformacion,BorderLayout.CENTER);
    }

    private void inicialitzarPanelInformacio() {
        panelInformacioA = panelInformacio1;
        iPanelActivo = 1;
        panelInformacio.add(panelInformacioA);
    }

    private void inicialitzarPanelInformacio1() {
        panelInformacio1.setLayout(new FlowLayout());
        // Componentes
        panelInformacio1.add(gestionarDadesButton);

    }


}
