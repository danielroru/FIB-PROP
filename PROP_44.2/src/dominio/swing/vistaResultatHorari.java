package dominio.swing;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;

public class vistaResultatHorari {

    String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

    Object[][] data = {
            {"Kathy", "Smith",
                    "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
                    "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
                    "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
                    "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
                    "Pool", new Integer(10), new Boolean(false)}
    };


    private JPanel panel1;
    private JTable table1 = new JTable(data, columnNames);

    private JFrame vista;

    public vistaResultatHorari(CtrlPresentacio ctrp) {
    }


    public void ferVisible() {
        vista.pack();
        vista.setVisible(true);
    }

}
