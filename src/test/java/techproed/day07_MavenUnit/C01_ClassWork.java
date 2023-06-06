package techproed.day07_MavenUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.naming.ldap.LdapReferralException;
import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2.Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3.Login alanine "username" yazdirin
        //4.Password alanine "password" yazdirin
        //5.Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("input#user_login"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();

        //6.Online banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        //--->(//*[text()=.])[11] Bu sekilde text ile aldigimiz bir xpath degissse bile o webelement i handle edebiliriz.
        driver.findElement(By.xpath("(//h4)[4]//span")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina "2020-09-10" yazdirin
        //9.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(2000);
        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement sonucYazisi= driver.findElement(By.xpath("(//span)[1]"));
        if (sonucYazisi.getText().equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        if (sonucYazisi.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.close();

    }
}
