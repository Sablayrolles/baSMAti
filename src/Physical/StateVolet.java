package Physical;

public class StateVolet {


    private boolean isBrightInside;
    private boolean isBrightOutside;
    private boolean isPresence;
    private boolean isOpen;

    public StateVolet() {
        isBrightOutside = false;
        isOpen = false;
        isBrightInside = false;
        isPresence = false;
    }

    //constructeur de copie, pour last state
    public StateVolet(StateVolet state) {
        this.isBrightInside = state.getIsBrightInside();
        this.isBrightOutside = state.getIsBrightOutside();
        this.isPresence = state.getIsPresence();
        this.isOpen = state.getIsOpen();
    }

    public void updateValues(String effecteur){
        this.isPresence = Capteur.getIsPresence();
        this.isBrightOutside = Capteur.getIsBrightOutside();
        this.isBrightInside = Capteur.getIsBrightInside();
        this.isOpen = Effecteur.getIsOpen(effecteur);
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

    public boolean getIsOpen() {
        return isOpen;
    }

    public void toggleIsOpen() {
        this.isOpen = ! this.isOpen;
    }

    public boolean compareStates(StateVolet state){
        return     (this.isBrightInside == state.getIsBrightInside())
                && (this.isBrightOutside == state.getIsBrightOutside())
                && (this.isPresence == state.getIsPresence())
                && (this.isOpen == state.getIsOpen());
    }

    @Override
    public String toString() {
        return  "|isBrightOutside:"+isBrightOutside+" \n" +
                "|isBrightInside:"+isBrightInside+" \n" +
                "|isPresence:"+isPresence+" \n" +
                "|isOpen:"+isOpen+" \n" +
                "-------------------------------------------";
    }
}
