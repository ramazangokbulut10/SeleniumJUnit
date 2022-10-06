package day07_assertions;

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

public class C01_Assertions {
    /*
    amazon ana sayfasina gidin
    3 farkli test method'u olusturarak asagidaki gorevleri yapin
        1- Url'in amazon icerdigini test edin
        2- title'in facebook icermedigini test edin
        3- sol ust kosede amazon logosunun gorundugunu test edin
     */

    /*
    NOT: BEFORE/AFTER static olmaz, BEFORECLASS/AFTERCLASS static olur
     */
    static WebDriver driver;

    @BeforeClass   // birden fazla gorev old icin bunu sectik
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(125));

        driver.get("https://www.amazon.com"); // tum classlardan calissin diye buraya koyduk
                                              // test01 e koysaydık tek basina test02 ve test03 den calistiramazdig

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){  // bunlar static olmayacak


        //1- Url'in amazon icerdigini test edin
        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }

    @Test
    public void test02(){
        //2- title'in facebook icermedigini test edin
        String istenmeyenKelime="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public void test03(){
        //3- sol ust kosede amazon logosunun gorundugunu test edin
        WebElement logoElement = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElement.isDisplayed());
    }
}
