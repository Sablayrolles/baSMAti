package Physical;

// Author Victor Pinquier

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
