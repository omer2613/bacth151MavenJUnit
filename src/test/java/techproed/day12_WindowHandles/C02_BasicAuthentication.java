package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
        /*
    Aşağıdaki bilgileri kullanarak authentication yapınız:
    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Başarılı girişi doğrulayın.
     */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);

      //basarili bir giristen sonra congratulations! yazisini ciktigini dogrulayin
        WebElement text1 = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text1.getText().contains("Congratulations!"));

        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//-->Acilan yeni pencereye gectik

        //Başlığın Elemental Selenium olmadiğini doğrulayın
        System.out.println("sayfa basligi : " +driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());

        //ddm den java secelim
       WebElement ddm=driver.findElement(By.xpath("//select"));
       Select select=new Select(ddm);
       select.selectByVisibleText("Java");
       /*
       selectVisibleText(ddm,"Java");
        */
    }
}
