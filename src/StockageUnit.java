import java.util.ArrayList;

public class StockageUnit {
    private int indice;
    private int BUFFERSIZE;
    private ArrayList<Float> values;

    public StockageUnit(int BUFFERSIZE) {
        this.indice = 0;
        this.BUFFERSIZE = BUFFERSIZE;
        this.values = new ArrayList<Float>(BUFFERSIZE);
    }

    private void incrIndice(){
        this.indice = (this.indice + 1) % this.BUFFERSIZE;
    }

    public void setValue(float val){
        this.values.set(this.indice, val);
        this.incrIndice();
    }

    public ArrayList<Float> getValues(){
        return this.values;
    }
}
