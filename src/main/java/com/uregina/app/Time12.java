package com.uregina.app;

import com.uregina.exceptions.*;

/**
 * 12-hour time
 *
 */
public class Time12 
{
	private int hours;		// 1:12
	private int minutes;	// 0:59
	private AmPm am_pm;		// am or pm
	/** 
	 * constructor to initial Time12 object
	 * @param hours 		hours of 12-hour time format (1:12)
	 * @param minutes		minutes of 12-hour time format (0:59)
	 * @param am_pm			am or pm
	*/
    public Time12 (int hours, int minutes, AmPm am_pm) throws InvalidTimeException
    {
		//if(hours<1||hours>=12) throw new InvalidTimeException();
		if(hours<1||hours>12) throw new InvalidTimeException( );
		if(minutes<0||minutes>=60) throw new InvalidTimeException();
        this.hours=hours;
		this.minutes=minutes;
		this.am_pm=am_pm;
    }
	/**
	 * Convert time 12-hour to 24-hour
	*/
	public Time24 toTime24() 
	{
		return Time24.toTime24(this.hours, this.minutes, this.am_pm);
	}
	/**
	* returns the hours of 12-hour time format (1:12)
	*/
	public int getHours(){
		return this.hours;
	}
	/**
	* returns the minutes of 12-hour time format (0:59)
	*/
	public int getMinutes(){
		return this.minutes;
	}
	/**
	* returns the am/pm of 12-hour time format
	*/
	public AmPm getAM_or_PM(){
		return this.am_pm;
	}
	/**
	 * Convert Time12 object to string
	 * @param  None
	 * @return a string in the fromat HH:MM am/pm
	*/
	public String toString()
	{
		return String.format("%2d:%2d",this.hours,this.minutes)+(this.am_pm==AmPm.am? " am":" pm");
	}
	/**
	 * calculates the minutes of subracting two valid Time12 objects 
	 * 		assuming that both times happened in the same day.
	 * @param t1 	12-hour time object
	 * @param t1 	12-hour time object
	 * @return 		minutes equivalent of calculating (t1-t2)
	 * 				which can be positive, zero or negative integer
	 * usefeul functions that you may use
	 * 		(class: Time12 , method: toTime24)
	 * 		(class: Time24 , method: getHours)
	 * 		(class: Time24 , method: getMinutes)
	*/
	/*	QQQ
		Carter Comments: 
		The first step in this subtracting is finding which time is greater.
		based on what we can see from the 'lessThan' method, it will require a basic integer.
		it will check if flight1's time is less than flight2's time. and it will return a positive, negative, or zero integer.

		It wont be a subtraction function as much as it will be a difference function, either positive, negative, or zero.
		Therefore the goal of this function is the following: 
		
		t1.hours will subtract t2.hours and store the difference with respect to 12 hour time

		t1.minutes will subtract t2.minutes and store the difference with respect to 12 hour time

		the minute equivalent will be generated
		aka ( hours * 60 ) + minutes
	*/  
	public static int subtract(Time12 t1, Time12 t2)
	{
		int difference=0;
		//Todo: add your code here
		int t1hour = t1.getHours();
		int t1min = t1.getMinutes();
		int t2hour = t2.getHours();
		int t2min = t2.getMinutes();

		int hourDif = t1hour - t2hour;
		int minuteDif = t1min - t2min;

		difference  = (hourDif * 60) + minuteDif;
		// end of your code
		return difference;
	}
	/**
	 * checks if a Time12 is before another one
	 * @param 	t1 a Time12 object
	 * @param 	t2 a Time12 object
	 * @return	true if t1<t2, false otherwise
	*/
	public static boolean lessThan(Time12 t1,Time12 t2)
	{
		// will return a difference of integer (minutes) either +,-,0.
		return Time12.subtract(t1,t2)<0;
	}
}
