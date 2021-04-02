import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport{
	private GregorianCalendar date;
	private LinkedList<Double> temps;
	private LinkedList<Double> rainfall;
	
	DailyWeatherReport(GregorianCalendar date, LinkedList<Double> temps, LinkedList<Double> rainfall){
		this.date = date;
		this.temps = temps; 
		this.rainfall = rainfall;
	}	
	
	/**
	 * 
	 * @param month is the integer to compare the month-equivalent of the date parameter
	 * @return true or false depending on whether or not the date parameter and month parameter match
	 */
	public boolean checkMonth(int month) {
		int dateMonth = this.date.get(GregorianCalendar.MONTH);
		if(dateMonth == month) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param year is the integer to compare the year-equivalent of the date parameter
	 * @return true or false depending on whether or not the date parameter and year parameter match
	 */
	public boolean checkYear(int year) {
		int dateYear = date.get(GregorianCalendar.YEAR);
		if(dateYear == year) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return the total temperature adding each element through the LinkedList<Double> field of temperatures
	 */
	public double totalTempForDay() {
		double totalTemp = 0;
		for(Double temp : this.temps) {
			totalTemp = totalTemp + temp;
		}
		return totalTemp;
	}
	
	/**
	 * 
	 * @return the amount of readings in a given list of readings
	 */
	public double numOfReadingsForDay() {
		double numOfReadings = 0;
		for(Double temp : this.temps) {
			numOfReadings++;
		}
		return numOfReadings;
	}
	
	/**
	 * 
	 * @return the total rainfall adding each element through the LinkedList<Double> field of rainfall
	 */
	public double totalRainfallForDay() {
		double totalRainfall = 0;
		for(Double rainfall : this.rainfall) {
			totalRainfall = totalRainfall + rainfall;
		}
		return totalRainfall;
	}
	
	public boolean equals(DailyWeatherReport dayTest) {
		if(dayTest.date.equals(this.date)&&
		   dayTest.temps.equals(this.temps)&&
		   dayTest.rainfall.equals(this.rainfall)) {
			return true;
		}
		else return false;
	}
	
}
