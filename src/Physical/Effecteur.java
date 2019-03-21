package Physical;

import Enumerations.Constantes;
import com.sun.org.apache.bcel.internal.classfile.Constant;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Effecteur {
    private static HashMap<String,String> volets;
    private static String lumiere;

    public Effecteur() {
        volets = new HashMap<String,String>();
    }

    public static String getVolets(String nom) {
        return Effecteur.volets.get(nom);
    }

    public static void setVolets(String nom, String volets) {
        Effecteur.volets.put(nom, volets);
    }

    public static String getLumiere() {
        return lumiere;
    }
    //TODO on risque de rater des messages entre la requete et le return
    public static boolean getIsOn(){
        //demande des status
        ListeCommande.statusLumieres();
        try {
            Thread.sleep(Constantes.TEMPS_MAJ_BD*3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //teste a la valeur mise a jour ? et renvois
        return lumiere == "ON";
    }

    public static boolean getIsOpen(String nom){
        ListeCommande.statusVolets();
        try {
            Thread.sleep(Constantes.TEMPS_MAJ_BD*3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Effecteur.volets.get(nom) == "OPENED";
    }

    public static boolean getIsUnknown(String nom){
        ListeCommande.statusVolets();
        try {
            Thread.sleep(Constantes.TEMPS_MAJ_BD*3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Effecteur.volets.get(nom) == "UNKNOWN";
    }

    public static void setLumiere(String lumiere) {
        Effecteur.lumiere = lumiere;
    }
}
