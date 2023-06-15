package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println(ilkSayfaHandle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedText, actualText);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(3);
        /*
        Bir butona click yaptigimizda kontrolumuz disinda yeni bir sekme ya da pencere acilirsa
        yeni acilan pencenin hanle degerini bilmedigim icin normal getWindowhandle ile driver imi
        yeni pencereye geciremem. bunu getwindowhandles() methoduyla acilan tum penceleri bir set eassign edip
        ilk actigimiz pencere degilse ikinci acilan yeni penceredir mantigiyla bir loop icinde cozebiliriz
         */
        Set<String> pencereler = driver.getWindowHandles();
        for (String w : pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfaHandle)) {//464FDFDD106D4CF6A8FC802A32FDB2E8-->işk sayfa handle degeri
                driver.switchTo().window(w);//582AA770E202A1CB461D7991342501EE
            }
        }
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        String ikinciSayfaHandle = driver.getWindowHandle();
        System.out.println("ikinciSayfaHandle : " + ikinciSayfaHandle);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        String actualTitleIlksayfa = driver.getTitle();
        String expectedTitleIlkSayfa = "The Internet";
        Assert.assertEquals(expectedTitleIlkSayfa, actualTitleIlksayfa);


        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);
        bekle(2);
    }

    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        /*getWindowhandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini
         bir arrayList e atadik.Index0(sifir) dan basladigi icin kontrolum disinda acilan pencere 1.index de oldugundan
         driver.switchTo(pencereler.get(1)); ile acilan pencereye gecis yaptik

        ındex 0(sifir)
         */
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        String actualTitleIlksayfa = driver.getTitle();
        String expectedTitleIlkSayfa = "The Internet";
        Assert.assertEquals(expectedTitleIlkSayfa, actualTitleIlksayfa);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        bekle(2);
        //  ilk sayfaya tekrar dönün
        driver.switchTo().window(pencereler.get(0));
        bekle(2);
    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    /*
    Set ve ArrayList kullanmadan switchTo().window() methodu içine argüman olarak driver.getWindowHandles()
    methodunu ile bütün açılan pencereli bir array olarak alıp index belirterek isteğim pencereye geçiş yapabilirim.
     */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
        /*getWindowhandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini
         bir arrayList e atadik.Index0(sifir) dan basladigi icin kontrolum disinda acilan pencere 1.index de oldugundan
         driver.switchTo(pencereler.get(1)); ile acilan pencereye gecis yaptik

        ındex 0(sifir)
         */
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String actualTitleIlksayfa = driver.getTitle();
        String expectedTitleIlkSayfa = "The Internet";
        Assert.assertEquals(expectedTitleIlkSayfa, actualTitleIlksayfa);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        //  ilk sayfaya tekrar dönün
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
    }

    @Test
    public void test04() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        switchToWindow(1);
        /*
            Set ve ArrayList kullanmadan switchTo().window() methodu içine argüman olarak driver.getWindowHandles()
        methodunu ile bütün açılan pencereli bir array olarak alıp index belirterek isteğim pencereye geçiş yapabilirim.
     */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
        /*
               getWindowhandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini
         bir arrayList e atadik.Index0(sifir) dan basladigi icin kontrolum disinda acilan pencere 1.index de oldugundan
         driver.switchTo(pencereler.get(1)); ile acilan pencereye gecis yaptik

         */
        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        switchToWindow(0);
        String actualTitleIlksayfa = driver.getTitle();
        String expectedTitleIlkSayfa = "The Internet";
        Assert.assertEquals(expectedTitleIlkSayfa, actualTitleIlksayfa);

        //  ikinci sayfaya tekrar geçin.
        switchToWindow(1);
        bekle(2);
        //  ilk sayfaya tekrar dönün
        switchToWindow(0);
        bekle(2);
    }
}
