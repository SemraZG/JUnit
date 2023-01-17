//package Homework;
//
//
//    import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//        import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//
//        import static org.junit.Assert.assertEquals;
//
//    public class AmazonDropdown.java {
//        //    Create A Class: AmazonDropdown
//        //    Create A Method dropdownTest
//        //    Go to https://www.amazon.com/
//        //    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
//        //    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
//        //    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
//        //    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
//        //    Print the the total number of options in the dropdown
//        //    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
//        //            BONUS: Assert if the dropdown is in Alphabetical Order
////===========================   ****    =================================
//        WebDriver driver;
//        //    Create A Class: AmazonDropdown
//        @Before
//        public void setup(){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.manage().window().maximize();
//            driver.get("https://www.amazon.com/");
//        }
//        //    Create A Method dropdownTest
//        //    Go to https://www.amazon.com/
//        @Test
//        public void dropdownTest(){
////    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
//            WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
////    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
//            Select select = new Select(dropdown);
//            String firstOption = select.getFirstSelectedOption().getText();
//            if (firstOption.equals("All Departments")){
//                System.out.println(firstOption);
//            }else {
//                System.out.println("first option does not match");
//            }
////    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
////    (after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
//            WebElement option4 = select.getOptions().get(3);
//            if (option4.getText().equals("Amazon Devices")){
//                select.selectByIndex(3);
//            }else {
//                System.out.println("4th option does not match");
//            }
////    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
//            List<WebElement> allOptions = select.getOptions();
//            for (WebElement w: allOptions){
//                System.out.println(w.getText());
//            }
////    Print the the total number of options in the dropdown
//            System.out.println("total number of options : "+ allOptions.size());
////    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
//            boolean flag = false;
//            for (WebElement w: allOptions){
//                if (w.getText().equals("Appliances")){
//                    flag = true;
//                }
//            }
//            System.out.println("is a drop down option ‘Appliances’ : " + flag);
////            BONUS: Assert if the dropdown is in Alphabetical Order
//            List<String> optionList = new ArrayList<>();
//            for (WebElement w: allOptions){
//                optionList.add(w.getText());
//            }
//            List<String> expectedList = new ArrayList<>(optionList);
//            Collections.sort(expectedList);
//            assertEquals(expectedList,optionList);
//        }
//
//    }
//
