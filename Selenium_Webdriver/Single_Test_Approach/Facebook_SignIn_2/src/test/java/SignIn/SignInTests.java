package SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
            Thread.sleep(20000);}

        public static void main(String args []) throws InterruptedException {
            SignIn.SignInTests test = new SignIn.SignInTests();
            test.setUp(); }

        @AfterClass
        public void tearDown() {
        driver.quit();
    }

}
