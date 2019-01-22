package packageforotherclasses;

import domainobject.TestAppEnv;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestApplicationEnv {
    @Test
    public void canGetUrlStatically(){
        Assert.assertEquals("URL is correct",
                "http://172.17.66.220:9100",
                TestAppEnv.getUrl());
    }

    @Test
    public void canGetDomainStatically(){
        assertEquals("Domain is correct","172.17.66.220",TestAppEnv.DOMAIN);
        assertEquals("Port is correct","9100",TestAppEnv.PORT);
    }
}
