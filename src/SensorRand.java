
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;


public class SensorRand implements Sensor {
    protected int id;
    protected String name;
    protected double value = 0;
    private static final Random RND = new Random();
    private LinkedList<Data> l;
    
    public SensorRand() {
		super();
		this.l = new LinkedList<Data>();
	}
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getValue() {
    	
        int soma = RND.nextInt() % 5;
        
        if (soma < 3){
            this.value = Math.abs((this.value + RND.nextDouble()*10) % 101);        
        } else {
            this.value = Math.abs((this.value - RND.nextDouble()*10) % 101);        
        }
        
        l.add(new Data(this.value,new Date()));

        return this.value;
        
    }

	@Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }    

    @Override
    public String toString() {
        return "SensorRand{" + "id=" + id + ", name=" + name + '}';
    }

	@Override
	public LinkedList<Data> getL() {
		
		return this.l;
	}

	@Override
	public void setL(LinkedList<Data> l) {
		
		this.l = l;
	}

    
}
