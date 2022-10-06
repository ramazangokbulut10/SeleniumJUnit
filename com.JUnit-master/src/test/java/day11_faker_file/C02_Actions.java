package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() {

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin ( bunun icin actions a ihtiyacimiz var bunu 3 asamada olusturuyorduk
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)  // SAYFAYİ ASAGİ İNDİRİYOR
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        //5- videoyu calistirdiginizi test edin
        WebElement youtubeLinki=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeLinki.isDisplayed());
    }
}
