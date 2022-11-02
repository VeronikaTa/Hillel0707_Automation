package lesson19;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
    @DataProvider(name = "routes")
    public Object[][] dataPorividerMethod(){
        return new Object[][] {{"route_1, www.ithillel.ua"}, {"route_2, www.ithille.ua/contacts"}};
    }
    @Test(dataProvider = "routes")
    public void testCheckingLogo(String data){
        System.out.println("Test started with data "+ data);
        System.out.println("Checking logo");
    }
}

