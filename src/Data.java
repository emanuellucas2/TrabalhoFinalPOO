import java.util.Date;

public class Data {
	double value;
	Date data;
	
	public Data(double value, Date data) {
		super();
		this.value = value;
		this.data = data;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return  value + ":" + data;
	}
	
	
}
