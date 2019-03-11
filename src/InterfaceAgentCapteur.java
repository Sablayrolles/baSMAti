import java.util.ArrayList;

public class InterfaceAgentCapteur {
    private MQTTInterfaceCapteur inter;

    public InterfaceAgentCapteur(ArrayList<String> types) {
        /* types = ["presence", "luminosite"]*/
        this.inter = new MQTTInterfaceCapteur(types);
    }

    public boolean getPresence(){
        boolean presence:

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

        if(s == 0) {
            return m / (float) s;
        }else{
            return -1;
        }
    }
}
