package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
//Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//And user moves the target element(Drag me to my target) in to  destination(Drop here
        /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe gecis yapmaliyiz
         */
        driver.switchTo().frame(0);
        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        /*
        eger bir hareketli webelementi baska bir webelementin uzereine birakmak istersek
        suruklemek istedigimiz webelementin locaini alip uzerine biracagimiz webelementin
         locatini de alarakdragAnddrop(kaynak,hedef) methodu ile islemi gerceklestirebiliriz
         */
    }
    @Test
    public void test02() {

            //https://jqueryui.com/droppable/ adresine gidelim
            driver.get("https://jqueryui.com/droppable/");
            //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
         */
            driver.switchTo().frame(0);
            WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
            WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
            Actions actions = new Actions(driver);
            actions.clickAndHold(drag).//-->Bu method ile webelemente mouse ile basılı tuttuk
                    moveToElement(drop).//-->Bu method ile basılı tuttuğumuz we'ti diğer we'tin üzerine götürdük
                    release().//-->Bu method ile basılı tuttuğumuz we'ti serbest bıraktık
                    perform();//--> işlemi sonlandırdık

    }

    @Test
    public void test03() {

            //https://jqueryui.com/droppable/ adresine gidelim
            driver.get("https://jqueryui.com/droppable/");
            //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
         */
            driver.switchTo().frame(0);
            WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
            WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
            Actions actions = new Actions(driver);
            actions.clickAndHold(drag).
                    moveByOffset(144,35).//-->Belirtmiş olduğumuz kordinatlara we'ti taşır
                    release().
                    perform();







    }
}


