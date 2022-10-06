package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

                     // YANLIS EMAIL TESTI
    // https://automationpractice.com/index.php sayfasina gidelim
    // Sign in butonuna basalim
    /* Email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
       "invalid email address" uyarisi ciktigini test edelim
    */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){

      driver.close();

    }

    @Test
    public void test01(){
        // https://automationpractice.com/index.php sayfasina gidelim
        driver.get("https://automationpractice.com/index.php");

        // Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login'][1]")).click();

        /* Email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
       "invalid email address" uyarisi ciktigini test edelim
    */
        WebElement mailKutusu=driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("mehmetgmail.com" + Keys.ENTER);
        WebElement uyariYazisiElementi=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());
    }
}
