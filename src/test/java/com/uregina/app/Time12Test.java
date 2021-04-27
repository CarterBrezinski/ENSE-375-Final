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

    @Test void validGetters() throws InvalidTimeException{
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

    /*
    @Test
    public void validBuild() throws InvalidTimeException
    {
        boolean validCase = false;
        AmPm pmInitiation = AmPm.pm;

        Time12 time12test = new Time12(5, 37, pmInitiation);

        if((time12test.getAM_or_PM()) == pmInitiation){
            validCase = true;
        }
        assertTrue(validCase);
    }

    @Test
    public void validToString(){

    }

    */ 
}