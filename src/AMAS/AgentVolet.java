package AMAS;

import Enumerations.Constantes;
import Enumerations.Metrique;
import Physical.StateVolet;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.concurrent.TimeUnit;

public class AgentVolet extends AgentNeoCampus {

    private StateVolet state;
    private StateVolet lastState;
    private StateVolet stateRollback;

    public AgentVolet(AmasNeoCampus amas) {
        super(amas);
        //TODO initialiser les capteurs effecteur suivant MQTT comment c'est plus simple ( dans state )
        state = new StateVolet();
        state.updateValues();
        lastState = new StateVolet(state);
    }

    @Override
    protected void onPerceive() {
        // TODO ici on devra interroger l'interface MQTT pour remplir les données liées a nos capteurs

        // on sauvegarde, pour le rollback en cas de bouclage le lastState précédent
        stateRollback = new StateVolet(lastState);

        //on update le lastState
        lastState = new StateVolet(state);

        // On regarde l'etat des capteurs et l'etat de l'effecteur et on remplis les boolens de state ( bright tout ca )
        // suivant les valeurs brutes ( en lux ) recu de l'interface.
        //System.err.println("Je suis l'agent volet et je suis en train de percevoir le monde: c'est d'la merde");
    }

    @Override
    protected void onDecideAndAct() {
        // TODO suivant l'etat actuel et l'etat precedent, mis en place d'une action si besoin est
        if(!(lastState.getIsOpen() == state.getIsOpen())) {
            // user a override l'état de l'effecteur; il faut donc dormir
            try {
                TimeUnit.MINUTES.sleep(Constantes.MINUTES_USER_OVERRIDES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            decision();
        }
        //System.err.println("Je suis l'agent volet et je suis en train de décider ce que je vais faire: rien, de toute facon ca vaut pas le coup... -_-");
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
            //TODO
            // critique, demander a l'interface d'ouvrir notre volet
        } else if(isCloseShutter()){
            StateVolet nextState = new StateVolet(state);
            nextState.toggleIsOpen();
            if(!nextState.compareStates(this.lastState)) {
                //TODO
                // critique, demander a l'interface de fermer notre volet
            } else {
                // on détecte un cas de bouclage : on rollback la valeur de lastState
                lastState = new StateVolet(stateRollback);
            }
        }
    }

    //##################################################################################################################
}
