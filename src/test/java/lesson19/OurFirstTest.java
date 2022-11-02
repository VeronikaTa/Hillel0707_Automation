package lesson19;

import org.testng.annotations.Listeners;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Listeners(MyProjectListener.class)
public class OurFirstTest {
    @DataProvider(name = "SetEnvironment", parallel = true)
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"chrome, 70.0"},{"chrome, 71.0"}};
    }

    @Test(dataProvider = "SetEnvironment")
    public void ourSecondTestMethod(String data){
        System.out.println(data);
    }

}
