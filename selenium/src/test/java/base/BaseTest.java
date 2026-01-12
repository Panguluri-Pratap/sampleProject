package base;

import org.testng.annotations.*;

public class BaseTest {

   @BeforeTest
   public void configRead(){
       System.out.println("In Before Test....");
   }

    @AfterTest
    public void quit(){
        System.out.println("In After Test....");
    }

    @BeforeClass
    public void fileUp(){
        System.out.println("In Before Class....");
    }
    @AfterClass
    public void closeFile(){
        System.out.println("In After Class...");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("In Before Method....");
    }

    @AfterMethod
    public void end(){
        System.out.println("In After Method....");
    }
}
