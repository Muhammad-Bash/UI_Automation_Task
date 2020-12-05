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
        Thread.sleep(20000);}

    public static void main(String args []) throws InterruptedException {
        SignIn.SignInTests test = new SignIn.SignInTests();
        test.setUp(); }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}




