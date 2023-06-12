package techproed.day10_Testbase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alert extends TestBase {

    /*
    Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ klip
 yapıp locate alamıyorsak, bu bir js Alert'tür.
    js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
 driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
 accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız
 */
    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    @Test
    public void acceptAlert() {

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: acceptAlert
        driver.findElement(By.xpath("(//button)[1]")).click();
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        bekle(3);
        driver.switchTo().//gecmek icin kullanilan method
                alert().//alert e gecis yapar
                accept();//cikan alert te ok ya da tamam butonuna tiklar.
        bekle(2);
        WebElement resultMessage= driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi="You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());

    }

    @Test
    public void dismissAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: dismissAlert

        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);
        driver.switchTo().
                alert().
                dismiss();//alertteki iptal butonuna basar
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        WebElement resultMessage= driver.findElement(By.xpath("(//p)[2]"));//you clicked:cancel
        String istenenMetin="successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenMetin));


    }

    @Test
    public void sendKeysAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        driver.findElement(By.xpath("(//button)[3]")).click();
        driver.switchTo().alert().sendKeys("Omer");
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(3);
         //OK butonuna

        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement resultMessage= driver.findElement(By.xpath("(//p)[2]"));//You entered:Omer
        String girilenMetin="Omer";
        Assert.assertTrue(resultMessage.getText().contains(girilenMetin));
        bekle(3);

    }

    @Test
    public void test04() {
    }
}
