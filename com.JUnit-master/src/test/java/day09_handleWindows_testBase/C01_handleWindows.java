package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

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
        driver.quit();
    }
    @Test
    public void test01(){
        // 1- Amazon ana sayfasina gidin

        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle(); // ilk sayfanın handle degerini yazdik
                                                              // tekrar donmek istersek kullanalim diye

        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        /*
        CDwindow-B8A5643C835C94B0A5CBF3C1B8BF50F3
        bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir

        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-B8A5643C835C94B0A5CBF3C1B8BF50F3");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglariz

         */

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi=driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]"));
        driver.switchTo().newWindow(WindowType.TAB); // YENİ TABI ACİYORUZ AMA HENUZ NUTELLA BURDA CİKMAZ
        /*
        bu komutu kullandigimizda driver otomatik olrak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]")).click();

        // 4- yeni tab'da acilan urunun basligini yazdirin yazdirin

        WebElement urunTitleElementi=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText()); // yazdirdik
        System.out.println(driver.getCurrentUrl()); // ikinci sayfanin URL'ini yazdirdik

        // ilk sayfaya gecip URL'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri); // ilk sayfaya geciyoruz
        System.out.println(driver.getCurrentUrl()); // URL'i yazdiriyoruz

    }
}
