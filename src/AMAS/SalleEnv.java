package AMAS;


import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;

public class SalleEnv extends Environment {

    public SalleEnv() {
        super(Scheduling.DEFAULT);
        /*this.base = String.join("/", base);*/
    }
    @Override
    public void onInitialization() {

    }
}
