package techproed.day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://www.techproeducation.com/ sayfasina gidin

        driver.get("https://www.techproeducation.com");
        Thread.sleep(2000);

        // Title ve Url'ini alın ve yazdırın
        String techproeducationTitle=driver.getTitle();
        System.out.println("TECHPROEDUCATİON TİTTLE :" +techproeducationTitle);
        Thread.sleep(2000);

        String techproeducationUrl=driver.getCurrentUrl();
        System.out.println("TECHPROEDUCATİON URL: "+techproeducationUrl);
        Thread.sleep(2000);

        // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationTitle.contains("Techpro"));
        Thread.sleep(2000);

        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationUrl.contains("techproeducation"));

        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        // Title'ini alın ve yazdırın
        String amazonTitle=driver.getTitle();
        System.out.println("AMAZON TİTTLE : " +amazonTitle);

        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonTitle.contains("more"));

        // techproeducation.com'a geri dönün
        driver.navigate().back();

        // sayfayı yenileyin
        driver.navigate().refresh();

        // amazon.com'a tekrar gelin
        driver.navigate().forward();
    }
}
