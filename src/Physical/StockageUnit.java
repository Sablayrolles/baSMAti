package Physical;

import java.util.ArrayList;

public class StockageUnit {
    private int indice;
    private static final int BUFFERSIZE = 15;
    private ArrayList<Float> values;

    public StockageUnit() {
        this.indice = 0;
        this.values = new ArrayList<Float>(BUFFERSIZE);
    }

    private void incrIndice(){
        this.indice = (this.indice + 1) % BUFFERSIZE;
    }

    public void setValue(float val){
        this.values.set(this.indice, val);
        this.incrIndice();
    }

    public ArrayList<Float> getValues(){
        return this.values;
    }
}
