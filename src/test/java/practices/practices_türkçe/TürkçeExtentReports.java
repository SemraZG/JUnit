package practices.practices_türkçe;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TürkçeExtentReports extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    @BeforeClass
    public static void extentReportsSetUp(){

        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

//        ***************
//        adding custom System Info
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("QA","John Fox");
        extentReports.setSystemInfo("Sprint Number","SP205");


//        adding more custom info
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");
//        ********************

//        DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter);
//        SUMMARY: Extent Reports and Extent HTML Reporter is used to add custom information on the report and create the report in a PATH

//        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");

    }

    @Test
    public void extentReportsTest(){
        extentTest.pass("PASS");
        extentTest.info("BİLGİLENDİRME NOTU");
        extentTest.fail("FAILED");
        extentTest.warning("UYARI MESAJI");
        extentTest.skip("ATLAMA MESAJI");
        extentTest.fatal("ÇOKUS HATASI");
    }
    @AfterClass
    public static void extentReportsTearDown(){
        extentReports.flush();
    }


     /*

    Maven projeleri için Extent Report depency oluşturmamız gerekir

    Extent Report ayrı bir Api dır, bu api dan gelen metotlar yardımıyla rapor sablonu oluşturabilir.
    Otomasyon raporları almak için kullanılır.
    Extent Report selenium dışında da kullanılabilir.
    3 class kullanıyoruz;
        1.ExtentReports(şablonu oluşturur),
        2.ExtentHTMLReporter(şablonu projeye ekler),
        3.ExtentTest(raporlama işlemi yapar, logları rapora yazdırır.

    Bu sınıflar yardımıyla platform, browser, takım bilgileri gibi özel proje bilgileri eklenebilir.
    Ayrıca extent test objesi kullanılkrak pass, fail, info skip gibi loglamalar yapabilirim


    Raporlamaları nasıl yaparsınız?
        Manuel test yaparken elle ekran görüntüsü alıp bir dokümana eklerimve jiraya yüklerim
        Otomasyonda ise ExtentReports ile html raporunu cıkartırım
        ExtentReports raporları değiştirilebilir, editlenebilir
        Test case fail olduğunda otomatik ekran görüntüsü alacak şekilde ayarlanabilir.

    ExtentReports un avantajları neler?
    Open source-ücretsiz
    Farklı browserlar ile ve farklı işletim sistemleri ile çalışabiliyor
    Junit, testNG veya cucumber gibi farklı frameworkler ile entegre olabilir
    Her bir test adımnı log yapabiliriz(rapora yazdırabiliriz)
    Editlenebilir

     */

}
