package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_TumSayfaResmi extends TestBase {
    @Test
    public void test01() {
        /*

        Bir webelementin resmini almak için önce Webelementi locate edip bir webelemente assing ederiz.
       ve bu webelementi direk getScreenShotAs() methodunu kullanarak resmini belirttimiz dosyaya kaydederiz.

         */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        tumSayfaResmi();
    }
}

