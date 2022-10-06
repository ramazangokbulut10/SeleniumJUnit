package calismalarim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_amazon extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");

        WebElement searchBox =driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='A Product of Nutella Hazelnut Spread Twin Pack (26.5 oz., 2 pk.), 1.65 Pound (Pack of 2)']")).click();

}}
