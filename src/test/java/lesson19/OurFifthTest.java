package lesson19;

import org.testng.annotations.Test;

public class OurFifthTest {

    @Test (groups = {"test-group"})
    public void ourFirstTestMethod(){
        System.out.println("It is our first method in the fifth test");
    }

    @Test()
    public void secondTestMethod(){
        System.out.println("It is our second method in the fifth test");
    }
}
