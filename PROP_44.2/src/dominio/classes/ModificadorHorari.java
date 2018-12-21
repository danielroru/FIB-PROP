package dominio.classes;

public class ModificadorHorari {

    private static void swap(Sessio s1, Sessio s2) {
        UAH aux = s1.getUah();
        s1.setUah(s2.getUah());

        s2.setUah(aux);
    }

    private static boolean compleixRestriccions() {
        Graph G = GeneradorHorari.getG();
        //iterem per totes les sessions
        for (Sessio s : G.getVertexs().keySet()) {
            //iterem per totes les sessions conflictives de s
            for (Sessio conflictiva : G.getArestes().get(s)) {
                if (RestriccioBinaria.coincideixenUAH(s.getUah(), conflictiva.getUah()))
                    return false;
            }
        }
        return true;
    }

    public static void modificaHorari(UAH uah1, UAH uah2) {
        swap(uah1.getSessio(), uah2.getSessio());
        if (!compleixRestriccions()) {
            System.out.println("El canvi que s'ha fet no compleix les restriccions especificades");
            swap(uah1.getSessio(), uah2.getSessio());
        }
    }
}
