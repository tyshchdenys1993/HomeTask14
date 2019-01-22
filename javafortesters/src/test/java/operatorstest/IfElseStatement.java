package operatorstest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IfElseStatement {

    @Test
    public void truthyIsTrue(){
    boolean truthy = true;
    boolean falsey = false;

    if(truthy){
        if(!falsey){
            if(truthy&&!falsey){
                if(truthy||falsey){
                    assertTrue(truthy);
                    assertFalse(falsey);
                }
            }
        }
        else{
            assertTrue(truthy);
            assertFalse(falsey);
        }
    }
    else{
        if(!truthy){
            if(falsey){
                assertTrue(falsey);
                assertFalse(truthy);
            }else{
                assertFalse(falsey);
                assertFalse(truthy);
            }
        }
    }
    }
}
