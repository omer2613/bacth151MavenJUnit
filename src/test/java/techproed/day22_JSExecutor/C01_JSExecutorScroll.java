package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_JSExecutorScroll extends TestBase {

        /*
            Actions class'ındaki gibi js executor ile de sayfada scroll işlemi yapabiliriz. Bir webelementi locate edip
         o webelement görünür olana kadar scroll yapabiliriz
        "arguments[0].scrollIntoView(true);",Webelement --> Bu script kodu ile belirtmiş olduğumuz webelemente scroll
         yaparız
         */



    @Test
    public void test01() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weofferWE= driver.findElement(By.xpath("//*[.='we offer']"));
        jsScrollWE(weofferWE);
        tumSayfaResmi();//-->TestBase deki ScreenShot methodu

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrolFreeWE= driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrolFreeWE);
        bekle(3);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUsWE = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jsScrollWE(whyUsWE);
        bekle(3);
        tumSayfaResmi();
        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
       jsScrollWE(enrolFreeWE);
        bekle(3);
        tumSayfaResmi();
        //Sayfayı en alta scroll yapalım
       scrollEnd();
        //Sayfayi en üste scroll yapalım
        scrollHome();
    }

    @Test
    public void test02() {
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,2000)");//x=0,y=2000 pixel olarak bir noktaya scroll yapar
    }
}
