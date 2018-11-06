package Dominio;

public class CtrlPresentacioAula {

    private VistaAula vAula;
    private CtrlDominiAula CDaula;

    CtrlPresentacioAula (CtrlDominiAula c) {
        vAula = new VistaAula();
        CDaula = c;
    }

    public void gestioJugador() {

        int accio = -1;
        while (accio != 0) {
            accio = vAula.obtenerOpcion();
            switch (accio) {
                case 1: llistarAules(); break;
                case 2: afegirAula(); break;
                case 3: modificarAula(); break;
                case 4: eliminarAula(); break;
                case 5: break;
                default: break;
            }
        }

        private void llistarAules() throws Exception { //*** private
            vAula.mostrarMissatge(’-’,"Llistar Aules");
            //*** El que realmente hace el trabajo es el controlador de dominio
            Vector<String> datos = CDmj.consultaJugadores();
            //*** La vista solo recoge y/o muestra datos
            vAula.mostrarDatosJugadores(datos);
        }


    }
}
