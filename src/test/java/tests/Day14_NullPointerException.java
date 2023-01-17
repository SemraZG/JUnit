package tests;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.TestBase;

public class Day14_NullPointerException {

    WebDriver driver;//null
    Integer number;
    String str;
    @Test
    public void nullPointerExceptionTest(){
        driver.get("https://techproeducation.com/");
    }

    @Test
    public void nullPointerExceptionTest2(){
        System.out.println(number+1);//number is not assigned. so it is null
    }
    @Test
    public void nullPointerExceptionTest3(){
        str.substring(0);
    }


}
