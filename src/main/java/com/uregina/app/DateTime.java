package com.uregina.app;

import com.uregina.exceptions.*;

/**
 * DateTime class that consists of a Date object and a Time12 object
 *
 */
public class DateTime 
{
	Time12 time; // 12-hour time
	Date date; 	 // MM/DD/YYYY 
    /** 
	 * constructor to initial Time24 object
	 * @param time 		12-hour time object (hh:mm am/pm)
	 * @param date		date object (MM/DD/YYYY)
	*/
	public DateTime(Date date,Time12 time)
    {
		this.date=date;
		this.time=time;
    }
	/**
	* returns the 12-hour part (hh:mm am/pm) of the DateTime  
	*/
	public Time12 getTime()
	{
		return time;
	}
	/**
	* returns The date part (MM/DD/YYYY) of the DateTime  
	*/
	public Date getDate()
	{
		return date;
	}
	/**
	 * subtract two DateTimes
	 * @param  d1	a DateTime object (MM/DD/YYYY  hh:mm am/pm)
	 * @param  d2	a DateTime object (MM/DD/YYYY  hh:mm am/pm)
	 * @return 		the value of (d1-d2) in minutes
	 * 				it may be a negative value
	 *				Throws MoreThanOneDayException if d1,d2 are not at the same date or
	 * 						not a consequative days.
	 * usefeul functions that you may use
	 * 		(class: Date , method: equal)
	 * 		(class: Time12 , method: subtract)
	 * 		(class: Date , method: nextDate)
	 */

	/*
	QQQ
	Carter's Comments here:
	Use equals on both d1 & d2.
	Use nextdate on both d1 -> d2 and d2->d1, 
	if they're more than one day, then throw the exception. 
	----
	Otherwise perform the following:

	*/
	public static int subtract(DateTime d1,DateTime d2) throws MoreThanOneDayException
	{
		int diff=0;
		//Todo: add your code here
		// To ensure that they are 1 day within each other, we will perform the following: 	
		boolean boundsTest1 = Date.equal(d1.getDate().nextDate(),d2.getDate());
		boolean boundsTest2 = Date.equal(d2.getDate().nextDate(),d1.getDate());

		// These bounds tests check and see if d2 lies on either side of d1. 
		// and if they dont, then it throws the exception. 
		// If you have time, this will be a good test case.
		if((boundsTest1 != true)&&(boundsTest2 != true)) throw new MoreThanOneDayException();
		
		// If they're within 1 day of one another, then the following caluclation is performed: 
		// This could be accomplished through the use of the date and time subtraction functions
		// for myself it made more sense to 
		int date1day = d1.getDate().getDay();
		int date2day = d2.getDate().getDay();

		Time12 date1time = d1.getTime();
		Time12 date2time = d2.getTime();
		int date1Minutes = date1time.getMinutes();
		int date1Hours = date1time.getHours();
		int date2Minutes = date2time.getMinutes();
		int date2Hours = date2time.getHours();

		// There is the potential for the calculation to be thrown off due to say a previous or next day
		// occuring on a previous day/month and having a larger/smaller value associated.

		// Currently this cant cover bridging across months. 
		// This can be solved later during refactoring/2nd iteration development.
		int dayDiff = date1day - date2day;
		int timeDiff = (date1Hours - date2Hours) * 60 + (date1Minutes - date2Minutes);

		diff = timeDiff + (dayDiff * 24 * 60);

		//end of your code
		return diff;
	}
	/**
	 * Convert a DateTime object to string
	 * @param  None
	 * @return a string in the fromat MM/DD/YYYY hh:mm am/pm
	*/
	public String toString()
	{
		return date.toString()+" "+time.toString();
	}
	/**
	 * checks if a DateTime is before another one
	 * @param 	d1 a DateTime object
	 * @param 	d2 a DateTime object
	 * @return	true if d1<d2, false otherwise
	*/
	public static boolean lessThan(DateTime d1, DateTime d2)
	{
		return Date.lessThan(d1.date,d2.date) || ( Date.equal(d1.date,d2.date) && Time12.lessThan(d1.time,d2.time)) ;
	}
}
