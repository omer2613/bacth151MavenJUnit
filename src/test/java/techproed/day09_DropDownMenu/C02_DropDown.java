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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*
    DROPDOWN --->Alt basliklarin oldugu acilir menu listesidir.
    dropdown u handle(automate) etmek icin
        1-dropdown menuyu ilk olarak locate ederiz
        2-Select objesi olusturuuz
        3-select objesinin ddm webelementlerinin iceriginine ve seceneklerine erisim saglamak icin
        SELECT sinifina arguman olarak locate ettigimizwebelementleri koyariz
        SYNTAX:
        Select select0 nev Select(ddm webelement)
        4-Select classi sadece <select > tag i ile olusturulmus dropdown menulere uygulanabilir
        5-Select objesi ddm yi handle edebilmek icin 3 method kullanilir
            a-selectByVisibleText()->-> Ddm'deki elemente gorunur metin ile ulasmak icin kullanilir
            b-selectbyIndex()->Index ile ulasmak icin kullanilir(Index 0(sifir))'dan baslar
            c-selectByValue()-> Elementin degeri ile ulasmak icin kullanilir(option tag'larindaki deger(value) ile)
        6-getOptions() -> locate ettigimiz tum secenekleri bize verir.(List e atip loop ile yazdirabiliriz)
        7-getFirstselectedOption()->Ddm deki secili kalan secenegi bize verir.Birden fazla secenek secildiyse bu secilenlerin ilkini verir.
        8-Ddm ye sendKeys() method u ile de ddm memudeki seceneklerden birini kullanarak gonderebiliriz.
     */
        WebDriver driver;
    /*
        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        -3 farklı test methodu oluşturalım
        1.Method:
             a. Yil,ay,gün dropdown menu'leri locate ediniz
             b. Select objesi olustur
             c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
             a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

*/
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
       // 1.Method:
       // a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil= driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay= driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun= driver.findElement(By.xpath("(//select)[4]"));
       // b. Select objesi olustur
        Select select=new Select(yil);
        // c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(5);//index 0 dan baslar 20180i secer

        Select select1=new Select(ay);
        select1.selectByValue("6");//july

        Select select2=new Select(gun);
        select2.selectByVisibleText("15");

    }

    @Test
    public void test02() {
        //2.Method:
        //a. Tüm eyalet isimlerini yazdıralım(Select ile)

        WebElement eyaletler= driver.findElement(By.xpath("(//select)[5]"));
        Select select= new Select(eyaletler);
        //select.getOptions().forEach(w-> System.out.println(w.getText()));//lambda ile
        List<WebElement> eyaletlerList=select.getOptions();//foreach ile
        for (WebElement w:eyaletlerList) {
            System.out.println(w.getText());

        }/*
        //2.yol
        System.out.println("*********************************************************");
        List<WebElement> eyaletlerr= driver.findElements(By.xpath("(//select)[5]"));
        eyaletlerr.forEach(w-> System.out.println(w.getText()));
        System.out.println("********************************");*/
    }

    @Test
    public void test03() {
        //3.Method:
        //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler= driver.findElement(By.xpath("(//select)[5]"));
        Select select =new Select(eyaletler);
        String seciliOlanSecenek=select.getFirstSelectedOption().getText();
            System.out.println(seciliOlanSecenek);
            Assert.assertEquals("Select a State",seciliOlanSecenek);
           // Assert.assertTrue(seciliOlanSecenek.equals("Select "));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
