package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {

    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement tasinacakDragMe=driver.findElement(By.xpath("//*[text()='Drag me']"));
        WebElement hedefDropHere=driver.findElement(By.xpath("//*[text()='Drop here']"));
        actions.dragAndDrop(tasinacakDragMe,hedefDropHere).perform();

                                    //***dragAndDrop() DOSYAYI HEDEFE TASIR***


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucYzisiElemneti=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedYazi="Dropped!";
        String actualYazi=sonucYzisiElemneti.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
