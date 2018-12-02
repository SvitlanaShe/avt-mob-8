import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void MainClassTest(){
        System.out.println("--------------------- MainClassTest");
        Assert.assertTrue("getLocalNumber returns incorrect result: expected 14, actual " + getLocalNumber(),
                getLocalNumber()==14);
        System.out.println("Test PASSED");
    }

    @Test
    public void testGetClassNumber(){
        System.out.println("--------------------- testGetClassNumber");
        Assert.assertTrue("Class number should be > 45, actually class number = " + getClassNumber(),
                getClassNumber()>45);
        System.out.println("Test PASSED");
    }

    @Test
    public void testGetClassString(){
        System.out.println("--------------------- testGetClassString");
        Assert.assertTrue("Class string does not contains 'hello', actual string is '" + getClassString() + "'",
                getClassString().contains("Hello") || getClassString().contains("hello"));
        System.out.println("Test PASSED");
    }
}
