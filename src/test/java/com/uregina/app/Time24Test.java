    /*	QQQ
		Carter Comments: 
		
        The following tests could be made for the time12.java function:
        - Making a valid working time 24
        - Set time24 followed by: getHours, getMinutes
        - valid toString == 
        - correct Subtract (positive, negative, zero)
        - COULD add potentially 'invalid' test cases and the exceptions they throw. 
	*/  

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

    // This also shows off a successful build case 
    @Test
    public void time24validToString() throws InvalidTimeException
    {
        Time24 example = null;
        example = example.toTime24(5, 37, AmPm.pm);

        String stringVal = "17:37";

        if(stringVal.equalsIgnoreCase(example.toString())){
            validCase = true;
        }

        assertTrue(validCase);
    }

    @Test
    public void time24validsubtract() throws InvalidTimeException
    {
        Time24 example = null;
        example = example.toTime24(5, 37, AmPm.pm);

        Time24 example1 = null;
        example1 = example1.toTime24(4, 26, AmPm.pm);

        int difference = Time24.subtract(example, example1);

        if(difference == 71){
            validCase = true;
        }

        assertTrue(validCase);
    }

    @Test
    public void validGetters() throws InvalidTimeException{
        boolean validCase = false;

        Time12 example = new Time12(5, 37, pmInitiation);

        AmPm getAMPM = example.getAM_or_PM();
        int getHours = example.getHours();
        int getMinutes = example.getMinutes();

        if((getAMPM == pmInitiation)&&(getHours == 5)&&(getMinutes == 37)){
            validCase = true;
        }
        assertTrue(validCase);
    }
}