package dominio.classes;
import dominio.controladores.CtrlDominiGenerarHorari;

import java.util.*;

public class Restriccions {

    private static CtrlDominiGenerarHorari CtrlDomini = CtrlDominiGenerarHorari.getInstance();

    public static HashSet<Sessio> crearArestes(Sessio s) {
        //Afegir arestes degudes a restriccions de nivell
        HashSet<Sessio> arestesSessio = new HashSet<>(RestriccioBinaria.arestesNivell(s));
        //Afegir arestes degudes a restriccions de correquisit
        arestesSessio.addAll(RestriccioBinaria.arestesCorrequisits(s));

        return arestesSessio;
    }

}