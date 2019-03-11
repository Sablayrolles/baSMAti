package Physical;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.*;

public class testMQTT implements MqttCallback{

    private static final String CONNECTION_URL = "tcp://neocampus.univ-tlse3.fr:1883";
    private static final String SUBSCRIPTION = "u4/302/#";
    private static final String USERNAME = "m2dc";
    private static final String PASSWORD = "m2dc;18";

    public testMQTT() {
    }

    public static void main(String[] args) {
        Capteur cap = new Capteur();
        new testMQTT().run();
    }

    public void run() {

        String clientId = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient client = new MqttClient(CONNECTION_URL, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();

            connOpts.setUserName(USERNAME);
            connOpts.setPassword(PASSWORD.toCharArray());

            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+CONNECTION_URL);
            client.connect(connOpts);
            System.out.println("Connected");
            client.setCallback(this);

            client.subscribe(SUBSCRIPTION);

            //client.disconnect();
            //System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        //System.out.println(mqttMessage);
        JSONObject obj = new JSONObject(mqttMessage.toString());
        //System.out.println(obj.toString());

        switch (obj.getString("subID")){
            // Reception des données des capteurs de l'ilot 1
            case "ilot1":
                if(obj.toMap().containsKey("value_units") && obj.getString("value_units").equals("lux")){
                    System.out.println("ilot1 lux : " + obj.getInt("value"));
                    Capteur.setLuminositeInt(0, obj.getInt("value"));
                }
                else if(obj.toMap().containsKey("type") && obj.getString("type").equals("presence")){
                    System.out.println("presence 1 : " + obj.getInt("value"));
                    boolean val = (obj.getInt("value")==1);
                    Capteur.setPresence(0, val);
                }
            break;
            // Reception des données des capteurs de l'ilot 2
            case "ilot2":
                if(obj.toMap().containsKey("value_units") && obj.getString("value_units").equals("lux")){
                    System.out.println("ilot2 lux : " + obj.getInt("value"));
                    Capteur.setLuminositeInt(1, obj.getInt("value"));
                }
                else if(obj.toMap().containsKey("type") && obj.getString("type").equals("presence")){
                    System.out.println("presence 2 : " + obj.getInt("value"));
                    boolean val = (obj.getInt("value")==1);
                    Capteur.setPresence(1, val);
                }
            break;
            // Reception des données des capteurs de l'ilot 3
            case "ilot3":
                if(obj.toMap().containsKey("value_units") && obj.getString("value_units").equals("lux")){
                    System.out.println("ilot3 lux : " + obj.getInt("value"));
                    Capteur.setLuminositeInt(2, obj.getInt("value"));
                }
                else if(obj.toMap().containsKey("type") && obj.getString("type").equals("presence")){
                    System.out.println("presence 3 : " + obj.getInt("value"));
                    boolean val = (obj.getInt("value")==1);
                    Capteur.setPresence(2, val);
                }
            break;
            // Reception des données du capteur de luminosité exterieur
            case "ouest":
                // Conversion de la luminosité de W/m² en lux
                if(obj.getString("unitID").equals("outside") && obj.getString("value_units").equals("w/m2")) {
                    System.out.println("exterieur : " + obj.getInt("value") / 0.0079);
                    Capteur.setLuminositeExt((float) (obj.getInt("value") / 0.0079));
                    System.out.println(Capteur.getLuminositeExt());
                }
            break;
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}