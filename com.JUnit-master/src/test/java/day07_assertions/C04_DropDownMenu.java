package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {

    //DROPDOWN DEYİNCE AKLİNA SELECT GELSİN

    /*
    amazon'a gidip
    dropdown'dan books secenegini secip
    Java aratalim
    ve arama sonuclarinin Java icerdigini test edelim
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

        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        // dropdown'da bir option secmek icin 3 adim vardir
        // 1- dropdown'i locate edelim

        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- bir Select objesi olusturup
        // parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim

        Select select=new Select(dropDownMenu);

        // 3- Dromdown'da var olan option'lardan istedigimiz bir taneyi secelim

         select.selectByVisibleText("Books");
         // select.deselectByIndex(5);  bu sekillerde de secebiliriz
         // select.deselectByValue("search-alias=stripbooks-intl-ship");

        // arama kutusuna Java yazdiralim

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edelim

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String arananKelime="Java";
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

        Thread.sleep(5000);
    }
}
