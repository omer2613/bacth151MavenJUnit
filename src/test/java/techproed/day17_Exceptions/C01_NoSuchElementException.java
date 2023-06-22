package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void test01() {
        /*
        NO_SUCH-ELEMENT-EXCEPTİON

        -BİR WEBELEMENTİN LOCATİNİ YANLİS ALDİGİMİZDA ELEMNETİ BULAMAYACAGİ İCİN BU EXCEPTİON U ALİRİZ.
         */
//techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
//arama kutusunda qa aratalım
       WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='search']"));

       /*
    org.openqa.selenium.NoSuchElementException:
      normal locatimiz //*[@type='search'] bu şekilde iken nosuchelementexception alabilmek için locate'i bozduk
    //*[@type='ssearch'] ve exception'ı aldığımızı gördük. Dolayısıyla bu hatayı handle edebilmek için
    düzgün locate almamız gerekiyor.Webelement bir iframe icinde olabilir,bir button atikladigimizda
     yeni bir pencere acilabilir ya da alert çıkabilir bu gibi durumlarda da nosuchelementexception alırız
        */

       aramaKutusu.sendKeys("qa", Keys.ENTER);

//sayfa başlığının qa içerdiğini test edelim

        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
//arama kutusunda qa aratalım
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("qa", Keys.ENTER);
/*
org.openqa.selenium.InvalidSelectorException:xpath ile aldigimiz bir webelementin  locate ni css selector locater ile kullanirsak bu exception u aliriz.
dolasiyle dogru locater i kullanmaliyiz

 */
//sayfa başlığının qa içerdiğini test edelim

        Assert.assertTrue(driver.getTitle().contains("qa"));
    }
}
