package Enumerations;

public final class Constantes {
    public static final int MINUTES_USER_OVERRIDES = 30;
    public static final int NB_CAPTEURS_LUM_INT = 3;
    public static final int NB_CAPTEURS_PRESENCE = 3;
    public static final int SEUIL_TEMPS_PRESENCE_SECONDES = 180;
    public static final int SEUIL_LUM_EXT = 3000;
    public static final int SEUIL_LUM_INT = 100;
    public static final int AMAS_TICKRATE_MILLISECOND = 5000;
    public static final boolean SHOW_STATE = false;
    public static final int TEMPS_MAJ_BD = 1;

    // Connexion serveur MQTT
    public static final String CONNECTION_URL = "tcp://neocampus.univ-tlse3.fr:1883";
    public static final String SUBSCRIPTION = "u4/302/#";
    public static final String USERNAME = "m2dc";
    public static final String PASSWORD = "m2dc;18";

    // Commandes MQTT

    public static final String COMMANDE_ALL = "all";

    // Volets
    public static final String TOPIC_VOLETS = "shutter";
    public static final String COMMANDE_VOLETS_STATUS = "status";
    public static final String COMMANDE_VOLETS_UP = "up";
    public static final String COMMANDE_VOLETS_DOWN = "down";

    public static final String VOLETS_FRONT = "front";
    public static final String VOLETS_CENTER = "center";
    public static final String VOLETS_BACK = "back";

    // Lumières
    public static final String TOPIC_LUMIERES = "lighting";
    public static final String COMMANDE_LUMIERE_STATUS = "status";
    public static final String COMMANDE_LUMIERE_ON = "on";
    public static final String COMMANDE_LUMIERE_OFF = "off";

    public static final String LUMIERE_OTHERS = "others";
}
