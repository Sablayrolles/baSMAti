package Physical;

// Author Michael Geraedts-Muse

public class StateVolet {

    //variables représentant l'etat des capteurs/effecteurs utile pour les volets
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

    //met a jout les valeur de l'etat en demandant les nouvelles valeur a l'interface MQTT
    public void updateValues(String effecteur){
        this.isPresence = Capteur.getIsPresence();
        this.isBrightOutside = Capteur.getIsBrightOutside();
        this.isBrightInside = Capteur.getIsBrightInside();
        this.isOpen = Effecteur.getIsOpen(effecteur);
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

    public boolean getIsOpen() {
        return isOpen;
    }

    // sert a modifier l'etat de l'effecteur pour des raisons de test
    public void toggleIsOpen() {
        this.isOpen = ! this.isOpen;
    }

    // fonction de comparaison entre deux StateVolet
    public boolean compareStates(StateVolet state){
        return     (this.isBrightInside == state.getIsBrightInside())
                && (this.isBrightOutside == state.getIsBrightOutside())
                && (this.isPresence == state.getIsPresence())
                && (this.isOpen == state.getIsOpen());
    }

    //fonction d'affichage
    @Override
    public String toString() {
        return  "|isBrightOutside:"+isBrightOutside+" \n" +
                "|isBrightInside:"+isBrightInside+" \n" +
                "|isPresence:"+isPresence+" \n" +
                "|isOpen:"+isOpen+" \n" +
                "-------------------------------------------";
    }
}
