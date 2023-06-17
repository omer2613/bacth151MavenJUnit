package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //sayfanin altina dogru gidelim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //sayfanin en altina  scrool yapalim
       Actions actions=new Actions(driver);
       actions.sendKeys(Keys.END).perform();
        bekle(2);
        //sayfanin en ustune scrool yapalim
        actions.sendKeys(Keys.HOME).perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
        //release(serbest birakmak)--> methodu mouse birakir.
    }

    @Test
    public void test03() {

        /*
        scrollByAmount(0,1500) kartezyen koordinat sistemi olan
        yatay ve düsey yönleri x ve y olarak adlandirdigimiz sistemde x=0 ile y=+1500 arasinda
        gidecektir. pozitif(+) yön kuzey secilmistir
 */
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //sayfanin en altina  dogru gidelim
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,1500).perform();

        bekle(2);
        //sayfanin en ustune dogru gidelim
        actions.scrollByAmount(0,-1500).perform();
    }
}
