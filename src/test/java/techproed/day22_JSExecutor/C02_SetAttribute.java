package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_SetAttribute extends TestBase {
    @Test
    public void test01() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        /*
    <input> tag'ina sahip webelementlere deger gonderirken sendKeys() methodu kullaniriz
    sendKeys() methodu ile deger gonderemedigimiz durumlarda js executor ile rahatlikla deger gonderebiliriz
    <input> taglarinda attributu  degeri arama kutusu icindeki veriyi temsil eder
 */

        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'",aramaKutusu);//-->value attribute deger olarak QA yazdir.

    }

    @Test
    public void test02() {
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Arama kutusuna Java yaz
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='search']"));
        jsSendKeys("Java",aramaKutusu);
    }

    @Test
    public void test03() {
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Arama kutusuna QA yaz
        /*
            JS executer ile bir attribute değer atayabiliriz. aşağıdaki örnekteki gibi
           sayfadaki arama kutusunu locate edip arama kutusunun value attributeune 'QA' eğerini atarız
 */
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);


    }

    @Test
    public void test04() {
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Arama kutusuna QA yaz

        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','omer')",aramaKutusu);

        //-->elementor-search-form-9f26725 normal de id atribute değeri
        driver.findElement(By.id("omer")).sendKeys("Java");

    }

    @Test
    public void test05() {
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz

        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@type='search']"));
        jsSetAttribute("value","QA",aramaKutusu);//-->Method ile attribute degerini(set ettik)degistirdik
    }

}
