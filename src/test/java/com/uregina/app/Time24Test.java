package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

//QQQ IMPORT EXCEPTIONS
import com.uregina.exceptions.*;

/**
 * Unit test for simple App.
 */
public class Time24Test 
{
    @Test
    public void time24isTestRunning()
    {
        assertTrue( true );
    }

    // This test in theory should be broken up into successful 
    // builds for getting hours, and getting minutes
    // I am combining this build for time, and ensuring it assertsTrue means that 
    // the setting of the time24 was successful. 
    @Test
    public void time24validBuild()throws InvalidTimeException{
        // Test instance is 5:24pm
        Time24 time24 = new Time24(17, 24);

        int hours = time24.getHours();
        int minutes = time24.getMinutes();
        boolean validCase = true;

        // If this if block goes through on either case, then
        // it will set validCase to false and this test will fail.
        if(hours != 17 || minutes != 24){
            validCase = false;
        }

        assertEquals(true, validCase);
    }



    /*	QQQ
		Carter Comments: 
		
        The following tests could be made for the time12.java function:
        - Making a valid working time 24
        - Set time24 followed by: getHours, getMinutes
        - valid toString == 
        - correct Subtract (positive, negative, zero)
        - COULD add potentially 'invalid' test cases and the exceptions they throw. 
	*/  
}