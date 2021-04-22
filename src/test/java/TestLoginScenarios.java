import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestLoginScenarios {

    private WebDriver driver;
    private String username = "damcevskiane7@gmail.com";
    private String password = "Test123!";

    @BeforeTest
    public void setup(){
        this.driver = getDriver();
    }

    @Test
    public void testEmptyLoginInfo() throws InterruptedException {
        driver.get("http://www.testyou.in/");
        Thread.sleep(5000);

        driver.findElement(By.id("ctl00_headerTop_Signin")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("ctl00_indexLogin2_lnkbtnSiginIn")).click();
        Thread.sleep(4000);

        assertEquals(driver.findElement(By.id("ctl00_CPHContainer_lblOutput")).getText(),
                "Userid or Password Not Match");
    }

    @Test
    public void testInvalidCredentials() throws InterruptedException {
        driver.get("http://www.testyou.in/");
        Thread.sleep(5000);

        driver.findElement(By.id("ctl00_headerTop_Signin")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("ctl00_indexLogin2_txtUserLogin")).sendKeys(username);
        Thread.sleep(2000);

        driver.findElement(By.id("ctl00_indexLogin2_txtPassword")).sendKeys("wrong pw");
        Thread.sleep(3000);

        driver.findElement(By.id("ctl00_indexLogin2_lnkbtnSiginIn")).click();
        Thread.sleep(4000);

        assertEquals(driver.findElement(By.id("ctl00_CPHContainer_lblOutput")).getText(),
                "Userid or Password Not Match");
    }

    @Test
    public void successLogin() throws InterruptedException {
        driver.get("http://www.testyou.in/");
        Thread.sleep(5000);

        driver.findElement(By.id("ctl00_headerTop_Signin")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("ctl00_indexLogin2_txtUserLogin")).sendKeys(username);
        Thread.sleep(2000);

        driver.findElement(By.id("ctl00_indexLogin2_txtPassword")).sendKeys(password);
        Thread.sleep(3000);

        driver.findElement(By.id("ctl00_indexLogin2_lnkbtnSiginIn")).click();
        Thread.sleep(4000);

        assertEquals(driver.findElement(By.id("ctl00_CPHContainer_spUserLogin")).getText(),
                "59595");
    }

    private WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver",
                "E:\\папка\\финки\\6 семестар\\softverski kvaliteti i testiranje\\SeleniumTestBooking\\src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }

}
