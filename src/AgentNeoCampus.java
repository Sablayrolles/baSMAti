import fr.irit.smac.amak.Agent;
import strategies.StrategieAgent;

public class AgentNeoCampus extends Agent<AmasNeoCampus, Salle> {

    private Salle salle;
    private Metrique metrique;
    private StrategieAgent strategie;

    public AgentNeoCampus(AmasNeoCampus amas, StrategieAgent strategie, Metrique metrique) {
        super(amas);
        this.salle = getEnvironment();
        this.strategie = strategie;
        this.metrique = metrique;
    }
}
