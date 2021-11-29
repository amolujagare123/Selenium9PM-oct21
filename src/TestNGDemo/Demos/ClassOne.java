package TestNGDemo.Demos;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassOne {

    @Test
    public void classOneTest1()
    {
        System.out.println("classOneTest1");

        Assert.assertEquals(true,false,"this test is failed");
    }

    @Test (groups = "email")
    public void classOneTest2()
    {
        System.out.println("classOneTest2");
    }

    @Parameters({"myUrl","username","password"})
    @Test
    public void classOneTest3(String url,String user,String pass)
    {
        System.out.println("url="+url);
        System.out.println("user="+user);
        System.out.println("pass="+pass);
        System.out.println("classOneTest3");

    }
}
