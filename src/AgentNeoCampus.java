import fr.irit.smac.amak.Agent;

import java.util.List;

public class AgentNeoCampus extends Agent<AmasNeoCampus, Salle> {

    private But but;
    private Metrique metrique;

    private List<Capteur> capteurs;
    private List<Effecteur> effecteurs;

    public AgentNeoCampus(AmasNeoCampus amas, But but, Metrique metrique) {
        super(amas);
        this.but = but;
        this.metrique = metrique;

        this.capteurs = getEnvironment().getCapteurs(this.metrique);
        this.effecteurs = getEnvironment().getEffecteurs(this.metrique);
    }
}
