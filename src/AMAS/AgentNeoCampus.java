package AMAS;

import Enumerations.Etat;
import Enumerations.Metrique;
import Physical.Capteur;
import Physical.Effecteur;
import fr.irit.smac.amak.Agent;
import fr.irit.smac.lxplot.LxPlot;
import fr.irit.smac.lxplot.commons.ChartType;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AgentNeoCampus extends Agent<AmasNeoCampus, SalleEnv> {

    private Metrique metrique;
    private Etat state;
    private Etat lastState;
    private List<Capteur> capteurs;
    private List<Effecteur> effecteurs;

    private int test_cpt;

    public AgentNeoCampus(AmasNeoCampus amas, Metrique metrique) {
        super(amas);
        this.metrique = metrique;
        this.test_cpt = 0;

        //TODO gerer l'etat initial
        this.state = Etat.UNINDENTIFIED_STATE;
        this.lastState = state;

        //TODO rendre fonctionnel les classes capteurs effecteurs
        this.capteurs = getEnvironment().getCapteurs(this.metrique);
        this.effecteurs = getEnvironment().getEffecteurs(this.metrique);
    }

    /*@Override
    protected void onInitialization() {
        //sans doute pas besoin car init fait dans le constructeur
    }*/

    /*@Override
    protected double computeCriticality() {
        //vu que chaque "metrique" est maintenant totalement separée on a plus aucune raison de calculer la criticité en terme de voisinnage
    }*/

    @Override
    protected void onPerceive() {
        // TODO pour chaque type d'agent (heritage) mettre en place son "tableau d'etat"
        // On regarde l'etat des capteurs et on calcule ce qu'on appelait "criticité" ici ==>
    }

    @Override
    protected void onDecideAndAct() {
        // TODO suivant l'etat actuel et l'etat precedent, mis en place d'une action si besoin est
        // ici on fera un switch suivant notre "tableau de criticalité" pour agir en cas de besoin

    }

    @Override
    protected void onUpdateRender() {
        // Utilisé dans le tuto pour logger l'etat de l'agent apres chaque
        int id = metrique == Metrique.LUMIERE ? 1 : 0;
        if ( ThreadLocalRandom.current().nextInt(0,2) == 1 ) test_cpt++;
        LxPlot.getChart("Eaten Pastas", ChartType.BAR).add(id , test_cpt);
    }
}
