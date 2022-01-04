package jspbean;
import java.time.LocalDateTime;

public class Today {
	private int year;
	private int month;
	private int date;
	private int hour;
	private int minute;
	public Today() {
		LocalDateTime currentTime = LocalDateTime.now();
		year = currentTime .getYear();
		month = currentTime .getMonthValue();
		date = currentTime .getDayOfMonth();
		hour = currentTime .getHour();
		minute = currentTime.getMinute();
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDate() {
		return date;
	}	
}
