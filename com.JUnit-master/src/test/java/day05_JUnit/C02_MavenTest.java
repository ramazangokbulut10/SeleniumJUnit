package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin butonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // 3. Login alanina "username" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        // 4. Password alanina "password" yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // 5. Sign in butonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back(); // test sayfasinda sorun oldugu icin yapti bunu hoca

        // 6. online Banking menusunden Pay Bils sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'][1])")).click();
                                                 // yazi oldugu icin ve birden fazla old icin indexli bulduk
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("500");

        // 8. tarih l-kismina "2020-09-10" yazdirin

        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        // 9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        // 10. "The payment was successfully submittes." mesajinin ciktigini kontrol edin

        WebElement driverMesaj=driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (driverMesaj.isDisplayed()){
            System.out.println("eslesme PASSED");
        }else
            System.out.println("eslesme FAILED");

        driver.close();


        /*
        NOT :: MAVEN projesini tercih etmemizin sebebi pom.xml sayesinde kutuphanelerimiz rahatlikla
        ekleyebilir, silebilir, update edebiliriz
         */
    }
}
