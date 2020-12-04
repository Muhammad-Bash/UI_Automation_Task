package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");

        Thread.sleep(5000);

        driver.manage().window().maximize();

        System.out.println();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("username")).sendKeys("Muhammad_44");

        driver.findElement(By.id("password")).sendKeys("Ishola92#");

        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();}

        public static void main(String[] args) throws InterruptedException{
        LoginTests test = new LoginTests();
        test.setUp();}

        @AfterClass
            public void tearDown() {
            driver.quit();
        }
}
