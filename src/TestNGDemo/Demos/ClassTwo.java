package TestNGDemo.Demos;

import org.testng.annotations.*;

public class ClassTwo {

    @BeforeTest
    public void beforeMyTest()
    {
        System.out.println("before my test");
    }

    @AfterTest
    public void afterMyTest()
    {
        System.out.println("after my test");
    }


    @BeforeSuite
    public void anotherBeforeMySuite()
    {
        System.out.println("another before my Suite");
    }

    @AfterSuite
    public void anotherAfterMySuite1()
    {
        System.out.println("another after my Suite");
    }


    @Test
    public void classTwoTest1()
    {
        System.out.println("classTwoTest1");
    }

    @Test (groups = "email")
    public void classTwoTest2()
    {
        System.out.println("classTwoTest2");
    }

    @Parameters({"username","myUrl","password"})
    @Test
    public void classTwoTest3(String user,String url,String pass)
    {
        System.out.println("url="+url);
        System.out.println("user="+user);
        System.out.println("pass="+pass);
        System.out.println("classTwoTest3");
    }
}
