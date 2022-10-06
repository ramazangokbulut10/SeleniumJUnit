package day06_radioButton_checkBox;

import com.fasterxml.jackson.core.json.PackageVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    /*
    RadioButton'un ozelligi birini isaretleyince digerinin isaretini kaldirir ayni anda 2 sey sectirmez
    Bu class ı calistiramadim hocanin dil ing benim turkce facebook da Create nex account butonunu acamadim
     */

     WebDriver driver;
    // 1. Gerekli yapiyi olusturun ve asagidaki gorevi tamamlayin

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
    public void test01() throws InterruptedException {
        // a. https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        // b. "Create an Account" button'una basin
           driver.findElement(By.xpath("//*[text()='Create new account']")).click();

        // c. "radio buttons" elementlerini locate edin
        WebElement femelaButton = driver.findElement(By.xpath("//input[@id='u_b_4_9J']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@id='u_b_5_Ci']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@id='u_b_6_Wx']"));

        // d. Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if (!maleButton.isSelected()){
            maleButton.click();
        }
        Thread.sleep(3000);
    }

}
