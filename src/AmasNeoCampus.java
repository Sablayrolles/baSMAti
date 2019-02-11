import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;
import strategies.StrategieConfo;
import strategies.StrategieEco;

public class AmasNeoCampus extends Amas<Salle> {

    public AmasNeoCampus(Salle environment) {
        super(environment, Scheduling.DEFAULT);
    }

    @Override
    protected void onInitialAgentsCreation() {
        for (Metrique m : Metrique.values()) {
            AgentNeoCampus ecoAgent = new AgentNeoCampus(this, new StrategieEco(), m);
            AgentNeoCampus confoAgent = new AgentNeoCampus(this, new StrategieConfo(), m);

            ecoAgent.addNeighbor(confoAgent);
            confoAgent.addNeighbor(ecoAgent);
        }
    }
}
