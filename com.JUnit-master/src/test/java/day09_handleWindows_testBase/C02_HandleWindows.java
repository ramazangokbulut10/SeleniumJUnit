package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {

        // 1- amazon anasayfaya gidelim
        // 2- url'in amazon icerdigini test edelim
        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        // 4- title'in Best Buy icerdigini test edelim
        // 5- ilksayfaya donup sayfada java aratalim
        // 6- arama sonuclarinin Java icerdigini test edelim
        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        // 8- logonun gorundugunu test edelim

        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle(); //todo sayfa gecislerinde kullanacagim icin bastan yaptim

        // 2- url'in amazon icerdigini test edelim
        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
         driver.switchTo().newWindow(WindowType.WINDOW); // todo yeni pencere actik
         driver.get("https://www.bestbuy.com");
         String ikinciSayfaHandleDegeri = driver.getWindowHandle();

        // 4- title'in Best Buy icerdigini test edelim
        String arananTitleKelime="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananTitleKelime));

        // 5- ilksayfaya donup sayfada Java aratalim
        driver.switchTo().window(ilkSayfaHandleDegeri); // todo ilk sayfaya donuyoruz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        String arananJava="Java";
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiElementi=sonucYaziElementi.getText();
        Assert.assertTrue(sonucYazisiElementi.contains(arananJava));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaHandleDegeri);

        // 8- logonun gorundugunu test edelim
        WebElement logoElementi=driver.findElement(By.xpath("//img[@class='logo'][1]"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }
}