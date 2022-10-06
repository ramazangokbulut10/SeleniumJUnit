package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    /*
    FAKER KUTUPHANESİNİ pop.xml E EKLEDIK
    BU KUTUPHANE YAPACAGIMIZ TESTLERDE
    DOLDURMAK ISTEDIGIMIZ ALANLARA RASTGELE ISIM,
    MAIL,PASSWORD VB BILGILER URETIP DOLDURUYOR
     */

    @Test
    public void test01() throws InterruptedException {
        // facebook gorevini fake isimlerle yapalim

        driver.get("https:///facebook.com");

        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // isim kutusunu locate edip
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        // geriye kalan alanlari TAB ile dolasarak

        Actions actions=new Actions(driver);
        Faker faker=new Faker(); // FAKER OBJESİ OLUSTURUYORUZ
        String fakeMail = faker.internet().emailAddress(); // mail atamasini asagida 2 kez istiyor
                                                           // faker olarak 2 defa ayni maili veremez
                                                           // bu sebeple bir konteyner a biz faker mail atadik
                                                           // asagida da direk onlari kullanacagiz
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("07")
                .sendKeys(Keys.TAB)
                .sendKeys("Eyl")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN) //ASAGİ OKLA ERKEK SECİMİ YAPABİLDİK
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        Thread.sleep(3000);

    }
}
