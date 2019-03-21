package Physical;

import java.util.HashMap;

public class Effecteur {
    private static HashMap<String,String> volets;
    private static String lumiere;

    public Effecteur() {
        volets = new HashMap<String,String>();
    }

    public static String getVolets(String nom) {
        return Effecteur.volets.get(nom);
    }

    public static void setVolets(String nom, String volets) {
        Effecteur.volets.put(nom, volets);
    }

    public static String getLumiere() {
        return lumiere;
    }

    public static void setLumiere(String lumiere) {
        Effecteur.lumiere = lumiere;
    }
}
