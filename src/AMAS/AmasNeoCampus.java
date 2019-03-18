package AMAS;

import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

public class AmasNeoCampus extends Amas<SalleEnv> {
    AgentLumiere agentLumiere;
    AgentVolet agentVolet;
    public AmasNeoCampus(SalleEnv environment) {
        super(environment, Scheduling.DEFAULT);
    }

    @Override
    protected void onInitialAgentsCreation() {
        agentLumiere = new AgentLumiere(this);
        agentVolet = new AgentVolet(this);
        // TODO initaliser les agents?


    }

    @Override
    protected void onSystemCycleEnd() {
        // a appeler si on veut par exemple logger des valeurs a chaque fin de cycle
    }
}
