package AMAS;

import Enumerations.Constantes;
import Physical.ListeCommande;
import Physical.StateVolet;

import java.util.concurrent.TimeUnit;

// Author Michael Geraedts-Muse

public class AgentVolet extends AgentNeoCampus {

    //variables d'etat permettant de connaitre l'etat actuel(state)
    // de savoir si l'utilisateur a modifié l'etat manuellement(lastState)
    // et dans le cas d'un bouclage de rollback a un etat antérieur (stateRollback)
    private StateVolet state;
    private StateVolet lastState;
    private StateVolet stateRollback;

    public AgentVolet(AmasNeoCampus amas, String id) {
        super(amas);
        //initialisation des etats et de l'effecteur
        state = new StateVolet();
        effecteur = id;
        state.updateValues(effecteur);
        lastState = new StateVolet(state);
    }

    //fonction de perception
    @Override
    protected void onPerceive() {
        // on sauvegarde, pour le rollback en cas de bouclage le lastState précédent
        stateRollback = new StateVolet(lastState);

        //on update le lastState
        lastState = new StateVolet(state);
        if(Constantes.SHOW_STATE){
            System.out.println("["+effecteur+"]State:\n"+state.toString());
        }
        // On regarde l'etat des capteurs et l'etat de l'effecteur et on remplis les boolens de state ( bright tout ca )
        // suivant les valeurs brutes ( en lux ) recu de l'interface.
        state.updateValues(effecteur);
    }

    //fonction de décision
    @Override
    protected void onDecideAndAct() {
        // suivant l'etat actuel et l'etat precedent, mis en place d'une action si besoin est
        if(!(lastState.getIsOpen() == state.getIsOpen())) {
            // user a override l'état de l'effecteur; il faut donc dormir
            try {
                TimeUnit.MINUTES.sleep(Constantes.MINUTES_USER_OVERRIDES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            //sinon, on peut agir normalement et décider de l'action a effectuer suivant la table de décision
            decision();
        }
    }

    //##################################################################################################################
    //table de karnaught pour chaque action
    // A: isPresence
    // B: isBrightOutside
    // C: IsBrightInside
    // D: isOpen

    private boolean isCloseShutter(){
        // table de karnaugh pour les cas needClose = 1
        // formule: y = (!B)D
        return !state.getIsBrightOutside() && state.getIsOpen();
    }
    private boolean isOpenShutter(){
        // table de karnaugh pour les cas needOpen = 1
        // formule: y = B(!C)(!D) + AB(!D)
        return (state.getIsBrightOutside() && !state.getIsBrightInside() && !state.getIsOpen())
                || (state.getIsPresence() && state.getIsBrightOutside() && !state.getIsOpen());
    }

    private void decision(){
        if(isOpenShutter()){
            // on part du principe qu'il n'y a pas besoin ici de tester si on boucle, car on veut dans le pire des cas
            // que le volet soit dans l'état ouvert
            // critique, demander a l'interface d'ouvrir notre volet ( effecteur doit etre front ou back par exemple, le nom du volet )
            System.out.println("["+effecteur+"][Situation critique]: ouvrir le volet "+effecteur);
            ListeCommande.leverVolet(effecteur);
        } else if(isCloseShutter()){
            StateVolet nextState = new StateVolet(state);
            nextState.toggleIsOpen();
            if(!nextState.compareStates(this.lastState)) {
                // critique, demander a l'interface de fermer notre
                System.out.println("["+effecteur+"][Situation critique]: fermer le volet "+effecteur);
                ListeCommande.baisserVolet(effecteur);
            } else {
                // on détecte un cas de bouclage : on rollback la valeur de lastState
                System.out.println("["+effecteur+"][Bouclage]: rollback");
                lastState = new StateVolet(stateRollback);
            }
        } else {
            // la situation est normale
            System.out.println("["+effecteur+"][Situation normale]");
        }
    }

    //##################################################################################################################
}
