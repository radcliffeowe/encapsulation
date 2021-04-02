import java.util.LinkedList;

public class Reading {
	private Time timestamp;
	private double temp;
	private double rainfall;
	
	Reading(Time timestamp, double temp, double rainfall){
		this.timestamp = timestamp;
		this.temp     = temp;
		this.rainfall = rainfall;
	}
	
	/**
	 * 
	 * @param readingsTemp is a LinkedList<Double> that is added the temp parameter as an element 
	 * @return a LinkedList<Double> that contains the temperature in a reading as its elements
	 */
	public LinkedList<Double> addTemp(LinkedList<Double> readingsTemp){
		readingsTemp.add(this.temp);
		return readingsTemp;
	}
	
	/**
	 * 
	 * @param readingsTemp is a LinkedList<Double> that is added the rainfall parameter as an element 
	 * @return a LinkedList<Double> that contains the rainfall in a reading as its elements
	 */
	public LinkedList<Double> addRainfall(LinkedList<Double> readingsRainfall){
		readingsRainfall.add(this.rainfall);
		return readingsRainfall;
	}
	

}
