package practices.practice04;


import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Q04 extends TestBase {
    /*
Given
   Go to https://testpages.herokuapp.com/
When
   Click on File Downloads
And
   Click on Server Download
Then
   Verify that file is downloaded
*/
    @Test
    public void test(){
//        Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

//        Click on File Downloads
        driver.findElement(By.id("download")).click();

//        Click on Server Download
        driver.findElement(By.id("server-download")).click();

//        Verify that file is downloaded
        waitFor(1);//Waited for saving the file on pc for 1 sec
        assertTrue(Files.exists(Paths.get( System.getProperty("user.home")+"/Downloads/textfile.txt")));
    }
}