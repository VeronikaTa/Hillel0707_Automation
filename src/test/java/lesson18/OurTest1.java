package lesson18;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OurTest1 {

    @BeforeTest

    public void beforeTest(){
        System.out.println("executed before test");
    }
    @Test
    public  void FirstTest(){
        System.out.println("opened google.com.ua");
    }

    @Test
    public void secondTest(){
        System.out.println("opened apple.com");
    }
}
