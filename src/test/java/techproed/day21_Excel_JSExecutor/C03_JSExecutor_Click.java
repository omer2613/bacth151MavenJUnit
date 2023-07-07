package techproed.day21_Excel_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
     /*
        Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsa da javaScriptExecutor ile o webelementi handle edebiliriz
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz
        <script> tagi ile olusturdugumuz webelementleri de js executor ile handle edebiliriz
     */

    @Test
    public void test01() {
        //Amazon sayfasina gidiniz

        driver.get("https://amazon.com");

        //Satmak linkinin resmini alalim
        WebElement sellLinki=driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell(satmak) linkine Js executor kullanarak tiklayiniz
        JavascriptExecutor Js=(JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();",sellLinki);//[0] --> verilen index webelementin indexi

        //Basligin sell icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //sayfanin resmini alalim
        tumSayfaResmi();

    }

    @Test
    public void test02() {//hatali
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine tıklayınız
        sellLinki.click();

         /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
         */


        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//uyari kapatildi
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Js Executor kullanarak Sell linkine tıklayınız
        click(sellLinki);//-->Click methodu ile normal click yapmayi denedi fakat olmadi js executor ile yapti



        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }
}
