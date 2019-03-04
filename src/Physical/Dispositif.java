package Physical;

import Enumerations.Metrique;

public abstract class Dispositif {

    private String identifiant;
    private Metrique metrique;

    public Metrique getMetrique() {
        return this.metrique;
    }
}
