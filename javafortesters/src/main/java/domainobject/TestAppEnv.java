package domainobject;

public class TestAppEnv {

    public static final String DOMAIN = "172.17.66.220";
    public static final String PORT = "9100";

    public static String getUrl(){
        return "http://" + DOMAIN + ":" + PORT;
    }
}
