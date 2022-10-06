package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {

    // 1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()

    @Test
    public void isEnabledTest1() {


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement enableBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableBox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // OBJE OLUSTURDUK
        wait.until(ExpectedConditions.elementToBeClickable(enableBox));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement istEnabledYaziElementi=driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assert.assertTrue(istEnabledYaziElementi.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(enableBox.isEnabled());
    }
}
