package AMAS;

import Enumerations.Constantes;
import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

public class AmasNeoCampus extends Amas<SalleEnv> {
    AgentLumiere agentLumiere;
    AgentVolet agentVolet1;
    AgentVolet agentVolet2;
    AgentVolet agentVolet3;
    public AmasNeoCampus(SalleEnv environment) {
        super(environment, Scheduling.DEFAULT);
    }


    @Override
    protected void onInitialAgentsCreation() {
        agentLumiere = new AgentLumiere(this);
        agentVolet1 = new AgentVolet(this, Constantes.VOLETS_BACK);
        agentVolet2 = new AgentVolet(this,Constantes.VOLETS_CENTER);
        agentVolet3 = new AgentVolet(this,Constantes.VOLETS_FRONT);


    }

    @Override
    protected void onSystemCycleEnd() {
        // a appeler si on veut par exemple logger des valeurs a chaque fin de cycle
    }
}
