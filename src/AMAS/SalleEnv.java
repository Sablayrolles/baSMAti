package AMAS;


import Enumerations.Metrique;
import Physical.Capteur;
import Physical.Dispositif;
import Physical.Effecteur;
import Physical.InterfaceMQTT;
import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;
import java.util.ArrayList;
import java.util.List;

public class SalleEnv extends Environment {

    private List<Dispositif> dispositifs;

    // adresse MQTT
    private String base;

    public SalleEnv(String... base) {
        super(Scheduling.DEFAULT);
        /*this.base = String.join("/", base);*/
    }
    @Override
    public void onInitialization() {
       /* dispositifs = new ArrayList<>();
        // TODO Ajouter tous les capteurs de la salle*/
    }
}
