package Enumerations;

// Author Michael Geraedts-Muse
// Author Victor Pinquier

public final class Constantes {
    // durée d'override en cas d'intervention manuelle
    public static final int MINUTES_USER_OVERRIDES = 30;
    // nombre de capteur lumineux dans la salle
    public static final int NB_CAPTEURS_LUM_INT = 3;
    // nombre de capteur de présence dans la salle
    public static final int NB_CAPTEURS_PRESENCE = 3;
    // si aucune présence n'as été détécté durant cette durée on considérera la salle comme vide
    public static final int SEUIL_TEMPS_PRESENCE_SECONDES = 180;
    // seuil définissant Jour/Nuit en fonction de la valeur de luminosité exterieure
    public static final int SEUIL_LUM_EXT = 25000;
    // seuil définissant Eclairé/Sombre en fonction de la valeur de luminosité interieure
    public static final int SEUIL_LUM_INT = 100;
    // temps entre chaque tick des agents (percieve then act every X milliseconds)
    public static final int AMAS_TICKRATE_MILLISECOND = 5000;
    // permet aux agents de print leur state ( pour débug, prend de la place dans la console )
    public static final boolean SHOW_STATE = false;
    //
    public static final int TEMPS_MAJ_BD = 1;

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
