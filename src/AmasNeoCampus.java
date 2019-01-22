import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

public class AmasNeoCampus extends Amas<Salle> {

    public AmasNeoCampus(Salle environment) {
        super(environment, Scheduling.DEFAULT);
    }

    @Override
    protected void onInitialAgentsCreation() {
        for (Metrique m : Metrique.values()) {
            AgentNeoCampus ecoAgent = new AgentNeoCampus(this, But.ECONOMIE, m);
            AgentNeoCampus confoAgent = new AgentNeoCampus(this, But.CONFORT, m);

            ecoAgent.addNeighbor(confoAgent);
            confoAgent.addNeighbor(ecoAgent);
        }
    }
}
