package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_GetAttribute extends TestBase {
    @Test
    public void test01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        bekle(2);
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();


        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement date= (WebElement) js.executeScript("return document.getElementById('checkin_date')");
       // WebElement date = (WebElement) js.executeScript("return document.queryselector('#checkin_date')");
        /*
    Java Script kodlariyla yazilmis webelementleri bizim bildigimiz findElement() methoduyla locate edemeyebiliriz
    js executor kullanarak ister html ister java script ile yazilmis olsun bir webelementin locatini js executor
    ile alabiliriz. Yukaridaki ornekte sayfadaki tarih webelementini js executor ile locate ettik
 */
        date.clear();
        date.sendKeys("7/12/2023");

        //  Yazili metinleri alıp ve yazdırınız
        String idAttributeDegeri=js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttributeDegeri=js.executeScript("return document.getElementById('checkin_date').type").toString();
        String nameAttributeDegeri=js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri=js.executeScript("return document.getElementById('checkin_date').value").toString();
        System.out.println("ID Attribute degeri : "+idAttributeDegeri);
        System.out.println("type Attribute degeri : "+typeAttributeDegeri);
        System.out.println("name Attribute degeri : "+nameAttributeDegeri);
        System.out.println("value Attribute degeri : "+valueAttributeDegeri);
        /*
        Js executor ile attribute değerlerini yazdırabilmek için js ile locate ettiğimiz webelementin sonuna
        yukarıdaki örnekteki gibi hangi attributun değeri yazdırmak istersek sonuna attribute adını yazarız.
        */

    }

    @Test
    public void test02() {
        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://www.priceline.com/");

        //Find Your Hotel butonunun rengini Kirmizi yazınız
        WebElement button= driver.findElement(By.xpath("//*[text()='Find Your Hotel']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.color='red';",button);

    }
}
