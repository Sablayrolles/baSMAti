import AMAS.AmasNeoCampus;
import AMAS.SalleEnv;
import Enumerations.Constantes;
import Physical.Capteur;
import Physical.Effecteur;
import Physical.InterfaceMQTT;
import Physical.ListeCommande;

// Author: Michael Geraedts-Muse

public class Main {
    public static void main(String[] args) {
        Capteur cap = new Capteur();
        Effecteur eff = new Effecteur();
        ListeCommande listeco = new ListeCommande();
        new InterfaceMQTT().run();
        System.err.println("MQTT initialised\n");

        AmasNeoCampus amas = new AmasNeoCampus(new SalleEnv());
        amas.getScheduler().startWithSleep(Constantes.AMAS_TICKRATE_MILLISECOND);


    }
}
