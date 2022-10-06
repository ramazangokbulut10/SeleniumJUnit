package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    // https://the-internet.herokuapp.com/dropdown adresine gidin
    // 1. Index kullanarak Secenek 1'i (Option 1) secin ve yazdirin
    // 2. Value kullanarak Secenek 2'yi (Option 2) secin ve yazdirin
    // 3. Visible Text(Gorunen metin) kullanarak Secenek'i (Option) secin ve yazdirin
    // 4. Tum dropdown options'i yazdirin
    // 5. Dropdown'un boyutunu bulun, Dropdown'da 4 oge varsa konsolda True, degilse False yazdirin.

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

        //driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement optionBoxs=driver.findElement(By.xpath("//select[@id='dropdown'][1]"));
        Select select=new Select(optionBoxs);

        //1. Index kullanarak Secenek 1'i (Option 1) secin ve yazdirin
        select.selectByIndex(1); //sectik
        System.out.println(select.getFirstSelectedOption().getText()); // bir onceki adimda sectigimizi yazdiriyoruz


        // 2. Value kullanarak Secenek 2'yi (Option 2) secin ve yazdirin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // 3. Visible Text(Gorunen metin) kullanarak Secenek'i (Option) secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // 4. Tum dropdown options'i yazdirin
         List<WebElement> tumOpsiyon =select.getOptions();
        for (WebElement each:tumOpsiyon
             ) {
            System.out.println(each.getText());
        }

        // 5. Dropdown'un boyutunu bulun, Dropdown'da 4 oge varsa konsolda True, degilse False yazdirin.

           int dropdownBoyut=tumOpsiyon.size();
           if (dropdownBoyut==4){
               System.out.println("True");
           }else
               System.out.println("False");

    }
}
