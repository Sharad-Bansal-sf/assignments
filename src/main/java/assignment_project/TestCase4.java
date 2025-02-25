package assignment_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class TestCase4 {

	    public static void main(String[] args) {
	        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

	        WebDriver driver = new ChromeDriver();

	        try {

	            driver.get("https://automationintesting.online/");


	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


	            WebElement bookThisRoomButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]")));


	            wait.until(ExpectedConditions.elementToBeClickable(bookThisRoomButton));

	            bookThisRoomButton.click();


            WebElement checkInDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_in")));
            checkInDate.clear();
            checkInDate.sendKeys("2025-02-25");

            WebElement checkOutDate = driver.findElement(By.id("check_out"));
            checkOutDate.clear();
            checkOutDate.sendKeys("2025-02-27");


            WebElement FirstnameField = driver.findElement(By.id("Firstname"));
            FirstnameField.clear();
            FirstnameField.sendKeys("katie");


            WebElement LastnameField = driver.findElement(By.id("Lastname"));
            LastnameField.clear();
            LastnameField.sendKeys("Doe");
            
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.clear();
            emailField.sendKeys("katie.doe@example.com");

            WebElement phoneField = driver.findElement(By.id("phone"));
            phoneField.clear();
            phoneField.sendKeys("12324567890");



            WebElement bookButton = driver.findElement(By.id("book"));
            bookButton.click();


            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("booking_success_message")));
            String messageText = successMessage.getText();


            if (messageText.contains("Booking Successful")) {
                System.out.println("Test Passed: Booking was successful!");
            } else {
                System.out.println("Test Failed: Booking was not successful.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}
