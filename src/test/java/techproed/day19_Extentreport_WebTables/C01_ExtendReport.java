package techproed.day19_Extentreport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtendReport extends TestBase {
    /*
    EXTENTREPORT;
       1- ExtentReport(aventstack) kullanabilmek için öncelikle mvn adresinden 4.0.9 versiyon numaralı
    dependency'i pom.xml dosyamıza ekleriz.
       2- ExtentReports class'ından class seviyeninde obje oluştururuz
       3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
       4- ExtentTest class'ından class seviyeninde obje oluştururuz
     */
    ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan obje
    ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatında düzenler
    ExtentTest extentTest;//--> Test adınlarına eklemek istediğimiz bilgileri bu class ile oluştururuz

    @Test
    public void test01() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatında raporlamayı başlatacak

        //Raporda gözükmesini isteğimiz bilgiler için

        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Omer");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("Extenttest", "Test Raporu");
        /*
        Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
    testle ilgili bilgileri rapora ekleyebiliriz
     */
        //amazon sayfasina gidelim

        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");


        //basligin amazon icerdiginirest edelim

        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Basligin Amazon icerdigi test edildi");

        //arama kutusunda iphone aratalim

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");

        //sonuc yazisini konsola yazdiralim

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi : " + sonucYazisi.getText());
        extentTest.info("Sonuc Yazisi Konsola Yazdirildi");
        extentTest.pass("Sayfa Kapatildi");
        /*

        extenttest objesi ile info() methodunu kullanarak her step de ne yaptigimizla lakali bilgi yazilabilir.
        testimizin en sonunda testin bittigini ifade eden pass() methodu ile testimiz ile alakali son bilgiyi ekleyebiliriz.
            Ve son olarak actions daki perform methodu gibi extentreport objesi ile flush() methodunu kullanarak raporumuzu sonlandiririz.

         */

        //Raporu sonlandiralim
        extentReports.flush();//-->bu methodu kullanmazsak raporumuz olusmaz



    }
}

