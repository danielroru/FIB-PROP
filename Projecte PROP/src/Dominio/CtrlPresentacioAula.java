package Dominio;

import java.util.*

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
            accio = vAula.obtenirOpcio();

            switch (accio) {
                case 1:
                    llistarAules();
                    break;
                case 2:
                    afegirAula();
                    break;
                case 3:
                    modificarAula();
                    break;
                case 4:
                    eliminarAula();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }

        private void llistarAules() { //*** private
            vAula.mostrarMissatge("- Llistar Aules");
            //*** El que realmente hace el trabajo es el controlador de dominio
            Vector<String> datos = CDmj.consultaJugadores();
            //*** La vista solo recoge y/o muestra datos
            vAula.mostrarDatosJugadores(datos);
        }

        private void afegirAula() {
            vAula.mostrarMissatge("- Afegir Aula");

            String id = vAula.getID();
            int capacitat = vAula.getCapacitat();
            int tipus = vAula.getTipus();

            Vector<String> dades = new Vector<String>();
            dades.add((new Integer(id)).toString());
            dades.add(capacitat);
            dades.add((new Integer(tipus)).toString());

            int codiError = CDaula.afegirAula(id, dades);

            switch (codiError) {
                case 0:
                    vAula.mostrarMissatge("Alta efectuada"); 
                    break;
                case 1:
                    vAula.mostrarError("Jugador ya existe");
                    break;
                case 2:
                    vAula.mostrarError("Error de inconsistencia");
                    break;
                default:
                    vAula.mostrarError("Error imposible " + codiError);
                    break;
            }
        }


    }
}
