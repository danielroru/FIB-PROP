package Dominio;

import java.util.*;

public class Restriccions {

    public static HashSet<Sessio> crearArestes(Sessio s) {
        //Afegir arestes degudes a restriccions de nivell
        HashSet<Sessio> arestesSessio = new HashSet<>(RestriccioBinaria.arestesNivell(s));
        //Afegir arestes degudes a restriccions de correquisit
        arestesSessio.addAll(RestriccioBinaria.arestesCorrequisits(s));

        return arestesSessio;
    }
}