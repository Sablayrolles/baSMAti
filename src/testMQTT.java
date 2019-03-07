import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.*;

public class testMQTT implements MqttCallback{

    private MqttClient client;
    private static final String CONNECTION_URL = "tcp://neocampus.univ-tlse3.fr:1883";
    private static final String SUBSCRIPTION = "u4/302/#";
    private static final String USERNAME = "m2dc";
    private static final String PASSWORD = "m2dc;18";

    public testMQTT() {
    }

    public static void main(String[] args) {
        new testMQTT().run();
    }

    public void run() {

        String clientId     = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            client = new MqttClient(CONNECTION_URL, clientId, persistence);
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
            case "ilot1":
                if(obj.getString("value_units").equals("lux"))
                    System.out.println("ilot1 : " + obj.getInt("value"));
            break;
            case "ilot2":
                if(obj.getString("value_units").equals("lux"))
                    System.out.println("ilot2 : " + obj.getInt("value"));
                //else if(obj.getString("type").equals("presence"))
                    //System.out.println("presence : " + obj.getInt("value"));
            break;
            case "ilot3":
                if(obj.getString("value_units").equals("lux"))
                    System.out.println("ilot3 : " + obj.getInt("value"));
            break;
            case "ouest":
                if(obj.getString("unitID").equals("outside") && obj.getString("value_units").equals("w/m2"))
                    System.out.println("exterieur : " + obj.getInt("value"));
            break;
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}