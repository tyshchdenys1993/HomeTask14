package operatorstest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwitchOnInt {
    @Test
    public void switchOnIntTest(){
        assertEquals("One", numberInLetters(1));
        assertEquals("Two", numberInLetters(2));
        assertEquals("Three", numberInLetters(3));
        assertEquals("Four", numberInLetters(4));
        assertEquals("Too small", numberInLetters(0));
        assertEquals("Too big", numberInLetters(Integer.MAX_VALUE));
        assertEquals("Too small", numberInLetters(Integer.MIN_VALUE));
    }

    public String numberInLetters(int numberInDigit){
        String numberInLetters = null;
        switch (numberInDigit){
            case 1:
                numberInLetters = "One";
                break;
            case 2:
                numberInLetters = "Two";
                break;
            case 3:
                numberInLetters = "Three";
                break;
            case 4:
                numberInLetters = "Four";
                break;
            default:
                if (numberInDigit>4){
                    numberInLetters="Too big";
                }
                if(numberInDigit<1){
                    numberInLetters="Too small";
                    break;
            }
        }
        return numberInLetters;
    }
}
