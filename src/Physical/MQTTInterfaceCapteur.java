package Physical;

import java.util.HashMap;
import java.util.ArrayList;


public class MQTTInterfaceCapteur {
    private HashMap<String, StockageUnit> stock;
    private static final int BUFFERSIZE = 15;

    public MQTTInterfaceCapteur(String[] types) {
        this.stock = new HashMap<String, StockageUnit>();
        for(String type : types){
            this.stock.put(type, new StockageUnit());
        }
    }

    public ArrayList<Float> getValuesOfType(String type){
        return this.stock.get(type).getValues();
    }
}
