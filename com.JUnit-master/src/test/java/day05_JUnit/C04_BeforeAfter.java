package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {

    WebDriver driver; // Tum class'in icinde kullanilabilsin diye buraya yerlestirdik burada olusturup asagida atama yaptik

    @Before    // bunuda setUp() methodu tüm methodlardan once calissin diye yazdik
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();   // atamayi burada yaptik
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After   // bunuda tearDown() methodu tüm methodlardan sonra calissin diye yazdik
    public void tearDown(){

        driver.close();
    }

    /*
    NOT : Before ve After tek basina calismaz
          ve burada yukaridan asagi calisma sirasi yoktur

          Burada BEFORE/AFTER ile sanki tum methodlarin basinda before sonunda after varmis gibi olur
     */

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
