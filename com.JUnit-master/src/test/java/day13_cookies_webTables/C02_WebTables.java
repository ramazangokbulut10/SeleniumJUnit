package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void test1() {

       /*
       tr ==> satir
       td ==> sutun
        */


        // login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //○ Username : manager
        //○ Password : Manager1!
        girisYap();


        //● table( ) metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        List<WebElement> sutunListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));//SUTUN
        System.out.println("Sutun sayisi:" + sutunListesi.size());

        System.out.println("**********************************************");
        /*
        TUM BODY'İ BİR STRING OLARAK YAZDIRMAK ISTERSENIZ
        Body webElementini locate edip, getText() method'u ile yazdirabilirsiniz
         */


        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        System.out.println("**********************************************");
        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr")); //SATIR
        System.out.println("Satirlar sayisi" + satirlarListesi.size());
        System.out.println("**********************************************");
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : satirlarListesi
        ) {
            System.out.println(each.getText());
        }
        System.out.println("**********************************************");
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]//td")); // ELEMENTLER
        for (WebElement each : satirlarListesi
        ) {
            System.out.println(each.getText());
        }
        System.out.println("**********************************************");


        // Email basligindaki tum elementleri(sutun) konsolda yazdirin
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        // bub list bize basliklarin listesini veriyor
        int emailSutunNo = 0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")) { // email basligini bulup
                emailSutunNo = i; // sutun numarasini kaydettim
            }
        }
        List<WebElement> EmailSutunListesi =
                driver.findElements(By.xpath("//tbody//td[" + (emailSutunNo + 1) + "]"));
        // yukarda index num 0 dan basliyor ama
        // bizde 1 den baslamasi gerekiyor bu sebeple 1 artiriyoruz

    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
