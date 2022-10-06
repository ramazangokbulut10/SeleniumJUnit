package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test01() {

        // Tests packagenin altina bir class oluşturun : C05_UploadFile
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // chooseFile butonuna basalim
        // Yuklemek istediginiz dosyayi secelim.
            /*
            bu islemi selenium ile yapma imkanimiz yok cunku web tababnli bir uygulama degil
            bu durumda senKeys() imdadimiza yetisir
            eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
            secme islemi otomatik olarak yapilmis olacaktir.
             */


         // 1.ADIM chooseFile butonunu locate edelim

        WebElement dosyaSecButtonu=driver.findElement(By.id("file-upload"));

        // 2.ADIM yuklunecek dosyanin dosya yolunu olusturalim
        // biz masa ustumuzdeki text.txt dosyasini yukleyelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\text.txt";
        String yuklenecekDosya = farkliKisim+ortakKisim;

        // 3.ADIM sendKeys ile dosya yolunu secme butonuna yollayalim

        dosyaSecButtonu.sendKeys(yuklenecekDosya);

        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        // “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());


    }
}
