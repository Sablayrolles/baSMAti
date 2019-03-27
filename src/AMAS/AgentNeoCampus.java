package AMAS;

import fr.irit.smac.amak.Agent;

// Author Michael Geraedts-Muse

public class AgentNeoCampus extends Agent<AmasNeoCampus, SalleEnv> {

    //variable contenant le nom de l'effecteur associé a l'agent si besoin est
    protected String effecteur;

    public AgentNeoCampus(AmasNeoCampus amas) {
        super(amas);
    }
}
