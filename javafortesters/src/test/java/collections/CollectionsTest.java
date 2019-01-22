package collections;

import dataforconstructor.User;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollectionsTest {


    @Test
    public void collectionTest(){
        Map<String, User> sampleMap = new HashMap<>();
        User Den = new User("login", "password");
        User Ann = new User ("Ann", "pa55word");
        sampleMap.put("key1",Den);
        sampleMap.put("key1", Ann);
        assertEquals(1, sampleMap.size());


    }
}
