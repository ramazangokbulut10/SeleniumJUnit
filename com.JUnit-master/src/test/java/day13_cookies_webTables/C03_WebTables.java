package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void dinamikYazici() {
        // onceki class'daki adrese gidip
        // girisYap method'unu kullanarak sayfaya giris yapin


        girisYap();

        // input olarak verilen satir sayisi ve sutun sayisi'na sahip
        int satir=4;
        int sutun=4;


        // cell'deki text'i yazdirin
        WebElement arananCell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
                                                               // burayi dinamik yapmak icin satir ve dutun yazidk
        System.out.println(arananCell.getText());


    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
