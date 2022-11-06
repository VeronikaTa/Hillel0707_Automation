package lesson27;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {

    @Test(enabled = false)
    public void testCaseOne(){
        Assert.assertEquals(5,5);
        Assert.assertTrue("Hello".equals("hello"));
    }

    @Test
    public void testCaseTwo(){
        SoftAssert softAssert = new SoftAssert();
        System.out.println("*** test case two started ***");
        softAssert.assertEquals(5,5);
        softAssert.assertTrue("Hello".equals("hello"));
        softAssert.assertAll();
    }
}
