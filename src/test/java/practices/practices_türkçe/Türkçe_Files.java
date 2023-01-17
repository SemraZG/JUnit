package practices.practices_türkçe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Türkçe_Files extends TestBase {
    @Test
    public void test(){

        //-----------masaüstündeki text dosyasının varlığını verify edin

        String userHOME=System.getProperty("user.home");

        //"C:\Users\semra\OneDrive\Masaüstü\text.txt"

        String filePath=userHOME+"/OneDrive/Masaüstü/text.txt";
        System.out.println(filePath);

        boolean isExist= Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist);



        //-----------indirilen dosyanın varlığını verify edin

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //Download b10 all test cases, code.docx file
        driver.findElement(By.partialLinkText("code.docx")).click();
        waitFor(2);//hard wait kullandık, explicit wait kullanamam çünkü dosya masaüstüne iniyor, siteyle ilgili bir durum değil

        //Verify if the file downloaded successfully
        String filepath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";

        boolean isDownloaded = Files.exists(Paths.get(filepath));
        assertTrue(isDownloaded);




        //----------- dosyanın yüklenebildiğini verify edin

        driver.get("https://the-internet.herokuapp.com/upload");
//        1. Locate choose file and click choose a file
//        <input type="file">
        WebElement chooseAFileButton = driver.findElement(By.id("file-upload"));
       waitFor(2);


//        2. select a file from your computer

        //String userHOME = System.getProperty("user.home");
        String pathOfFile = userHOME + "/OneDrive/Masaüstü/text.txt";
//        Sending the path of the file that I want to upload.
//        we can use send keys cause the input type file combination
        chooseAFileButton.sendKeys(pathOfFile);
//        3. then locate and click upload
        driver.findElement(By.id("file-submit")).click();
//        4. Asserting
        boolean isEqual = driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
        Assert.assertTrue(isEqual);



         /*

    How do you upload a file with selenium?
        First selenium has limitation automation of files. But file upload can be done with selenium.
        We locate the chose file button and use sendKeys function to send the path of the file.
        Then we click upload button to upload the file.
        Path of the file should be dynamic - use System.getProperty("user.home");

    LIMITATION:
        Selenium has limitation automation DESKTOP APPS
        For example, we can not find path of files, or verify if file exists on out machines with selenium
        Instead we use java File libraries
     */

    }


}
