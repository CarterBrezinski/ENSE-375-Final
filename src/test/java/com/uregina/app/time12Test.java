package com.uregina.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.uregina.exceptions.*;
/**
 * Unit test for simple App.
 */
public class Time12Test 
{
    @Test
    public void time12isTestRunning()
    {
        assertTrue( true );
    }

    @Test
    public void time12validBuild()throws InvalidTimeException
    {
        Time12 time12test = new Time12(5, 37, AmPm.pm);
        boolean validCase = ((time12test.getAm_or_PM()) == AmPm.pm);

        assertTrue(validCase);
    }
    	/*	QQQ
		Carter Comments: 
		
        The following tests could be made for the time12.java function:
        - Making a valid working time 12
        - Set time12 followed by: getHours, getMinutes, getAm_or_PM (successful AM and PM)
        - valid toString == 
        - correct Subtract (positive, negative, zero)
        - COULD do a lessThan case, its basically just calling upon subtract and is kind of redundant. 
        - COULD add potentially 'invalid' test cases and the exceptions they throw. 
	*/  
}