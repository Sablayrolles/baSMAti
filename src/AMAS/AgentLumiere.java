package AMAS;

import Enumerations.Constantes;
import Physical.ListeCommande;
import Physical.StateLumiere;

import java.util.concurrent.TimeUnit;

// Author Michael Geraedts-Muse

public class AgentLumiere extends AgentNeoCampus{

    //variables d'etat permettant de connaitre l'etat actuel(state)
    // de savoir si l'utilisateur a modifié l'etat manuellement(lastState)
    // et dans le cas d'un bouclage de rollback a un etat antérieur (stateRollback)
    private StateLumiere state;
    private StateLumiere lastState;
    private StateLumiere stateRollback;

    public AgentLumiere(AmasNeoCampus amas) {
        super(amas);
        //initialisation des etats
        state = new StateLumiere();
        state.updateValues();
        lastState = new StateLumiere(state);
    }

    //fonction de perception
    @Override
    protected void onPerceive() {
        // on sauvegarde, pour le rollback en cas de bouclage le lastState précédent
        stateRollback = new StateLumiere(lastState);

        //on update le lastState (en dernier dans la fonction)
        lastState = new StateLumiere(state);
        if(Constantes.SHOW_STATE) {
            System.out.println("[Lum]State:\n" + state.toString());
        }
        // On regarde l'etat des capteurs et l'etat de l'effecteur et on remplis les boolens de state
        // suivant la comparaison des valeurs brutes ( en lux ) et des seuils recu de l'interface.
        state.updateValues();
    }

    //fonction de décision
    @Override
    protected void onDecideAndAct() {

        if(!(lastState.getIsOn() == state.getIsOn())) {
            //si oui: l'utilisateur a override l'état de l'effecteur; il faut donc dormir
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
    // D: isOn


    private boolean isTurnOff(){
        // table de karnaugh pour les cas needTurnOff = 1
        // formule:  y = (!A)D + BCD
        return (!state.getIsPresence() && state.getIsOn())
                || (state.getIsBrightOutside() && state.getIsBrightInside() && state.getIsOn());
    }
    private boolean isTurnOn(){
        // table de karnaugh pour les cas needTurnOn = 1
        // formule: y = A(!C)(!D)
        return (state.getIsPresence() && !state.getIsBrightInside() && !state.getIsOn());
    }

    private boolean isErrorCase(){
        // formule: y = (!B)C(!D) + A(!C)D
        return (!state.getIsBrightOutside() && state.getIsBrightInside() && !state.getIsOn())
                ||(state.getIsPresence() && !state.getIsBrightInside() && state.getIsOn());
    }

    private void decision(){
        if(isTurnOn()){
            // on part du principe qu'il n'y a pas besoin ici de tester si on boucle, car on veut dans le pire des cas
            // que les lumières soient allumées
            // critique, demander a l'interface d'allumer notre lampe
            System.out.println("[Lum][Situation critique]: allumer les lumière ");
            ListeCommande.allumerLumieres();
        } else if(isTurnOff()){
            StateLumiere nextState = new StateLumiere(state);
            nextState.toggleIsOn();
            if(!nextState.compareStates(this.lastState)) {
                // critique, demander a l'interface d'eteindre notre lampe
                System.out.println("[Lum][Situation critique]: eteindre les lumière ");
                ListeCommande.eteindreLumieres();
            } else {
                // on détecte un cas de bouclage : on rollback la valeur de lastState
                lastState = new StateLumiere(stateRollback);
            }
        } else if (isErrorCase()){
            // cas impossible: envoyer message d'erreur
            System.err.println("[Lum][Cas impossible]");
        } else {
            // situation normale
            System.out.println("[Lum][Situation normale]");
        }
    }

    //##################################################################################################################
}
