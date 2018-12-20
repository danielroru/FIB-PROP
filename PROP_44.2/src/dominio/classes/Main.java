package dominio.classes;
import dominio.controladores.CtrlPresentacio;

public class Main {

    public static void main(String[] args) {

        CtrlPresentacio cP = CtrlPresentacio.getInstance();
        cP.inicialitzarPresentacio();

    }
}

//System.out.println("OK! :)");