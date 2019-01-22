package operatorstest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TernaryOperators {

    @Test
    public void moreTernary(){
    assertEquals("cat",catOrCats(1));
    assertEquals("cats",catOrCats(2));
    assertEquals("cats",catOrCats(0));
    }
    public String catOrCats(int numberOfCats){
        return (numberOfCats==1)?"cat":"cats";
    }


}
