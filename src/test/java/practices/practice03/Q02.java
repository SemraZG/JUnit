package practices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
    /*
  Given
      Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
  When
     Type "My File" into "Notes about the file" input
  And
      Click "Choose File" button
  And
      Select the file to upload
  And
      Click on "Press" button
  Then
      Assert that "Your notes on the file were" equals "My File"
  And
      Assert that file Content contains "Hello, I am uploaded file"
   */
    @Test
    public void test(){
        //Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        //Type "My File" into "Notes about the file" input
        driver.findElement(By.name("note")).sendKeys("My File");

        //Click "Choose File" button
        //Select the file to upload
        driver.findElement(By.name("upfile")).sendKeys("C:/Users/semra/OneDrive/Masaüstü/Yeni Metin Belgesi.txt");//--this way does not working another computer.
//        String userHome = System.getProperty("user.home");
//        driver.findElement(By.name("upfile")).sendKeys(userHome+"/Masaüstü/Yeni Metin Belgesi.txt");

        //Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        //Assert that "Your notes on the file were" equals "My File"
        String note = driver.findElement(By.xpath("//blockquote")).getText();
        assertEquals("My File", note);

//        //Assert that file Content contains "ghfgjgjg"
        String fileContent = driver.findElement(By.xpath("//pre")).getText();
        assertTrue(fileContent.contains("ghfgjgjg"));
    }
}