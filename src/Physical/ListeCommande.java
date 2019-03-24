package Physical;

import java.util.ArrayList;

import static Enumerations.Constantes.*;

/**
 * Cette classe permettait à la base à stocker la liste des ordres à envoyer au serveur MQTT.
 * Mais il y a des soucis au niveau de communication entre les agents
 * et le serveur MQTT. En effet, la réception de message doit être permanente pour
 * recevoir l’état des capteurs qui se fait toutes les 20 secondes. La publication de
 * message (permettant de recevoir l’état des effecteurs et de leur donner des ordres)
 * doit elle être dynamique. Ces deux types de messages doivent être effectués sur le
 * même client de connexion avec le serveur MQTT, ce qui entraîne une complexité de
 * communication.
 */
public class ListeCommande {
    private static ArrayList<Commande> listeOrdre;

    public ListeCommande(){
        listeOrdre = new ArrayList<Commande>();
    }

    /**
     * @deprecated
     * @param ordre
     */
    public static void ajouterOrdre(Commande ordre){
        listeOrdre.add(ordre);
    }

    /**
     * @deprecated
     */
    public static Commande getPremierOrdre(){
        return listeOrdre.get(0);
    }

    /**
     * @deprecated
     */
    public static void supprimerPremierOrdre(){
        listeOrdre.remove(0);
    }

    /**
     * @deprecated
     */
    public static boolean possedeOrdre(){
        return !listeOrdre.isEmpty();
    }

    /**
     * Permet de générer le message JSON à envoyer au MQTT
     * @param dest
     * @param order
     * @return json
     */
    public static String getPayloadString(String dest, String order){
        return "{\"dest\":\""+dest+"\",\"order\":\""+order+"\"}";
    }

    /**
     * Permet de générer le topic en fonction de la metrique
     * @param metrique
     * @return topic
     */
    public static String getTopicString(String metrique){
        return "u4/302/"+metrique+"/command";
    }


    // Commandes MQTT

    // Volets

    /**
    * Envoie une demande de status des volets
     */
    public static void statusVolets(){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_STATUS));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour lever tous les volets
     */
    public static void leverTousLesVolets(){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_UP));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour baisser tous les volets
     */
    public static void baisserTousLesVolets(){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_DOWN));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour lever un volet
     * @param id nom du volet
     */
    public static void leverVolet(String id){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(id, COMMANDE_VOLETS_UP));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour baisser un volet
     * @param id nom du volet
     */
    public static void baisserVolet(String id){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(id, COMMANDE_VOLETS_DOWN));
        listeOrdre.add(comm);
    }

    // Lumières
    /**
     * Envoie une demande de status des lampes
     */
    public static void statusLumieres(){
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_STATUS));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour allumer les lampes
     */
    public static void allumerLumieres(){
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_ON));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour éteindre les lampes
     */
    public static void eteindreLumieres(){
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_OFF));
        listeOrdre.add(comm);
    }
}
