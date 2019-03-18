package AMAS;

import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

public class AmasNeoCampus extends Amas<SalleEnv> {
    AgentLumiere agentLumiere1;
    AgentLumiere agentLumiere2;
    AgentLumiere agentLumiere3;
    AgentVolet agentVolet1;
    AgentVolet agentVolet2;
    AgentVolet agentVolet3;
    public AmasNeoCampus(SalleEnv environment) {
        super(environment, Scheduling.DEFAULT);
    }

    @Override
    protected void onInitialAgentsCreation() {
        agentLumiere1 = new AgentLumiere(this);
        agentVolet1 = new AgentVolet(this);
        agentLumiere2 = new AgentLumiere(this);
        agentVolet2 = new AgentVolet(this);
        agentLumiere3 = new AgentLumiere(this);
        agentVolet3 = new AgentVolet(this);
        // TODO initaliser les agents?


    }

    @Override
    protected void onSystemCycleEnd() {
        // a appeler si on veut par exemple logger des valeurs a chaque fin de cycle
    }
}
