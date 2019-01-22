import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Salle extends Environment {

    private List<Dispositif> dispositifs;
    private String base;

    public Salle(String... base) {
        super(Scheduling.DEFAULT);
        this.base = String.join("/", base);
    }

    @Override
    public void onInitialization() {
        dispositifs = new ArrayList<>();

        // Ajouter tous les capteurs de la salle
    }

    public List<Capteur> getCapteurs(Metrique metrique) {
        return dispositifs.stream().filter((d) -> d instanceof Capteur && d.getMetrique() == metrique)
                .map((d) -> (Capteur) d)
                .collect(Collectors.toList());
    }

    public List<Effecteur> getEffecteurs(Metrique metrique) {
        return dispositifs.stream().filter((d) -> d instanceof Effecteur && d.getMetrique() == metrique)
                .map((d) -> (Effecteur) d)
                .collect(Collectors.toList());
    }
}
