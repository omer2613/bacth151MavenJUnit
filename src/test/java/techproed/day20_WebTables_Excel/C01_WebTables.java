package techproed.day20_WebTables_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    /*
                          WEBTABLES
         <table> tagi ile baslar
            <thead> baslıklar icin bu tag ile devam eder
                <th> table head
                    <tbody> basliklar altindaki verileri temsil eder
                        <tr> table row (satir)
                            <td> table data(tablodaki veri )
     */
    @Test
    public void test01() {

        extentReport("Chrome","WebTable");
        extentTest=extentReports.createTest("WebTable","test Raporu");


        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi");

        //    Task 1 : Table1’i yazdırın
        WebElement table1= driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 yazdirildi");
        //    Task 2 : 3. Satır verilerini yazdırın

        WebElement satir3= driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*************************");
        System.out.println(satir3.getText());
        extentTest.info("3.satir verileri yazdirildi");
        //    Task 3 : Son satırın verilerini yazdırın

        WebElement sonSatir= driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
                                                //last() -->Son satiri verir
        System.out.println("***********************************");
        System.out.println("1.tablo Son Satir Bilgileri : "+sonSatir.getText());
        extentTest.info("son satir verileriyazdirildi");

        //    Task 4 : 5. Sütun verilerini yazdırın

        WebElement besinciBaslik= driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText());//--> 5.sutun basligini yazdiracak
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5.sutun veriler yazdirildii ");

        //Task 5 :3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız
        System.out.println("**********************************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatirr.forEach(t-> System.out.print(t.getText()+"\t"));
        extentTest.info("3. satirdaki 1. ve 2. sutun bilgileri yazdirildi");

        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData

        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println();

       // WebElement satirSutun=driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));
        System.out.println(printData(2, 3));
        extentTest.info("2.satir 3.sutubn bilgileri yazdirildi");


        //3.satir 2.sutun bilgisinin jack olup olmadigini dogrulayin

        printData(3,2);
        String actuelData=printData(3,2);
        String expectedData="jack";
        Assert.assertNotEquals(expectedData,actuelData);
       extentTest.fail("3.satir 2. sutun bilgisinin jason oldugu goruldu");
       extentTest.pass("sayfa kapatildi");
       extentReports.flush();
    }

    private String printData(int satir, int sutun) {
        WebElement satirSutun=driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        return satirSutun.getText();
    }

    //ODEV
    // C03_WebTables Class'i icin aldigimiz rapora gidelim
    //not:driver.get("testOutput/extentReports/extentReport_09_54_19_26062023.html")
    // Basligin Extent Report oldugunu test edelim
    // Rapor temasini dark yapalim
    // Dashboard bolumune gidip tabloyu yazdiriniz Tester'in "isminiz" oldugunu dogrulayalim
    // Sayfayi kapatalim
}
