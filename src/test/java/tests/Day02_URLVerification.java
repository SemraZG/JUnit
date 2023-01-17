package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerification {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver_win32 (2)/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        //Verify if homepage url is "https://techproeducation.com/"
       String actualURL = driver.getCurrentUrl();
       String expectedURL= "https://techproeducation.com/";
       if (actualURL.equals(expectedURL)){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
           System.out.println("ACTUAL TITLE: "+ actualURL);
           System.out.println("BUT EXPECTED TITLE : "+expectedURL);
       }

       /*
       WHAT İS YOUR APPROACH FOR AUTOMATİON?
           -I read the acceptance criterias carefully.
           -I then create mt test cases.
           -Then I do my manuel testing first.
           -If all good, I start complete my automation script
           -If I find a bug/defect, then I talk to dev. Dev fixes issue, then I retest.
           -If all good, I start complete my automation script.
           -When the automation is complete, I prepare the report for the user story.
            In fact, my automation script generates html reports for us. I upload those reports to the JIRA.
           -For my manuel test cases, I manually take screenshots and prepare reports and attach them to the JIRA.

           WHAT DO YOU DO WHEN YOUR TEST CASE PASS?
           -Prepare report and upload to JIRA
           WHAT DO YOU DO WHEN YOUR TEST CASE FAIL?
           -Retest to make sure from the failure. It can be data issue, type, documentation issue or is can be a real bug.
           -If that is a bug, then talk to the dev and let them fix the bug.
           -After the fix, we retest when test cases passes we upload to JIRA.



        */

    }
}
