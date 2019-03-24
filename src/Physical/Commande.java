package Physical;

/**
 * Chaque commande MQTT est composé d'un topic servant de destinataire (l'effecteur) ainsi que d'un payload qui
 * est le message JSON contenant une demande de status ou un ordre a l'effecteur.
 */
public class Commande {
    private String topic;
    private String payload;

    public Commande(){
        this.topic = "";
        this.payload = "";
    }

    public Commande(String topic, String payload) {
        this.topic = topic;
        this.payload = payload;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}
