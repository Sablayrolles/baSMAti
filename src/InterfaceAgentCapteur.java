public class InterfaceAgentCapteur {
    private MQTTInterfaceCapteur inter;

    public InterfaceAgentCapteur(String[] types) {
        /* types = ["presence", "luminosite", "luminosite_ext"]*/
        this.inter = new MQTTInterfaceCapteur(types);
    }

    public boolean getPresence(){
        boolean presence = false;

        for(float i : inter.getValuesOfType("presence")){
            presence = presence || (i>0.0);
        }

        return presence;
    }

    public float getLuminosite(){
        float m = 0;
        int s = 0;

        for(float i : inter.getValuesOfType("luminosite")){
            if(i > 0) {
                m += i;
                s++;
            }
        }

        if(s != 0) {
            return m / (float) s;
        }else{
            return -1;
        }
    }

    public float getLuminositeExterieur(){
        float m = 0;
        int s = 0;

        for(float i : inter.getValuesOfType("luminosite_ext")){
            if(i > 0) {
                m += i;
                s++;
            }
        }

        if(s != 0) {
            return m / (float) s;
        }else{
            return -1;
        }
    }
}
