package techproed.day19_Extentreport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_ExtentReport extends TestBase {
    @Test
    public void test01() {
    extentReport("Chrome","Amazon Test");
    extentTest=extentReports.createTest("ExtentReport","Test Raporu");

    driver.get("https://amazon.com");
    extentTest.info("Amazon sayfasina gidildi");

    //sayfanın resmini alını
        tumSayfaResmi();
        extentTest.info("Sayfanin resmi alindi");


         //arama kutusunda iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");
        extentTest.pass("Sayfa kapatildi");
    }
}
