package calismalarim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_lcw extends TestBase {

    @Test
    public void test01() {
        driver.get("https://lcwaikiki.com");
        driver.findElement(By.xpath("//*[text()='ANLADIM']")).click();

        driver.findElement(By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/giris']")).click();
        WebElement emailButton=driver.findElement(By.xpath("//input[@name='email']"));
        emailButton.sendKeys("tilayh10@gmail.com");
        WebElement sifreButton=driver.findElement(By.xpath("//input[@name='password']"));
        sifreButton.sendKeys("tl1234"+ Keys.ENTER);



    }
}
