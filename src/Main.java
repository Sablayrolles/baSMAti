import AMAS.AmasNeoCampus;
import AMAS.SalleEnv;
import Physical.Capteur;
import Physical.Effecteur;
import Physical.InterfaceMQTT;

public class Main {
    public static void main(String[] args) {
        Capteur cap = new Capteur();
        Effecteur eff = new Effecteur();
        new InterfaceMQTT().run();
        System.err.println("MQTT initialised\n");
        AmasNeoCampus amas = new AmasNeoCampus(new SalleEnv());
        amas.start();
    }
}
