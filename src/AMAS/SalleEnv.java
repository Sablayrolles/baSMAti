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



    public SalleEnv() {
        super(Scheduling.DEFAULT);
        /*this.base = String.join("/", base);*/
    }
    @Override
    public void onInitialization() {

    }
}
