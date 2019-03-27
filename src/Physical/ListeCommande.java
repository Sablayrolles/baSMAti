package Physical;

import java.util.ArrayList;

import static Enumerations.Constantes.*;

public class ListeCommande {
    private static ArrayList<Commande> listeOrdre;

    public ListeCommande(){
        listeOrdre = new ArrayList<Commande>();
    }

    public static void ajouterOrdre(Commande ordre){
        listeOrdre.add(ordre);
    }

    public static Commande getPremierOrdre(){
        return listeOrdre.get(0);
    }

    public static void supprimerPremierOrdre(){
        listeOrdre.remove(0);
    }

    public static boolean possedeOrdre(){
        return !listeOrdre.isEmpty();
    }

    private static String getPayloadString(String dest, String order){
        return "{\"dest\":\""+dest+"\",\"order\":\""+order+"\"}";
    }

    private static String getTopicString(String metrique){
        return "u4/302/"+metrique+"/command";
    }


    // Commandes MQTT

    // Volets
    public static void statusVolets() {
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_STATUS));
        listeOrdre.add(comm);
    }

    public static void leverTousLesVolets(){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_UP));
        listeOrdre.add(comm);
    }

    public static void baisserTousLesVolets(){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_DOWN));
        listeOrdre.add(comm);
    }

    public static void leverVolet(String id){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(id, COMMANDE_VOLETS_UP));
        listeOrdre.add(comm);
    }

    public static void baisserVolet(String id){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(id, COMMANDE_VOLETS_DOWN));
        listeOrdre.add(comm);
    }

    // Lumières
    public static void statusLumieres() {
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_STATUS));
        listeOrdre.add(comm);
    }

    public static void allumerLumieres(){
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_ON));
        listeOrdre.add(comm);
    }

    public static void eteindreLumieres(){
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_OFF));
        listeOrdre.add(comm);
    }
}
