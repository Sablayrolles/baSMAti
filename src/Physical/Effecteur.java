package Physical;

import java.util.ArrayList;

import static Enumerations.Constantes.*;

public class Effecteur {
    private static ArrayList<Commande> listeOrdre;

    public Effecteur(){
        listeOrdre = new ArrayList<Commande>();
    }

    public static void ajouterOrdre(Commande ordre){
        listeOrdre.add(ordre);
    }

    public static Commande getPremiereOrdre(){
        Commande ordre = listeOrdre.get(0);
        listeOrdre.remove(0);
        return ordre;
    }
     // Commandes MQTT

    // Volets
    public static void statusVolets(){
        listeOrdre.add(new Commande(TOPIC_VOLETS, COMMANDE_VOLETS_STATUS));
    }

    public static void leverVolets(){
        listeOrdre.add(new Commande(TOPIC_VOLETS, COMMANDE_VOLETS_UP));
    }

    public static void baisserVolets(){
        listeOrdre.add(new Commande(TOPIC_VOLETS,COMMANDE_VOLETS_DOWN));
    }

    // Lumières
    public static void statusLumieres(){
        listeOrdre.add(new Commande(TOPIC_LUMIERES,COMMANDE_VOLETS_STATUS));
    }

    public static void allumerLumieres(){
        listeOrdre.add(new Commande(TOPIC_LUMIERES,COMMANDE_VOLETS_UP));
    }

    public static void eteindreLumieres(){
        listeOrdre.add(new Commande(TOPIC_LUMIERES,COMMANDE_VOLETS_DOWN));
    }
}
