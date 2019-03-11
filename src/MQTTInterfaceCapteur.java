import java.util.HashMap;
import java.util.ArrayList;

public class MQTTInterfaceCapteur {
    private HashMap<String, StockageUnit> stock;
    private static final int BUFFERSIZE = 15;

    public MQTTInterfaceCapteur(ArrayList<String> types) {
        this.stock = new HashMap<String, StockageUnit>();
        for(String type : types){
            this.stock.put(type, new StockageUnit(this.BUFFERSIZE));
        }
    }
}
