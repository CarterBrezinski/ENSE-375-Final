    /*
     QQQ
        Carter Comments: 
        The following make sense for a list of DateTimeTest test cases.
        - correct build for DateTime
        - given date, correct toString()
        - 2 given dates, correct lessThan conversion
        - correct getDate & getTime
        - IF YOU HAVE TIME, correct invalid cases for the above
        
    */

package com.uregina.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.uregina.exceptions.*;

public class DateTimeTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void dateTimeTestisTestRunning()
    {
        assertTrue( true );
    }

    
    // This also accounts for a valid successful build test case.
    @Test
    public void validToString() throws InvalidTimeException, InvalidDateException{
        boolean validCase = false;

        AmPm pmInitiation = AmPm.pm;
        Time12 exampleTime1 = new Time12(5, 37, pmInitiation);
        Date exampleDate1 = new Date(4, 27, 2021);
        DateTime exampleDateTime = new DateTime(exampleDate1, exampleTime1);

        //Time12 exampleTime2 = newTime12(5, 50, pmInitiation);
        //Date exampleDate2 = new Date(5, 28, 2021);

        String stringVal = " 4/27/2021  5:37 pm";

        if(stringVal.equalsIgnoreCase(exampleDateTime.toString())){
           validCase = true;
        }
        assertTrue(validCase);
    }
    
    @Test
    public void validLessThan() throws InvalidTimeException, InvalidDateException{
        boolean validCase = false;

        AmPm pmInitiation = AmPm.pm;
        Time12 exampleTime1 = new Time12(5, 37, pmInitiation);
        Date exampleDate1 = new Date(4, 27, 2021);
        DateTime exampleDateTime1 = new DateTime(exampleDate1, exampleTime1);

        Time12 exampleTime2 = new Time12(5, 50, pmInitiation);
        Date exampleDate2 = new Date(5, 28, 2021);
        DateTime exampleDateTime2 = new DateTime(exampleDate2, exampleTime2);

        validCase = DateTime.lessThan(exampleDateTime1, exampleDateTime2);

        assertTrue(validCase);
    }

}