package assignment_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestCase2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Customer Login')]"))).click();

            WebElement customerSelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userSelect")));
            Select selectCustomer = new Select(customerSelectElement);
            selectCustomer.selectByVisibleText("Ron Weasly");

            driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Withdrawl')]"))).click();

            WebElement amountField = driver.findElement(By.xpath("//input[@placeholder='amount']"));
            amountField.sendKeys("5000"); 
            
            driver.findElement(By.xpath("//button[text()='Withdraw']")).click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Transaction Failed. You can not withdraw amount more than the balance.')]")));

            if (errorMessage.isDisplayed()) {
                System.out.println("Error message displayed: " + errorMessage.getText());
            } else {
                System.out.println("Error message not displayed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}
