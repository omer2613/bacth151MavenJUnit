package techproed.day11_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_HandleWindows extends TestBase {
    @Test
    public void WindowHandle() {
       /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degisken handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle= driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actuelTitle= driver.getTitle();
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actuelTitle);

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.WINDOW);//-->yeni pencereye driver e tasir

                //WindowType.TAB-->yeni bir sekme acar
        driver.get("https://www.youtube.com");
        String youtubuWindowHandle=driver.getWindowHandle();
        //Window 3'te(yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        String likedinWindowHandle= driver.getWindowHandle();
        driver.get("https://www.linkedin.com");
        /*
        WindowType.WINDOW ile de WindowType.TAB ile de driver' i her halukarda tasimiz oluruz.
        Birinde yeni pencerede acilirken digerinde yeni sekmede acilir
         */

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        bekle(3);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubuWindowHandle);
        bekle(3);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(likedinWindowHandle);
        bekle(3);
    }
}
