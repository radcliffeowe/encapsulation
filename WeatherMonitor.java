import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor {

	private IDataSet weatherData;

	WeatherMonitor(IDataSet weatherData){
		this.weatherData = weatherData;
	}

	WeatherMonitor(){};

	/**
	 * 
	 * @param month month is a given month checked to record temperature
	 * @param year year is a given year checked to record temperature
	 * @return a double representing the average temperature for the given month 
	 */
	public double averageTempForMonth(int month, int year) {
		return weatherData.averageTempForMonth(month, year);
	}

	/**
	 * 
	 * @param month month is a given month checked to record rainfall
	 * @param year year is a given year checked to record rainfall
	 * @return a double representing the average rainfall for the given month 
	 */
	public double totalRainfallForMonth(int month, int year) {
		return weatherData.totalRainfallForMonth(month, year);
	}

	/**
	 * @param date is the date used to create a DailyWeatherReport
	 * @param readings is the LinkedList<Reading> that is being searched through
	 * @return void but add a new DailyWeatherReport to the IDataSet weatherData
	 */
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		weatherData.addDailyReport(date, readings);
	}
}
