package AMAS;

import Enumerations.Metrique;
import Physical.StateVolet;

public class AgentVolet extends AgentNeoCampus {

    private StateVolet state;
    private StateVolet lastState;
    private StateVolet stateRollback;

    public AgentVolet(AmasNeoCampus amas, Metrique metrique) {
        super(amas, metrique);
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

    }

    @Override
    protected void onDecideAndAct() {
        // TODO suivant l'etat actuel et l'etat precedent, mis en place d'une action si besoin est
        decision();
    }

    //##################################################################################################################
    //fonction avec tout les cas et decision, la plus compréhensible mais sale
    // ( j'ai pris la liste des cas critiques de bas en haut )

    private void allCasesDecision(){
        if(state.getIsPresence() && state.getIsBrightOutside() && !state.getIsBrightInside() && !state.getIsOpen()){
            // critique confort
            // demander a l'interface d'ouvrir notre volet
        } else if(state.getIsPresence() && !state.getIsBrightOutside() && state.getIsBrightInside() && state.getIsOpen()) {
            // critique Economie ( chaleur )
            // demander a l'interface de fermer notre volet
        } else if(state.getIsPresence() && !state.getIsBrightOutside() && !state.getIsBrightInside() && state.getIsOpen()) {
            // critique economie ( chaleur )
            // demander a l'interface de fermer notre volet
        } else if(!state.getIsPresence() && state.getIsBrightOutside() && !state.getIsBrightInside() && !state.getIsOpen()){
            // critique economie ( lumiere )
            // demander a l'interface d'ouvrir notre volet
        } else if(!state.getIsPresence() && !state.getIsBrightOutside() && state.getIsBrightInside() && state.getIsOpen()){
            // critique economie ( lumiere )
            // demander a l'interface de fermer notre volets
        } else if(!state.getIsPresence() && !state.getIsBrightOutside() && !state.getIsBrightInside() && state.getIsOpen()){
            // critique economie ( chaleur )
            // demander a l'interface de fermer notre volet
        }
    }

    //##################################################################################################################
    //tout les cas concentré sur les deux actions possible, moins clair, plus court

    private boolean bigIsOpenShutter(){
        return (!state.getIsPresence() && state.getIsBrightOutside() && !state.getIsBrightInside() && !state.getIsOpen())
                || (state.getIsPresence() && state.getIsBrightOutside() && !state.getIsBrightInside() && !state.getIsOpen());
    }

    private boolean bigIsCloseShutter() {
        return (!state.getIsPresence() && !state.getIsBrightOutside() && !state.getIsBrightInside() && state.getIsOpen())
                || (!state.getIsPresence() && !state.getIsBrightOutside() && state.getIsBrightInside() && state.getIsOpen())
                || (state.getIsPresence() && !state.getIsBrightOutside() && !state.getIsBrightInside() && state.getIsOpen())
                || (state.getIsPresence() && !state.getIsBrightOutside() && state.getIsBrightInside() && state.getIsOpen());
    }

    private void bigDecision(){
        if (bigIsOpenShutter()){
            // critique, demander a l'interface d'ouvrir notre volet
        } else if (bigIsCloseShutter()) {
            // critique, demander a l'interface de fermer notre volet
        }
    }

    //##################################################################################################################
    //table de karnaught pour chaque action, beaucoup plus simple et propre, plus dur a reverse engenieer

    private boolean isCloseShutter(){
        // table de karnaugh pour les cas needClose = 1
        return !state.getIsBrightOutside() && state.getIsOpen();
    }
    private boolean isOpenShutter(){
        // table de karnaugh pour les cas needOpen = 1
        return state.getIsBrightOutside() && !state.getIsBrightInside() && !state.getIsOpen();
    }

    private void decision(){
        if(isOpenShutter()){
            // on part du principe qu'il n'y a pas besoin ici de tester si on boucle, car on veut dans le pire des cas
            // que le volet soit dans l'état ouvert

            // critique, demander a l'interface d'ouvrir notre volet
        } else if(isCloseShutter()){
            StateVolet nextState = new StateVolet(state);
            nextState.toggleIsOpen();
            if(!nextState.compareStates(this.lastState)) {
                // critique, demander a l'interface de fermer notre volet
            } else {
                // on détecte un cas de bouclage : on rollback la valeur de lastState
                lastState = new StateVolet(stateRollback);
            }
        }
    }

    //##################################################################################################################
}
