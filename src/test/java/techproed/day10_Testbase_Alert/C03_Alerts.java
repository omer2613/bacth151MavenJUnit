package techproed.day10_Testbase_Alert;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alerts extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println(getTextAlert());
        Assert.assertEquals("You clicked a button",getTextAlert());
        bekle(2);
        //Ve alert'ü kapatalım
        acceptAlert();
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);
        //Çıkan alertte iptal'e basalım
        dismissAlert();
        //sonuc yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);

    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();
        bekle(2);
        //çıkan alerte ismimizi girelim
        sendKeysAlert("Erol");
        bekle(2);
        acceptAlert();
        //ismi girdiğimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Erol"));
    }


}
