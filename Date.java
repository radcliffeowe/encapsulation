
public class Date {
	private String month;
	private int day;
	private int year;

	public Date(String month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public boolean dateSame(Date d2) {
		return this.month.equals(d2.month) && this.day == d2.day && this.year == d2.year;
	}
}