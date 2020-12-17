package SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTests {

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://monosnap.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        //Make page wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Accept cookies
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[3]/div[2]")).click();

        //Click on SignIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/div/div[2]/div[3]/span")).click();


        //Locate the email field and fill it
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[1]")).sendKeys("talk2talkaholics@gmail.com");

        //locate and inspect the password field
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[2]")).sendKeys("bolatito99");

        //locate and inspect the SignIn button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/button")).click();
        Thread.sleep(20000);


    }

    @Test(priority = 0)
    public void testSuccessfulLogin() {
        if (driver.getCurrentUrl().contains("https://monosnap.com/"))
            //Pass
            System.out.println("The Page URL contains /app/feed");
        else
            //Fail
            System.out.println("The Page URL does not contain /app/feed");
    }

    @Test(priority = 1)
    public void testLogout() throws InterruptedException {
        //click on the profile button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button")).click();
        Thread.sleep(2000);
        //click on the logout button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/div/div/a[3]/p")).click();
        //printout response based on status
        if (driver.getCurrentUrl().contains("https://monosnap.com/"))
            //Pass
            System.out.println("The Login page URL contains /login");
        else
            //Fail
            System.out.println("The Login URL does not contain /login");
    }

    @Test(priority = 1)
    public void testNegativeLogin() {
        driver.findElement(By.id("username")).sendKeys("invalidUsername");
        driver.findElement(By.id("password")).sendKeys("admin123.");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        String expectedErrorMessage = "Login Failed: Invalid username or password";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/div[4]/div/div/p")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    public static void main(String args []) throws InterruptedException {
        SignIn.SignInTests test = new SignIn.SignInTests();
        test.setUp();
    }

    @AfterClass
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(10000);
        driver.quit(); }


}
