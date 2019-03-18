package Physical;

import java.util.ArrayList;

public class Effecteur {
    private static ArrayList<String> listeOrdre;

    public Effecteur(){
        listeOrdre = new ArrayList<String>();
    }

    public static void ajouterOrdre(String ordre){
        listeOrdre.add(ordre);
    }

    public static String getPremiereOrdre(){
        String ordre = listeOrdre.get(0);
        listeOrdre.remove(0);
        return ordre;
    }
}
