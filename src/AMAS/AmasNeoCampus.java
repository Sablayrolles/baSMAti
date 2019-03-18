package AMAS;

import Enumerations.Metrique;
import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

public class AmasNeoCampus extends Amas<SalleEnv> {
    AgentNeoCampus AgentLumiere;
    AgentNeoCampus AgentVolet;
    public AmasNeoCampus(SalleEnv environment) {
        super(environment, Scheduling.DEFAULT);
    }

    @Override
    protected void onInitialAgentsCreation() {
        AgentLumiere = new AgentNeoCampus(this,Metrique.LUMIERE);
        AgentVolet = new AgentNeoCampus(this, Metrique.VOLET);
        // TODO initaliser les agents?

    }

    @Override
    protected void onSystemCycleEnd() {
        // a appeler si on veut par exemple logger des valeurs a chaque fin de cycle
    }
}
