package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");
        //arama kutusunu locate edelim
        WebElement aramakutusu= driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        //“Samsung headphones” ile arama yapalim
        aramakutusu.sendKeys("Samsung headphones", Keys.ENTER);
        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        //1-16 of results for"samsung headphones
        String[]sonucsayisi=sonucYazisi.getText().split("");
        System.out.println("sonucsayisi = "+sonucsayisi[2]) ;
        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//h2//a)[1]")).click();
        //Sayfadaki tum basliklari yazdiralim

        List<WebElement> sayfabasliklari= driver.findElements(By.xpath("//h1 | //h2 "));//(//*[@class='nav-a ']) [1] | (//*[@class='nav-a ']) [2]
        sayfabasliklari.forEach(t-> System.out.println(t.getText()));

        driver.close();
    }
}
