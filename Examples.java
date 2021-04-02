import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {
	
	LinkedList<Double> temps = new LinkedList<Double>();
	LinkedList<Double> rainfall = new LinkedList<Double>();
	
	GregorianCalendar date1= new GregorianCalendar(2020, 11, 1);
	GregorianCalendar date2= new GregorianCalendar(2020, 10, 1);
	GregorianCalendar date3= new GregorianCalendar(2021, 11, 1);
	
	DailyWeatherReport day1 = new DailyWeatherReport(date1, temps, rainfall);
	DailyWeatherReport day2 = new DailyWeatherReport(date2, temps, rainfall);
	DailyWeatherReport day3 = new DailyWeatherReport(date2, temps, rainfall);
	
	LinkedList<Reading> dailyReadingsLL = new LinkedList<Reading>();
	Reading reading00 = new Reading(new Time(2, 15), 1.0, 1.0);
	Reading reading01 = new Reading(new Time(2, 20), 2.0, 2.0);
	Reading reading02 = new Reading(new Time(2, 25), 3.0, 3.0);
	Reading reading03 = new Reading(new Time(2, 30), 4.0, 4.0);
	Reading reading04 = new Reading(new Time(2, 35), 5.0, 5.0);
	
	ArrayList<DailyWeatherReport> arrayList = new ArrayList<DailyWeatherReport>();
	ArrayWeatherReport arrayWeather = new ArrayWeatherReport(arrayList) ;
	
	LinkedList<DailyWeatherReport> linkedList = new LinkedList<DailyWeatherReport>();
	WeatherLinkedList linkedListWeather = new WeatherLinkedList(linkedList);
	
	WeatherMonitor weatherMonitor1 = new WeatherMonitor(linkedListWeather);
	WeatherMonitor weatherMonitor2 = new WeatherMonitor(arrayWeather);
	
	WeatherMonitor wMTest1 = new WeatherMonitor(linkedListWeather);
	
	
	
	
	public Examples(){
	
	temps.add(1.0);
	temps.add(2.0);
	temps.add(3.0);
	temps.add(4.0);
	temps.add(5.0);
	
	rainfall.add(1.0);
	rainfall.add(2.0);
	rainfall.add(3.0);
	rainfall.add(4.0);
	rainfall.add(5.0);
	
	dailyReadingsLL.add(reading00);
	dailyReadingsLL.add(reading01);
	dailyReadingsLL.add(reading02);
	dailyReadingsLL.add(reading03);
	dailyReadingsLL.add(reading04);
		
	
	weatherMonitor1.addDailyReport(date1, dailyReadingsLL);
	weatherMonitor1.addDailyReport(date2, dailyReadingsLL);
	weatherMonitor1.addDailyReport(date2, dailyReadingsLL);
	weatherMonitor2.addDailyReport(date1, dailyReadingsLL);
	weatherMonitor2.addDailyReport(date2, dailyReadingsLL);
	weatherMonitor2.addDailyReport(date2, dailyReadingsLL);
	
	
	}
	
	@Test
	public void avgTempForMonthLLNoReport() {
		LinkedList<DailyWeatherReport> linkedList = new LinkedList<DailyWeatherReport>();
		linkedList.add(day1);
		linkedList.add(day2);
		linkedList.add(day3);
		WeatherLinkedList linkedListWeather = new WeatherLinkedList(linkedList);
		assertTrue(weatherMonitor1.averageTempForMonth(9, 2020) == 0.0);
	}
	
	@Test
	public void avgTempForMonthLLOneReport() {
		assertTrue(weatherMonitor1.averageTempForMonth(11, 2020) == 3.0);
	}
	
	@Test
	public void avgTempForMonthLLTwoReport() {
		LinkedList<DailyWeatherReport> linkedList = new LinkedList<DailyWeatherReport>();
		linkedList.add(day1);
		linkedList.add(day2);
		linkedList.add(day3);
		WeatherLinkedList linkedListWeather = new WeatherLinkedList(linkedList);
		assertTrue(weatherMonitor1.averageTempForMonth(10, 2020) == 3.0);
	}
	
	@Test
	public void totalRainfallLLNoReport() {
		LinkedList<DailyWeatherReport> linkedList = new LinkedList<DailyWeatherReport>();
		linkedList.add(day1);
		linkedList.add(day2);
		linkedList.add(day3);
		WeatherLinkedList linkedListWeather = new WeatherLinkedList(linkedList);
		assertTrue(weatherMonitor1.totalRainfallForMonth(9, 2020) == 0.0);
	}
	
	@Test
	public void totalRainfallLLOneReport() {
		LinkedList<DailyWeatherReport> linkedList = new LinkedList<DailyWeatherReport>();
		linkedList.add(day1);
		linkedList.add(day2);
		linkedList.add(day3);
		WeatherLinkedList linkedListWeather = new WeatherLinkedList(linkedList);
		assertTrue(weatherMonitor1.totalRainfallForMonth(11, 2020) == 15.0);
	}
	
	@Test
	public void totalRainfallLLTwoReport() {
		LinkedList<DailyWeatherReport> linkedList = new LinkedList<DailyWeatherReport>();
		linkedList.add(day1);
		linkedList.add(day2);
		linkedList.add(day3);
		WeatherLinkedList linkedListWeather = new WeatherLinkedList(linkedList);
		assertTrue(weatherMonitor1.totalRainfallForMonth(10, 2020) == 30.0);
	}
	
	@Test
	public void avgTempForMonthALNoReport() {
		ArrayList<DailyWeatherReport> arrayList = new ArrayList<DailyWeatherReport>();
		arrayList.add(day1);
		arrayList.add(day2);
		arrayList.add(day3);
		ArrayWeatherReport arrayWeather = new ArrayWeatherReport(arrayList) ;
		assertTrue(weatherMonitor2.averageTempForMonth(9, 2020) == 0.0);
	}
	
	@Test
	public void avgTempForMonthALOneReport() {
		ArrayList<DailyWeatherReport> arrayList = new ArrayList<DailyWeatherReport>();
		arrayList.add(day1);
		arrayList.add(day2);
		arrayList.add(day3);
		ArrayWeatherReport arrayWeather = new ArrayWeatherReport(arrayList) ;
		assertTrue(weatherMonitor2.averageTempForMonth(11, 2020) == 3.0);
	}
	
	@Test
	public void avgTempForMonthALTwoReport() {
		ArrayList<DailyWeatherReport> arrayList = new ArrayList<DailyWeatherReport>();
		arrayList.add(day1);
		arrayList.add(day2);
		arrayList.add(day3);
		ArrayWeatherReport arrayWeather = new ArrayWeatherReport(arrayList) ;
		assertTrue(weatherMonitor2.averageTempForMonth(10, 2020) == 3.0);
	}
	
	@Test
	public void totalRainfallALNoReport() {
		ArrayList<DailyWeatherReport> arrayList = new ArrayList<DailyWeatherReport>();
		arrayList.add(day1);
		arrayList.add(day2);
		arrayList.add(day3);
		ArrayWeatherReport arrayWeather = new ArrayWeatherReport(arrayList) ;
		assertTrue(weatherMonitor2.totalRainfallForMonth(9, 2020) == 0.0);
	}
	
	@Test
	public void totalRainfallALOneReport() {
		ArrayList<DailyWeatherReport> arrayList = new ArrayList<DailyWeatherReport>();
		arrayList.add(day1);
		arrayList.add(day2);
		arrayList.add(day3);
		ArrayWeatherReport arrayWeather = new ArrayWeatherReport(arrayList) ;
		assertTrue(weatherMonitor2.totalRainfallForMonth(11, 2020) == 15.0);
	}
	
	@Test
	public void totalRainfallALTwoReport() {
		ArrayList<DailyWeatherReport> arrayList = new ArrayList<DailyWeatherReport>();
		arrayList.add(day1);
		arrayList.add(day2);
		arrayList.add(day3);
		ArrayWeatherReport arrayWeather = new ArrayWeatherReport(arrayList) ;
		assertTrue(weatherMonitor2.totalRainfallForMonth(10, 2020) == 30.0);
	}
		
}
