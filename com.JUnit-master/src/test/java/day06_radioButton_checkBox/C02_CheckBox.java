package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {

    WebDriver driver;
    // 1. Gerekli yapiyi olusturun ve asagidaki gorevi tamamlayin(Before yapi, After yapi ve testi olusturmak demek)
    @Before
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();   // atamayi burada yaptik
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }


    // a. Verilen web sayfasina gidin  https://the-internet.herokuapp.com/checkboxes
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        // b. Checkbox1 ve Checkbox2 elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));


        // c. Checkbox1 secili degilse onay kutusunu tiklayin
        Thread.sleep(3000);
        if (!checkBox1.isSelected()){            // isSelected() secili demek
            checkBox1.click();
        }

        // d. Checkbox2 secili degilse onay kutusunu tiklayin
        Thread.sleep(3000);
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }



}
