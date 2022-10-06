package day08_alerts_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    //  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
    // bir method olusturun : acceptAlert
    //       1. butona tiklayin, uyaridaki OK butonuna tiklayin ve result mesajinin
    //       "You successfully clicked an alert" old test edin
    // bir method olusturun : dismissAlert
    //       2. butona tiklayin, uyaridaki Cancel butonuna tiklaiyn ve result mesajinin
    //        "successfuly" icermedigini test edin
    // bir method olusturun : sendKeysAlert
    //       3. butona tiklayin, uyaridaki metin kutusuna isminizi yazin,
    //       OK butonuna tiklayin ve result mesajinda isminizin goruntulendigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    // bir method olusturun : acceptAlert

    //       1. butona tiklayin, uyaridaki OK butonuna tiklayin ve result mesajinin
    //       "You successfully clicked an alert" old test edin
    @Test
    public void acceptAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String expectedResult = "You successfully clicked an alert";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = sonucYaziElementi.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }
    //       2. butona tiklayin, uyaridaki Cancel butonuna tiklayin ve result mesajinin
    //        "successfuly" icermedigini test edin
    @Test
    public void dismissAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime = "successfuly";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualResult = sonucYaziElementi.getText();
        Assert.assertFalse(actualResult.contains(istenmeyenKelime));
    }
    //       3. butona tiklayin, uyaridaki metin kutusuna isminizi yazin,
    //       OK butonuna tiklayin ve result mesajinda isminizin goruntulendigini dogrulayin
    @Test
    public void sendKeysAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("feyza");
        driver.switchTo().alert().accept();

        String expectedResult = "feyza";
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//*[text()='You entered: feyza']"));
        String actualResult = sonucYazisiElementi.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
