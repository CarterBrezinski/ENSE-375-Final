    /*
     QQQ
        Carter Comments: 
        
        The following tests could be made for the time12.java function:
        - Making a valid working time12
        - Set time12 followed by: getHours, getMinutes, getAm_or_PM (successful AM and PM)
        - valid toString == 
        - correct Subtract (positive, negative, zero)
        - COULD do a lessThan case, its basically just calling upon subtract and is kind of redundant. 
        - COULD add potentially 'invalid' test cases and the exceptions they throw. 
    */

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
    public void isTestRunning()
    {
        assertTrue( true );
    }

    // Also proves that a valid build has taken place and can be accessed.
    @Test
    public void validGetters() throws InvalidTimeException{
        boolean validCase = false;

        AmPm pmInitiation = AmPm.pm;
        Time12 example = new Time12(5, 37, pmInitiation);

        AmPm getAMPM = example.getAM_or_PM();
        int getHours = example.getHours();
        int getMinutes = example.getMinutes();

        if((getAMPM == pmInitiation)&&(getHours == 5)&&(getMinutes == 37)){
            validCase = true;
        }
        assertTrue(validCase);
    }

    @Test
    public void validSubtract() throws InvalidTimeException{
        boolean validCase = false;

        AmPm pmInitiation = AmPm.pm;
        Time12 example = new Time12(5, 37, pmInitiation);
        Time12 example2 = new Time12(4, 26, pmInitiation);

        int difference = Time12.subtract(example, example2);

        if(difference == 71){
            validCase = true;
        }

        assertTrue(validCase);
    }

    @Test
    public void validToString() throws InvalidTimeException{
        boolean validCase = false;

        AmPm pmInitiation = AmPm.pm;
        Time12 example = new Time12(5, 37, pmInitiation);

        String stringVal = "5:37am";

        if(stringVal == example.toString()){
            validCase = true;
        }

        System.out.println(example.toString());

        assertTrue(validCase);
    }

    //*/ 
}