package assignment_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Testcase1 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement customerLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Customer Login']")));
            customerLoginButton.click();

            WebElement customerDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userSelect")));
            
            Select selectCustomer = new Select(customerDropDown);
            selectCustomer.selectByVisibleText("Ron Weasly");

            WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
            loginButton.click();
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            WebElement depositButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-class='btnClass2']")));
            depositButton.click();
            System.out.println ('driver')
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement amountInputField = driver.findElement(By.xpath("//input[@placeholder='amount']"));
            amountInputField.sendKeys("1000");
            WebElement depositSubmitButton = driver.findElement(By.xpath("//button[text()='deposit']"));
            depositSubmitButton.click();

            WebElement transactionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Transactions']")));
            transactionButton.click();

            WebElement fromDateInput = driver.findElement(By.id("start"));
            WebElement toDateInput = driver.findElement(By.id("end"));
            fromDateInput.sendKeys("2025-02-01"); 
            toDateInput.sendKeys("2025-02-25");  

            WebElement transactionDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-bordered table-striped']")));

            boolean creditEntryFound = transactionDetails.getText().contains("1000");
            if (creditEntryFound) {
                System.out.println("Credit entry displayed successfully.");
            } else {
                System.out.println("Credit entry not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}
