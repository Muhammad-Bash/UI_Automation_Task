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
            driver.get("https://www.facebook.com/login");
            Thread.sleep(5000);
            driver.manage().window().maximize();
            System.out.println(driver.getTitle());

            //Make page wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Locate the email field and inspect
            driver.findElement(By.id("email")).sendKeys("talk2talkaholics@gmail.com");

            //locate and inspect the password field

            driver.findElement(By.id("pass")).sendKeys("Bolanle_99");

            //locate and inspect the SignIn button
            driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
            Thread.sleep(20000);
        }


    @Test(priority = 0)
    public void testSuccessfulLogin(){
        if (driver.getCurrentUrl ().contains ("https://www.facebook.com/login"))
            //Pass
            System.out.println ("The Page URL contains /app/feed");
        else
            //Fail
            System.out.println ("The Page URL does not contain /app/feed");
    }
    @Test(priority = 1)
    public void testLogout() throws InterruptedException {
        //click on the profile button
        driver.findElement (By.xpath ("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[1]/span/div/div[1]")).click();
        Thread.sleep (2000);
        //click on the logout button
        driver.findElement (By.xpath ("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click ();
        //printout response based on status
        if(driver.getCurrentUrl ().contains ("https://www.facebook.com/login"))
            //Pass
            System.out.println ("The Login page URL contains /login");
        else
            //Fail
            System.out.println ("The Login URL does not contain /login");
    }
    @Test(priority = 1)
    public void testNegativeLogin(){
        driver.findElement (By.id ("username")).sendKeys ("biz@33445");
        driver.findElement (By.id ("password")).sendKeys ("admin123.");
        driver.findElement (By.xpath ("//*[@id=\"u_0_f\"]")).click ();
        String expectedErrorMessage = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
        String actualErrorMessage = driver.findElement(By.xpath ("//*[@id=\"email_container\"]/div[2]")).getText();
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
