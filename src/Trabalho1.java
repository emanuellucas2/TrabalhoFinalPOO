
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Trabalho1 {

    public static void main(String[] args){
    	   
		Map<Integer,Sensor> sensores = new HashMap<Integer,Sensor>();
	    boolean vector[] = new boolean[10];

	    boolean start = false;

		int ciclos = 0;
        int atualizasensores = 1;
        int intervalociclos = 3000;
       
        
        Tela frame = new Tela();
        
        frame.getBtnRemover().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
				FileReader f = new FileReader(frame.getCaminho()+"Sensores.txt");
	            BufferedReader br = new BufferedReader(f);
				String line = null;
				String line2 = "";
				String line3 = frame.getTxtId().getText()+':'+frame.getTxtNome().getText()+':'+frame.getTxtTipoDoSensor().getText();
				 while ((line = br.readLine()) != null) {

					 if(line.compareTo(line3)!=0)
						 line2 = line2 + line + '\n';
	                        
	       	    }
				br.close();
				BufferedWriter writer = new BufferedWriter(new FileWriter(frame.getCaminho()+"Sensores.txt"));
				writer.write(line2);
			    
			    writer.close();
			    frame.getTxtId().setText("");
			    frame.getTxtNome().setText("");
			    frame.getTxtTipoDoSensor().setText("");
			    
				}catch(IOException e1) {
					System.out.println(e1);
				}
			}
		});
        
        frame.getBtnAdicionar().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
				FileReader f = new FileReader(frame.getCaminho()+"Sensores.txt");
	            BufferedReader br = new BufferedReader(f);
				String line = null;
				String line2 = "";
				 while ((line = br.readLine()) != null) {
	                	
					 line2 = line2 + line + '\n';
	                        
	       	    }
				br.close();
				BufferedWriter writer = new BufferedWriter(new FileWriter(frame.getCaminho()+"Sensores.txt"));
				writer.write(line2+frame.getTxtId().getText()+':'+frame.getTxtNome().getText()+':'+frame.getTxtTipoDoSensor().getText());
			    
			    writer.close();
			    
			    frame.getTxtId().setText("");
			    frame.getTxtNome().setText("");
			    frame.getTxtTipoDoSensor().setText("");
			    
				}catch(IOException e1) {
					System.out.println(e1);
				}
			}
		});
        
        frame.getBtnSalvar().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(frame.getCaminho()+frame.getTxtNomeDoArquivo().getText()+".txt"));
				LinkedList<Data> l = frame.getSensorAtual().getL();
				String line = "";
				for(int i = 0; i < l.size(); i++)
					line = line + l.get(i).toString() + '\n';
				
				writer.write(line);
			    frame.getTxtNomeDoArquivo().setText("");
			    writer.close();
				}catch(IOException e1) {
					System.out.println(e1);
				}
			}
		});
        
        frame.getBtnTrocar().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setSensorAtual(sensores.get(frame.getComboBox().getSelectedIndex()+1));
				frame.getLblSensor().setText(frame.getSensorAtual().getName());
				Grafico g = new Grafico(frame.getSensorAtual().getL());
				frame.setG(g);
			}
		});
        
  
        frame.setVisible(true);
        
        try {
			while (true) {
	            if (ciclos % atualizasensores == 0) {
	            	
	            	for(int i = 0; i < 10; i++) {
	                	
	                	vector[i] = false;
	                	
	                }
	            	
	                System.out.println("--------Atualizando lista de sensores: ciclo " + ciclos + "--------");
	                
	                FileReader f = new FileReader(frame.getCaminho()+"Sensores.txt");
	                BufferedReader br = new BufferedReader(f);

	                String line = null;
	                while ((line = br.readLine()) != null) {
	                	
	                    String dsensor[] = line.split(":");
	                    if(sensores.containsKey(Integer.parseInt(dsensor[0]))==false) {
	                    	Sensor s = (Sensor) Class.forName(dsensor[2]).newInstance();
	                        s.setId(Integer.parseInt(dsensor[0]));
	                        s.setName(dsensor[1]);
	                        sensores.put(Integer.parseInt(dsensor[0]),s);
	                        System.out.println(line);
	                        if(start==false) {
	                        	frame.setSensorAtual(s);
		                    	start = true;
		                    	frame.getLblSensor().setText(frame.getSensorAtual().getName());
		                    }
	                        frame.getComboBox().addItem(dsensor[1]);
	                        
	       	    	 	}
	                    
	       	    	 	vector[Integer.parseInt(dsensor[0])] = true;
	       	    	 	
	                    
	                }
	                for(int i = 0; i < 10; i++) {
	                	
	                	if(vector[i]==false && sensores.containsKey(i)==true) {
	                		
	                		 frame.getComboBox().removeItem(sensores.get(i).getName());
	                		sensores.remove(i);
	                	}
	                	
	                }
	                f.close();
	            }
	            
	            
	            
	            System.out.println("----Leitura dos sensores: ciclo " + ciclos + "----");
	            for (Sensor s : sensores.values()){
	                System.out.println("Sensor: " + s.getId() + " - " + s.getName() + " - " + s.getValue());
	                System.out.println(s.toString());
	            }

	            Thread.sleep(intervalociclos);
	            
	            ciclos++;
	        }
        
        }catch(ClassNotFoundException e) {
        	
        	System.out.println(e);
        	
        }catch(InstantiationException e) {
        	
        	System.out.println(e);
        	
        }catch(FileNotFoundException e) {
        	
        	System.out.println(e);
        	
        }catch(IllegalAccessException e) {
        	
        	System.out.println(e);
        	
        }catch(IOException e){
        	
        	System.out.println(e);
        	
        }catch(InterruptedException e) {
        	
        	System.out.println(e);
        	
        }
	}

}
