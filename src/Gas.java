import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.LinkedList;

import org.json.JSONObject;

public class Gas implements Sensor {
    protected int id;
    protected String name;
    protected double value = 0;
    protected int updateInterval = 3;
    protected int cicle = 0;
    protected LinkedList<Data> l;
    
    public Gas() {
    	this.l = new LinkedList<Data>();
	}
    
    public void getGasValue() {
		
    	if(this.cicle % this.updateInterval == 0) {
			
			try {
				
				URLConnection openConnection = new URL("https://www.etherchain.org/api/gasPriceOracle").openConnection();
				openConnection.addRequestProperty("User-Agent", "	Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:92.0) Gecko/20100101 Firefox/92.0");
	            
	            BufferedReader reader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
	            
	            StringBuilder sb = new StringBuilder();
	            int cp;
	            while ((cp = reader.read()) != -1) {
	              sb.append((char) cp);
	            }
	            
	            JSONObject json = new JSONObject(sb.toString());
	      
				
	            this.value =json.getDouble("currentBaseFee");
	            
	            l.add(new Data(this.value,new Date()));
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	cicle++;
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
    public LinkedList<Data> getL() {
		return l;
	}

    @Override
	public void setL(LinkedList<Data> l) {
		this.l = l;
	}
    
    @Override
    public double getValue() {
        
    	
    		this.getGasValue();

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
        return "Temperatura{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
