package Physical;

import AMAS.SalleEnv;

public class StateLumiere {


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

    public void updateValues(){
        this.isPresence = Capteur.getIsPresence();
        this.isBrightOutside = Capteur.getIsBrightOutside();
        this.isBrightInside = Capteur.getIsBrightInside();
        this.isOn = Effecteur.getIsOn();
        //TODO aussi update l'etat du capteur une fois l'interface effecteur fonctionelle


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

    public void toggleIsOn() {
        this.isOn = ! this.isOn;
    }

    public boolean compareStates(StateLumiere state){
        return     (this.isBrightInside == state.getIsBrightInside())
                && (this.isBrightOutside == state.getIsBrightOutside())
                && (this.isPresence == state.getIsPresence())
                && (this.isOn == state.getIsOn());
    }

    @Override
    public String toString() {
        return  "|isBrightOutside:"+isBrightOutside+" \n" +
                "|isBrightInside:"+isBrightInside+" \n" +
                "|isPresence:"+isPresence+" \n" +
                "|isOn:"+isOn+
                "-------------------------------------------";
    }
}
