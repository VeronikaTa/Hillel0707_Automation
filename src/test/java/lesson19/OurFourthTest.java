package lesson19;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OurFourthTest {

    @Parameters({"username", "password"})
    @Test()
    public void ourFirstTestMethod(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }

    @Test()
    public void ourSecondtestMethod(){
        System.out.println("This is our second test");
    }
}
