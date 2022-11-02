package lesson19;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryClass {

    @Factory()
    @Test
    public Object[] getFactoryMethod(){
        Object[] factoryTest = new Object[2];
        factoryTest[0] = new OurSeventhTest();
        factoryTest[1] = new OurEighthTest();
        return factoryTest;
    }
}
