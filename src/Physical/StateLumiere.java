package Physical;

// Author Michael Geraedts-Muse

public class StateLumiere {

    //variables représentant l'etat des capteurs/effecteurs utile pour les lumières
    private boolean isBrightInside;
    private boolean isBrightOutside;
    private boolean isPresence;
    private boolean isOn;

    public StateLumiere() {
        this.isBrightInside = false;
        this.isBrightOutside = false;
        this.isPresence = false;
        this.isOn = false;
    }

    //constructeur de copie, pour last state
    public StateLumiere(StateLumiere state) {
        this.isBrightInside = state.getIsBrightInside();
        this.isBrightOutside = state.getIsBrightOutside();
        this.isPresence = state.getIsPresence();
        this.isOn = state.getIsOn();
    }

    //met a jour les valeur de l'etat en demandant les nouvelles valeur a l'interface MQTT
    public void updateValues(){
        this.isPresence = Capteur.getIsPresence();
        this.isBrightOutside = Capteur.getIsBrightOutside();
        this.isBrightInside = Capteur.getIsBrightInside();
        this.isOn = Effecteur.getIsOn();
        //TODO aussi update l'etat de l'effecteur une fois l'interface effecteur fonctionelle


    }

    public boolean getIsBrightInside() {
        return isBrightInside;
    }

    public boolean getIsBrightOutside() {
        return isBrightOutside;
    }

    public boolean getIsPresence() {
        return isPresence;
    }

    public boolean getIsOn() {
        return isOn;
    }

    // sert a modifier l'etat de l'effecteur pour des raisons de test
    public void toggleIsOn() {
        this.isOn = ! this.isOn;
    }

    // fonction de comparaison entre deux StateLumiere
    public boolean compareStates(StateLumiere state){
        return     (this.isBrightInside == state.getIsBrightInside())
                && (this.isBrightOutside == state.getIsBrightOutside())
                && (this.isPresence == state.getIsPresence())
                && (this.isOn == state.getIsOn());
    }

    //fonction d'affichage
    @Override
    public String toString() {
        return  "|isBrightOutside:"+isBrightOutside+" \n" +
                "|isBrightInside:"+isBrightInside+" \n" +
                "|isPresence:"+isPresence+" \n" +
                "|isOn:"+isOn+
                "-------------------------------------------";
    }
}
