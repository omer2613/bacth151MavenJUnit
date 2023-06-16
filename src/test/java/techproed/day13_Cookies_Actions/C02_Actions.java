package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Kutuya sag tıklayın
        WebElement kutu=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(kutu).// sag click yapma methodu kullandik
                perform();//uygula ve sonlandir demek
        bekle(2);
        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        Assert.assertEquals("You selected a context menu",getTextAlert());//-->driver.switchTo().alert().getText();
        bekle(2);
        //Tamam diyerek alert'i kapatın
        acceptAlert();//-->driver.switchTo().alert().accept();
    }
}
