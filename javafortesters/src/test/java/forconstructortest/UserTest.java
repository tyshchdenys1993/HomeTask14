package forconstructortest;

import dataforconstructor.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest {

    @Test
    public void canConstructANewUser(){
        User user1 = new User("bob", "password");
        User user2 = new User("ann", "password1");
        User user3 = new User("den", "password2");
        User user4 = new User("alex", "password3");




    }
}
