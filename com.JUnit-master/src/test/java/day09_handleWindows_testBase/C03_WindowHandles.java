package day09_handleWindows_testBase;

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
import java.util.Set;

public class C03_WindowHandles {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test01() {

        // 1- "https://the-internet.herokuapp.com/windows" adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        // 2- Sayfadaki testin "Opening a new window" oldugunu dogrulayin
        WebElement sayfaTest=driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        String actualYazi=sayfaTest.getText();
        String expectedYazi="Opening a new window";
        Assert.assertEquals(expectedYazi,actualYazi);

        // 3- Sayfa basliginin(title) "The Internet" oldugunu dogrulayin
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);



        /*
        TODO ***
            Eger kontrolsuz acilan bir tab veya window varsa
            o zaman sayfalarin window handle degerlerini elde etmem gerekir
           Oncelikle 2. sayfa acilmadan once
           ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();



        // 4- Click Here butonuna basin
         driver.findElement(By.xpath("//*[text()='Click Here']")).click();
         /*
         TODO ***
           switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
          */

        /*
        todo *** yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
         bunun icin driver.getWindowHandles() method'unu kullanarak
         acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
         *** İlk sayfanin window handle degerini zaten biliyoruz
         *** Set'deki window handle degerlerini kontrol edip
         *** ilk sayfanin handle degerine esit olmayan
         *** İkinci sayfanin window handle degeridir deriz




         */

        Set<String> windowHandleSeti = driver.getWindowHandles(); // getWindowHandles() tum sayfalarin handle degerlerini getirir
        System.out.println(windowHandleSeti);                    // ve bir set e atar

        String ikinciSayfanWindowHandleDegeri="";
        for (String each:windowHandleSeti
             ) {
           if (!each.equals(ilkSayfaWindowHandleDegeri)){ //1.sayfanin windowHandle degerine esit degilse 2. sayfanindir dedik
             ikinciSayfanWindowHandleDegeri=each;
           }
        }
           // todo artik 2. sayfanin window handle degerini biliyoruz
           // rahatlikla sayfalar arasi gecis yapabiliriz
             driver.switchTo().window(ikinciSayfanWindowHandleDegeri);

        // 5- Acilan yeni pencerenin sayfa basliginin (title) "New Window" oldugunu dogrulayin
        String expectedTitle2="New Window";
        String actualTitle2=driver.getTitle();
        Assert.assertEquals(expectedTitle2,actualTitle2);

        // 6- Sayfadaki textin "New Window" oldugunu dogrulayin.
          WebElement ikinciSayfaYaziElenti=driver.findElement(By.xpath("//h3"));
          String actualText=ikinciSayfaYaziElenti.getText();
          String expectedText="New Window";
          Assert.assertEquals(expectedText,actualText);


        // Bir onceki pencereye geri dondukten donra sayfa basliginin "The Internet" oldugunu dogrulayin.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        expectedTitle="The Internet";  // 3. maddede bunu yaptigimiz icin burada direk cagirdik
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


        /*
        todo *** driver.getWindowHandle()
                                       2 ayri pencere acarsak kullaniyoruz yani iki ayri siteye gittigimizde
        todo *** driver.getWindowHandles()
                                       bir sayfanin icinde bir linke tiklayinca yeni bir pencere aciyorsa kullaniyoruz
         */

    }
}
