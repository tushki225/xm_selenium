package test.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

public class DateFormatter {
	public static Date date = new Date();
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd");

	public static String getTodayDate() {
		String stringDate = dateFormat.format(date);
		return stringDate;
	}

	public static String getTommorowDate() {
		DateTime dtOrg = new DateTime(date);
		DateTime dtPlusOne = dtOrg.plusDays(1);

		String stringDate = dateFormat.format(dtPlusOne.toDate());
		return stringDate;
	}

	public static String getNextWeekDate() {
		Calendar now = Calendar.getInstance();
		int weekday = now.get(Calendar.DAY_OF_WEEK);
		
		int days = (weekday-2);
	    now.add(Calendar.DAY_OF_YEAR, 7-days);
		
		// now is the date you want
		Date date = now.getTime();
		String stringDate = dateFormat.format(date);
		return stringDate;

	}

}
