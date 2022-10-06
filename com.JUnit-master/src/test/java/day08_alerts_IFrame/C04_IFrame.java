package day08_alerts_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {

    // https://the-internet.herokuapp.com/iframe adresine gidin.
    // Bir method olusturun: iframeTest
    //      "An IFrame containing..." textinin erisilebilir oldugunu test edin
    //       ve konsola yazdirin
    //      TextBox'a "Merhaba Dunya" yazin
    //      TextBox'in altinda bulunan "Elemental Selenium"
    //      linkinin textinin gorunur oldugunu dogrulayin ve konsolda yazdirin


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
    public void iframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //      "An IFrame containing..." textinin erisilebilir oldugunu test edin
        //       ve konsola yazdirin
        WebElement baslikElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        //**** isEnabled() erisilebilir demek
        System.out.println(baslikElementi.getText());


        //      TextBox'a "Merhaba Dunya" yazin
        // ***TextBox ı dogru olarak locate etmemize ragmen driver bulamadi
        // ***bunun uzerine HTML kodlari inceleyince
        // ***textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        // ***bu durumda once iframe'i locate edip
        // ***switchTo() ile o iFrame'e gecmeliyiz

        WebElement iFrameElement=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElement);
        WebElement textBox=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear(); // sayfanin kendisinde yazi oldugu icin once onu temizledik
        textBox.sendKeys("Merhaba Dunya");
        Thread.sleep(5000);


        //      TextBox'in altinda bulunan "Elemental Selenium"
        //      linkinin textinin gorunur oldugunu dogrulayin ve konsolda yazdirin

        // ***linkYaziElementi dogru locate edilmesine ragmen yazdirmadi
        // ***cunku yukarida iFrame'e gecis yapmistik
        // ***once oradan cikmamiz lazim
        driver.switchTo().defaultContent(); //iFrame'den ciktik'
        WebElement linkYaziElementi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());

        Thread.sleep(5000);
    }

}
