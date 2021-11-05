import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Temperatura implements Sensor {
    protected int id;
    protected String name;
    protected double value = 0;
    protected int updateInterval = 3;
    protected String cidade = "SBAR";
    protected int cicle = 0;
    protected LinkedList<Data> l;

	public Temperatura() {
    	this.l = new LinkedList<Data>();
	}

	public void getTempValue() throws ParserConfigurationException, SAXException {
    	
    	if(this.cicle % this.updateInterval == 0) {
	        try {
	        	
	        	
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            
	            URL url = new URL("http://servicos.cptec.inpe.br/XML/capitais/condicoesAtuais.xml");
	            
	            InputStream stream = url.openStream();
	           
	            Document document = builder.parse(stream);
	            NodeList nodeList = document.getDocumentElement().getChildNodes();
	            for (int i = 0; i < nodeList.getLength(); i++) {
	            	Node node = nodeList.item(i);
	            	Element elem = (Element) node;
		                if (this.cidade.compareTo(elem.getElementsByTagName("codigo")
		                        .item(0).getChildNodes().item(0).getNodeValue())== 0 ) {
	                    
	                	
	                	this.value = Double.parseDouble(elem.getElementsByTagName("temperatura")
	                            .item(0).getChildNodes().item(0).getNodeValue());
	                }
	            }
	            
	            
	            l.add(new Data(this.value,new Date()));
	            
	        }
	        catch(IOException e) {
	            System.out.println(e);
	        }
    	}
    	cicle++;
    }
    
    public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getValue() {
        
    	
    	try {
    	this.getTempValue();
    	}catch(ParserConfigurationException e){
    		System.out.println(e);
    	}catch(SAXException e){
    		System.out.println(e);
    	}
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
