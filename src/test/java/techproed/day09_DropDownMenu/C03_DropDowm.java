package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v111.css.model.Value;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_DropDowm {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
}

    @Test
    public void test01() {
        //programing language ddm den istediginiz 4 secenegi aliniz

        WebElement languages= driver.findElement(By.xpath("(//select)[6]"));
        Select select=new Select(languages);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //eger sadece secili olan option lari yazdirmak istersek
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));//Lambda ile
bekle(3);
        System.out.println("*****************************************");
        //for ile
        for (WebElement e: select.getAllSelectedOptions()) {
            System.out.println(e.getText());

        }
        //Seceneklerden 4 tane sectigimizi dogrulayalim
        Assert.assertEquals(4,select.getAllSelectedOptions().size());
        //Sectigimiz seceneklerden ilkini yazdiralim,ilk secenegin java oldugunu dogrulayalim
        System.out.println("************************************************");
        System.out.println("Secilen seceneklereden ilki : "+select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());
        //Sectigimiz seceneklerin hepsini kaldiralim.

        select.deselectAll();
        bekle(2);
        //sendKeys() methodu ile istedigimiz bir secenegi gonderelim
       //languages.sendKeys("C#");
       //visibleText olarak secim yapacagimiz bir method olusturup programing language ddm den bir secenek secelim
        selectVisibleText(languages,"Java");

        //Index olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectIndex(languages,2);
        bekle(2);

        //Value olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectValue(languages,"js");
        bekle(2);
    }



    @After
    public void tearDown() throws Exception {

    }

    public void  selectVisibleText(WebElement ddm, String text){
        Select select= new Select(ddm);
        select.selectByVisibleText(text);
    }
    public void  selectIndex(WebElement ddm,int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void  selectValue(WebElement ddm,String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
    public  void bekle(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
