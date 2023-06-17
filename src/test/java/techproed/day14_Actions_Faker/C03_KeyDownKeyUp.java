package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu
        // serbest bırakarak java yazdıralım
        WebElement aramakutusu=driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions=new Actions(driver);
        actions.keyDown(aramakutusu, Keys.SHIFT). //-->arama sonunda shift tusuna bastik
                 sendKeys("selenium").//-->selenium metnini shift tuşuna basılı kaldığı için büyük yazdı
                 keyUp(Keys.SHIFT).//-->Shift tusunu serbest biratik
                 sendKeys("-java",Keys.ENTER).//NOT: shift tusu basili tutuldugunda yaziyi büyük harflerle yazar
                 perform();
    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu
        // serbest bırakarak java yazdıralım
        WebElement aramakutusu=driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
        /*
        Mouse islemleri icin actions class ini kullanmanizgerekir.
        fakat bir metin kutusundaki klavya islemleri icin actions class ini kullanmadan
        sendKeys() method u ile de istedigimiz bir metni buyuk harfle yazdirabilir.
       hatta birden fazla klavye tuslarina bastirabiliriz.
       Yukaridaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek
        sonrasinda yazdirmak istedigimiz metni kucuk harfle yazmamiza ragmen buyuk harflerle yazdirdi,
        tekrar Keys.SHIFT
        kullanarak shift tusunu serbest birakmis olduk

         */

    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("selenium",Keys.ENTER);
        // Sayfayı bekleyin
        bekle(3);
        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//sayfa yenilendigi icin tekrar locate aldik
                sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");//kelmeyi kestik
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);//kelimeyi yapistirdik

    }
}
