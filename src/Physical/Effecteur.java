package Physical;

public class Effecteur {
    private static String [] volets;
    private static String lumiere;

    public Effecteur() {
        volets = new String[3];
    }

    public static String[] getVolets() {
        return volets;
    }

    public static void setVolets(String[] volets) {
        Effecteur.volets = volets;
    }

    public static String getLumiere() {
        return lumiere;
    }

    public static void setLumiere(String lumiere) {
        Effecteur.lumiere = lumiere;
    }
}
