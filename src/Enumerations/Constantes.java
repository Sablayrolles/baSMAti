package Enumerations;

public final class Constantes {
    public static final int MINUTES_USER_OVERRIDES = 30;
    public static final int NB_CAPTEURS_LUM_INT = 3;
    public static final int NB_CAPTEURS_PRESENCE = 3;
    public static final int SEUIL_TEMPS_PRESENCE_SECONDES = 180;
    public static final int SEUIL_LUM_EXT = 25000;
    public static final int SEUIL_LUM_INT = 250;
    public static final int AMAS_TICKRATE_MILLISECOND = 5000;

    // Commandes MQTT

    // Volets
    public static final String TOPIC_VOLETS = "u4/302/shutter";
    public static final String COMMANDE_VOLETS_STATUS = "{\"dest\":\"all\",\"order\":\"status\"}";
    public static final String COMMANDE_VOLETS_UP = "{\"dest\":\"all\",\"order\":\"up\"}";
    public static final String COMMANDE_VOLETS_DOWN = "{\"dest\":\"all\",\"order\":\"down\"}";

    // Lumières
    public static final String TOPIC_LUMIERES = "u4/302/lighting";
    public static final String COMMANDE_LUMIERE_STATUS = "{\"dest\":\"all\",\"order\":\"status\"}";
    public static final String COMMANDE_LUMIERE_ON = "{\"dest\":\"all\",\"order\":\"on\"}";
    public static final String COMMANDE_LUMIERE_OFF = "{\"dest\":\"all\",\"order\":\"off\"}";
}
