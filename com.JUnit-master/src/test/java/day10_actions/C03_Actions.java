package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {

    @Test
    public void test01(){

        // 1- https://the-internet.herokuapp.com/context_menu sitesine gidelim

        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 2- cizili alan uzerine sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();

        // contextClick() sag click yapar  ****SAG CLICK****

        // 3- Alert'te cikan yazinin "You selected a context menu" oldugunu test edelim
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        // 4- Tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();

        // 6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHDegeri = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click(); // BURADA YENİ SAYFAYA GİDECEGİ İCİN YUKARİDA ESKİ SAYFANIN HANDLE DEGERİNİ ALMALİYİM

        Set<String> handleSeti=driver.getWindowHandles(); // 2. sayfanında handle degerini bulalim
        String ikinciSayfaWHDegeri="";
        System.out.println(handleSeti);
        for (String each: handleSeti
             ) {
            if (!each.equals(ikinciSayfaWHDegeri)){
                ikinciSayfaWHDegeri=each;
            }
        }
        // 7- Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWHDegeri); // burada 2.sayfanin handle degerini kullandik ve driver'imiz 2. sayfaya gecmis oldu
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String expectedYazi1 ="Elemental Selenium";
        String actualYazi1=yaziElementi.getText();
        Assert.assertEquals(expectedYazi1,actualYazi1);


    }
}
