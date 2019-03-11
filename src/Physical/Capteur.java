package Physical;
public class Capteur {
    private static final int NB_CAPTEURS_LUM_INT = 3;
    private static final int NB_CAPTEURS_PRESENCE = 3;

    private static boolean [] presence;
    private static int [] luminositeInt;
    private static float luminositeExt;

    public Capteur() {
        presence = new boolean [3];
        luminositeInt = new int [3];
        luminositeExt = 0;
    }

    public static boolean getPresence() {
        boolean isPresence = false;
        for(boolean i : presence){
            isPresence = isPresence || i;
        }
        return isPresence;
    }

    public static void setPresence(int indice, boolean value) {
        Capteur.presence[indice]= value;
    }

    public static float getLuminositeInt() {
        float sum = 0;
        for(int i : luminositeInt){
            sum += i;
        }
        return sum / NB_CAPTEURS_LUM_INT;
    }

    public static void setLuminositeInt(int indice, int value) {
        Capteur.luminositeInt[indice]= value;
    }

    public static float getLuminositeExt() {
        return luminositeExt;
    }

    public static void setLuminositeExt(float luminositeExt) {
        Capteur.luminositeExt = luminositeExt;
    }
}
