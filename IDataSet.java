import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IDataSet {
	public double averageTempForMonth(int month, int year);
	public double totalRainfallForMonth(int month, int year);
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings);
	
	
}
