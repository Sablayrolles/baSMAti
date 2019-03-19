package AMAS;

import fr.irit.smac.amak.Agent;

public class AgentNeoCampus extends Agent<AmasNeoCampus, SalleEnv> {

    protected String effecteur;
    //private List<Capteur> capteurs;
    //private Effecteur effecteurs;

    public AgentNeoCampus(AmasNeoCampus amas) {
        super(amas);

        //TODO rendre fonctionnel les classes capteurs effecteurs
        //this.capteurs = getEnvironment().getCapteurs(this.metrique);
        //this.effecteurs = getEnvironment().getEffecteur(this.metrique,id);
    }

    /*@Override
    protected void onInitialization() {
        //sans doute pas besoin car init fait dans le constructeur
    }*/

    /*@Override
    protected double computeCriticality() {
        //vu que chaque "metrique" est maintenant totalement separée on a plus aucune raison de calculer la criticité en terme de voisinnage
    }*/

    /*@Override
    protected void onPerceive() {
        // TODO pour chaque type d'agent (heritage) mettre en place son "tableau d'etat"
        // On regarde l'etat des capteurs et on calcule ce qu'on appelait "criticité" ici ==>
    }*/

    /*@Override
    protected void onDecideAndAct() {
        // TODO suivant l'etat actuel et l'etat precedent, mis en place d'une action si besoin est
        // ici on fera un switch suivant notre "tableau de criticalité" pour agir en cas de besoin

    }*/

    /*@Override
    protected void onUpdateRender() {
        // Utilisé dans le tuto pour logger l'etat de l'agent apres chaque
    }*/


}
