package operatorstest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwitchTest {
    @Test
    public void switchExample(){
        assertEquals("United Kingdom", countryName("uk"));
        assertEquals("United States", countryName("US"));
        assertEquals("United States", countryName("USA"));
        assertEquals("France", countryName("FR"));
        assertEquals("Sweden", countryName("SE"));
    }

    public String countryName(String shortCode) {
        String testCountryName;

        switch (shortCode.toUpperCase()) {
            case "UK":
                testCountryName = "United Kingdom";
                break;
            case "US":
                testCountryName = "United States";
                break;
            case "USA":
                testCountryName = "United States";
                break;
            case "FR":
                testCountryName = "France";
                break;
            case "SE":
                testCountryName = "Sweden";
                break;
            default:
                    testCountryName = "Ukraine";

        }
        return testCountryName;
    }
}
