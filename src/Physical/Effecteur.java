package Physical;

import Enumerations.Constantes;

import java.util.HashMap;

// Author Victor Pinquier

public class Effecteur {
    private static HashMap<String,String> volets;
    private static String lumiere;

    public Effecteur() {
        volets = new HashMap<String,String>();
        lumiere = "";
    }

    public static String getVolets(String nom) {
        return Effecteur.volets.get(nom);
    }

    public static String getAllVolets(){
        return Effecteur.volets.toString();
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
            Thread.sleep(Constantes.TEMPS_MAJ_BD);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //teste a la valeur mise a jour ? et renvois
        return lumiere.equals("ON");
    }

    public static boolean getIsOpen(String nom){
        //demande des status
        ListeCommande.statusVolets();
        try {
            Thread.sleep(Constantes.TEMPS_MAJ_BD);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //teste a la valeur mise a jour ? et renvois
        return Effecteur.volets.get(nom).equals("OPENED");
    }

    public static boolean getIsUnknown(String nom){
        //demande des status
        ListeCommande.statusVolets();
        try {
            Thread.sleep(Constantes.TEMPS_MAJ_BD);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //teste a la valeur mise a jour ? et renvois
        return Effecteur.volets.get(nom).equals("UNKNOWN");
    }

    public static void setLumiere(String lumiere) {
        Effecteur.lumiere = lumiere;
    }
}
