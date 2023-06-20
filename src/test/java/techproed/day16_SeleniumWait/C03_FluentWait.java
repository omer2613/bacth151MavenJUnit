package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    /*
    FluentWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi
        için max. belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda (saniye/salise) bekler
     */

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1 ");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldYazisi=driver.findElement(By.xpath("(//h4)[2]"));
        FluentWait<WebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).//-->fluentwait max bekleme suresini belirtir
            pollingEvery(Duration.ofMillis(200)).//-->200 milisaniye araliklarla webelement in etkileşimini kontrol et
            withMessage("Webelemnti kontrol et");//--< hata alma durumunda konsolda bu mesaji verir .zorunlu degil
        wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));
        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());

    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1 ");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldYazisi=driver.findElement(By.xpath("(//h4)[2]"));
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200)).
                until(ExpectedConditions.visibilityOf(helloWorldYazisi));
        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());

    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1 ");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldYazisi=driver.findElement(By.xpath("(//h4)[2]"));
        Wait<WebDriver> wait=new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200));
                wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));
                Assert.assertEquals("Hello World! ",driver.findElement(By.xpath("(//h4)[2]")).getText());
    }

    @Test
    public void test04() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1 ");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldYazisi=driver.findElement(By.xpath("(//h4)[2]"));
        visibleFluentWait(helloWorldYazisi,20,100);
        Assert.assertEquals("Hello World!",helloWorldYazisi.getText());
    }
}
