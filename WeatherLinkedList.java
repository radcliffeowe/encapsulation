import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherLinkedList implements IDataSet{
	private LinkedList<DailyWeatherReport> weatherData;
	
	WeatherLinkedList(LinkedList<DailyWeatherReport> weatherData){
		this.weatherData = weatherData;
	}
	
	/**
	 * @param month is a given month checked to record temperature
	 * @param year is a given year checked to record temperature
	 * @return the average temperature over all days that month
	 */
	public double averageTempForMonth(int month, int year) {
		double totalTemp = 0;
		double numOfReadings = 0; 
		for(DailyWeatherReport day : weatherData) {
			if(day.checkMonth(month) &&
			   day.checkYear(year)) {
				totalTemp = totalTemp + day.totalTempForDay();
				numOfReadings = numOfReadings + day.numOfReadingsForDay();
			}
		}
		if(numOfReadings == 0) {
			return 0;
		}
		return totalTemp/numOfReadings;
	}
	
	/**
	 * @param month is a given month checked to record rainfall
	 * @param year is a given year checked to record rainfall
	 * @return the average rainfall over all days that month
	 */
	public double totalRainfallForMonth(int month, int year) {
		double totalRainfall = 0;
		for(DailyWeatherReport day : weatherData) {
			if(day.checkMonth(month) &&
			   day.checkYear(year)) {
				totalRainfall = totalRainfall + day.totalRainfallForDay();
			}
		}
		return totalRainfall;
	}
	
	/**
	 * @param date is the date used to create a DailyWeatherReport
	 * @param readings is the LinkedList<Reading> that is being searched through
	 * @return void but add a new DailyWeatherReport to the LinkedList weatherData
	 */
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		LinkedList<Double> readingsTemp = new LinkedList<Double>();
		LinkedList<Double> readingsRainfall = new LinkedList<Double>();
		for(Reading r : readings) {
			r.addTemp(readingsTemp);
			r.addRainfall(readingsRainfall);
		}
		weatherData.add(new DailyWeatherReport(date, readingsTemp, readingsRainfall));
	}
	
	public boolean equals(WeatherLinkedList wmTest) {
		int totalEqual = 0;
		for(int i = 0; i < weatherData.size(); i++) {
			if(this.weatherData.get(i).equals(wmTest.weatherData.get(i))) {
				totalEqual++;
			}
		}
		if(totalEqual == this.weatherData.size()) {
			return true;
		}
		else return false;
	}

}
