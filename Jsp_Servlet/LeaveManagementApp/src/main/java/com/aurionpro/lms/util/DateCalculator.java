package com.aurionpro.lms.util;
import java.sql.Date;

public class DateCalculator {
	
	public static int findDaysDifference(Date startDate, Date endDate) {
		long diffInMillies = endDate.getTime() - startDate.getTime();
		
		long daysDiff = diffInMillies / (1000 * 60 * 60 * 24);
		
		return (int) daysDiff + 1;
	}
}
