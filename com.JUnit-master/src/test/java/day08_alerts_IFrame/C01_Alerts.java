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

public class C01_Alerts {

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
    public void test01(){
        /*
         herhangi bir web sitesine gidince veya
         bir websitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz

         Eger bir alert inspect(incele) yapilabiliyorsa, o alert otomasyon ile kullanilabilir,
         bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
         tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
         driver.get("https://www.facebook.com"); da cikan alert vb..
         ama bu benim sayfamda cıkmadi hoca yurtdisinda old icin onda cikmis olabilir

         Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir
         js alert'ler locate edilemez
         Selenium'da JS(java script) alert'ler icin ozel bir yontem gelistirilmistir
           */



        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //alert'e OK tusuna basin
        driver. switchTo(). alert(). accept(); // accept() OK basmis oluruz
                                            // switchTo() degistir gecis yap demek
                                            // sendKeys() yazi gondermek istiyorsak gonderiyoruz
                                            // getText()  allert de bir yazi varsa bize getirir
                                            // dismiss()  cansel a basmiz oluruz
        // allert locate edemedigimiz yani inceleme yapamadigimiz elementler


        //result kisminda "You successfully clicked an alert" yazdigini test edin
        String expectedResult="You successfully clicked an alert"; // istenen sonuc
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYaziElementi.getText(); // cikan sonuc
        Assert.assertEquals(expectedResult,actualResultYazisi);
    }
}
