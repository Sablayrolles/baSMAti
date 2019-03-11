package Physical;

public class StateLumiere {


    private boolean isBrightInside;
    private boolean isBrightOutside;
    private boolean isPresence;
    private boolean isOn;

    public StateLumiere() {
    }

    //constructeur de copie, pour last state
    public StateLumiere(StateLumiere state) {
        this.isBrightInside = state.getIsBrightInside();
        this.isBrightOutside = state.getIsBrightOutside();
        this.isPresence = state.getIsPresence();
        this.isOn = state.getIsOn();
    }

    public void updateValues(){
        //TODO liaison avec MQTT
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

    public boolean compareStates(StateLumiere state){
        return     (this.isBrightInside == state.getIsBrightInside())
                && (this.isBrightOutside == state.getIsBrightOutside())
                && (this.isPresence == state.getIsPresence())
                && (this.isOn == state.getIsOn());
    }
}
