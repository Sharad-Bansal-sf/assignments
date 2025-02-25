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
	        // Set the path to your WebDriver executable (update this path accordingly)
	        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	        // Initialize the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1: Open the hotel booking website
	            driver.get("https://automationintesting.online/");

	            // Step 2: Wait for the "Book This Room" button to be clickable
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased timeout

	            // Ensure visibility first
	            WebElement bookThisRoomButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]")));

	            // Then wait until it's clickable
	            wait.until(ExpectedConditions.elementToBeClickable(bookThisRoomButton));

	            // Step 3: Click the "Book This Room" button
	            bookThisRoomButton.click();

            // Step 4: Select the date range (check-in and check-out dates)
            WebElement checkInDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check_in")));
            checkInDate.clear();
            checkInDate.sendKeys("2025-02-25");  // Select check-in date (example date)

            WebElement checkOutDate = driver.findElement(By.id("check_out"));
            checkOutDate.clear();
            checkOutDate.sendKeys("2025-02-27");  // Select check-out date (example date)

            // Step 5: Fill out all necessary details for booking
            WebElement FirstnameField = driver.findElement(By.id("Firstname"));
            FirstnameField.clear();
            FirstnameField.sendKeys("katie");

            // Step 5: Fill out all necessary details for booking
            WebElement LastnameField = driver.findElement(By.id("Lastname"));
            LastnameField.clear();
            LastnameField.sendKeys("Doe");
            
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.clear();
            emailField.sendKeys("katie.doe@example.com");

            WebElement phoneField = driver.findElement(By.id("phone"));
            phoneField.clear();
            phoneField.sendKeys("12324567890");


            // Step 6: Click the "Book" button
            WebElement bookButton = driver.findElement(By.id("book"));
            bookButton.click();

            // Step 7: Verify the success message
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("booking_success_message")));
            String messageText = successMessage.getText();

            // Verify the success message
            if (messageText.contains("Booking Successful")) {
                System.out.println("Test Passed: Booking was successful!");
            } else {
                System.out.println("Test Failed: Booking was not successful.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the test
            driver.quit();
        }
    }
}
