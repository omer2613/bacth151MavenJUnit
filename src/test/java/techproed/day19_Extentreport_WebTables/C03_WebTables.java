package techproed.day19_Extentreport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_WebTables extends TestBase {
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
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //    Task 1 : Table1’i yazdırın
        WebElement table1= driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("tablo 1");
        System.out.println(table1.getText());
        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement satir3= driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*************************");
        System.out.println(satir3.getText());
        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sutun= driver.findElement(By.xpath("(//table)[1]//td[5]"));
        System.out.println("***********************************");
        System.out.println(sutun.getText());
        //    Task 4 : 5. Sütun verilerini yazdırın
        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
    }
}
