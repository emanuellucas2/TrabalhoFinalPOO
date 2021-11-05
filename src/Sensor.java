import java.util.LinkedList;

public interface Sensor {
    
    public abstract int getId();
    public abstract void setId(int id);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract double getValue(); 
    public abstract String toString();
    public abstract LinkedList<Data> getL();
    public abstract void setL(LinkedList<Data> l);
}
