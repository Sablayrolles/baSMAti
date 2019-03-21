package Physical;

import Enumerations.Constantes;

import java.util.Date;

public class Capteur {

    private static boolean [] presence;
    private static Date datePresence = new Date();
    private static int [] luminositeInt;
    private static float luminositeExt;

    public Capteur() {
        presence = new boolean [Constantes.NB_CAPTEURS_PRESENCE];
        luminositeInt = new int [Constantes.NB_CAPTEURS_LUM_INT];
        luminositeExt = 0;
    }

    ////// GETTER ET SETTER

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

    public static Date getDatePresence() {
        return datePresence;
    }

    public static void setDatePresence(Date datePresence) {
        Capteur.datePresence = datePresence;
    }

    public static float getLuminositeInt() {
        float sum = 0;
        for(int i : luminositeInt){
            sum += i;
        }
        return sum / Constantes.NB_CAPTEURS_LUM_INT;
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

    /////////////////////////////////

    /**
     Permet d'avoir la différence (en secondes) entre la dernière présence et maintenant
     @return La valeur de la différence des deux dates spécifiés.
     */
    public static long getDateDifference(){
        long diff = (new Date().getTime()) - datePresence.getTime();
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        System.out.println("dateDifference"+diffSeconds+" secondes "+ diffMinutes+ " minutes");

        return diffSeconds;
    }

    /**
     *
     * @return vrai si une présence a été detectée dans la salle il y'a moins de Constantes.SEUIL_TEMPS_PRESENCE_SECONDES
     */
    public static boolean getIsPresence(){
        return getDateDifference() <= Constantes.SEUIL_TEMPS_PRESENCE_SECONDES;
    }

    /**
     *
     * @return retourne vrai si la lum exterieure est superieur au seuil Constantes.SEUIL_LUM_EXT.
     */
    public static boolean getIsBrightOutside(){
        return getLuminositeExt() >= Constantes.SEUIL_LUM_EXT;
    }

    public static boolean getIsBrightInside(){
        return getLuminositeInt() >= Constantes.SEUIL_LUM_INT;
    }
}
