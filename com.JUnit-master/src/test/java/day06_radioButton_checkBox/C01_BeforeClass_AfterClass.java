package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {

    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir

    bu classlar 1 kere calisir her method icin ayri ayri calismiyor
    amazona tecproya ve facebook a gittikten sonra kapatir
    her biri icin ayri ayri ac kapa yapmaz
    ama sadece @Before @After dersek hepsi icin ayri ayri calisir
     */

    static WebDriver driver; // bunuda static yapmak zorundayiz cunku methodlari static yaptigimiz icin
                             // icinde bu sekilde kullanabiliriz

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();   // atamayi burada yaptik
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }



    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test03(){
        driver.get("https://www.facebook.com");
    }

}
