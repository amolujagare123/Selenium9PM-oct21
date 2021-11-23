package TestNGDemo.Demos;

import org.testng.annotations.*;

public class ClassThree {

    @BeforeSuite
    public void beforeMySuite()
    {
        System.out.println("before my Suite");
    }

    @AfterSuite
    public void afterMySuite()
    {
        System.out.println("after my Suite");
    }




    @Test
    public void classThreeTest1()
    {
        System.out.println("classThreeTest1");
    }

    @Test (groups = "email")
    public void classThreeTest2()
    {
        System.out.println("classThreeTest2");
    }

    @Parameters({"username","myUrl","password"})
    @Test
    public void classThreeTest3(String user,String url,String pass)
    {
        System.out.println("url="+url);
        System.out.println("user="+user);
        System.out.println("pass="+pass);

        System.out.println("classThreeTest3");
    }
}
