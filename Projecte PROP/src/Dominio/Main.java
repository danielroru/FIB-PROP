package Dominio;

public class Main {
    private static CtrlPresentacio CP;

    public static void main(String[] args) throws Exception {
        CP = new CtrlPresentacio();
        CP.iniciControlador();
        CP.iniciGestio();
    }
}
