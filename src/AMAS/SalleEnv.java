package AMAS;

<<<<<<< HEAD
import Physical.Dispositif;
=======
import Enumerations.Metrique;
import Physical.Capteur;
import Physical.Dispositif;
import Physical.Effecteur;
import Physical.InterfaceMQTT;
>>>>>>> origin/master
import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;

import java.util.ArrayList;
import java.util.List;

public class SalleEnv extends Environment {

    private List<Dispositif> dispositifs;

    // adresse MQTT
    private String base;

    public SalleEnv(String... base) {
        super(Scheduling.DEFAULT);
        /*this.base = String.join("/", base);*/
    }

    @Override
    public void onInitialization() {
       /* dispositifs = new ArrayList<>();
        // TODO Ajouter tous les capteurs de la salle*/
    }

    /*
    public List<Capteur> getCapteurs(Metrique metrique) {
        // Met la liste dispositifs sous forme de stream, filtre pour ne garder que les capteur de la metrique
        // utilise un map pour cast le résultat en capteur
        // collect transforme le stream en liste
        return dispositifs.stream().filter((d) -> d instanceof Capteur && d.getMetrique() == metrique)
                .map((d) -> (Capteur) d)
                .collect(Collectors.toList());
    }
<<<<<<< HEAD

=======
    */
    /*
>>>>>>> origin/master
    public List<Effecteur> getEffecteur(Metrique metrique,String id) {
        // Met la liste dispositifs sous forme de stream, filtre pour ne garder que les effecteurs de la metrique
        // utilise un map pour cast le résultat en effecteur
        // collect transforme le stream en liste
        return dispositifs.stream().filter((d) -> d instanceof Effecteur && d.getMetrique() == metrique)
                .map((d) -> (Effecteur) d)
                .collect(Collectors.toList());
<<<<<<< HEAD
    }*/
=======
    }
    */
>>>>>>> origin/master
}
