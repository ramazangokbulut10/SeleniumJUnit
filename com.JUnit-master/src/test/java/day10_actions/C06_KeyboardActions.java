package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    // facebook anasayfaya gidip
    // yeni kayit olustur butonuna basin
    // isim kutusunu locate edip,
    // geriye kalan alanlari TAB ile dolasarak
    // formu doldurun




    @Test
    public void test01() throws InterruptedException {

        driver.get("https:///facebook.com");
        // yeni kayit olustur butonuna basin
       driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        Thread.sleep(2000);
        // isim kutusunu locate edip
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak
        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Tahaa")
                .sendKeys(Keys.TAB)
                .sendKeys("Ustaoglu")
                .sendKeys(Keys.TAB)
                .sendKeys("taha1@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("taha1@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("07")
                .sendKeys(Keys.TAB)
                .sendKeys("Eyl")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();



        Thread.sleep(3000);

    }
}
