package dominio.swing;

import javax.swing.*;

public class vistaCarregarSetDades {
    private JComboBox comboBox1;
    private JPanel carregarSetDades;

    static public void loadCarregarSetDades() {
        JFrame vista = vistaMenuPrincipal.getVista();
        vista.setContentPane(new vistaCarregarSetDades().carregarSetDades);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.pack();
        vista.setVisible(true);
    }
}
