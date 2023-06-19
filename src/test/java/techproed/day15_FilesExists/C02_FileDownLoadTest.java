package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownLoadTest extends TestBase {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download ");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//*[text()=.])[6]")).click();
        bekle(3);
        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:\\Users\\altip\\OneDrive\\Masaüstü\\b10 all test cases, code (9).docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}




