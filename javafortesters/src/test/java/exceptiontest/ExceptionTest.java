package exceptiontest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionTest {
    @Test
    public void nullPointerException(){
        Integer age = null;
        String ageString;
        try {
            ageString = age.toString();
        }
        catch (Exception e){
            age = 18;
            ageString = age.toString();
        }

    }
}
