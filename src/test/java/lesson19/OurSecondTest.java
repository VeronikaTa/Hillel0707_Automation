package lesson19;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyProjectListener.class)
public class OurSecondTest {

    @Test()
    public void ourFirstTestMethod(){
        System.out.println("It's our first test method");
    }

    @Test()
    public void ourSecondTestMethod(){
        System.out.println("It's our second test method");
    }
}
