package assignment_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestCase5 {

    public static void main(String[] args) {
        
        // Set the path to the WebDriver
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Go to the website
            driver.get("https://computer-database.gatling.io/computers?p=0&s=companyName&d=desc");
            driver.manage().window().maximize();  // Maximize the browser window

            // Step 2: Click on 'Filter by name' field (empty search field)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement filterByName = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchbox")));
            filterByName.click();

            // Step 3: Verify tooltip message 'Please fill out this field.'
            WebElement filterTooltip = driver.findElement(By.id("searchbox"));
            String tooltipMessage = filterTooltip.getAttribute("validationMessage");
            if (tooltipMessage.equals("Please fill in this field.")) {
                System.out.println("Test Passed: Tooltip message is displayed as expected.");
            } else {
                System.out.println("Test Failed: Tooltip message is incorrect.");
            }

            // Step 4: Click on 'Add a computer' button
            WebElement addComputerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add")));
            addComputerButton.click();

            // Step 5: Add all details for the new computer
            WebElement computerNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
            computerNameField.sendKeys("Sharad Computer");

            WebElement introducedDateField = driver.findElement(By.id("introduced"));
            introducedDateField.sendKeys("2025-02-25");

            WebElement discontinuedDateField = driver.findElement(By.id("discontinued"));
            discontinuedDateField.sendKeys("2025-03-25");

            WebElement companyDropdown = driver.findElement(By.id("company"));
            companyDropdown.sendKeys("Apple Inc.");  // Choose a company from the list

            // Step 6: Click on 'Create this computer' button
            WebElement createComputerButton = driver.findElement(By.xpath("//input[@value='Create this computer']"));
            createComputerButton.click();

            // Step 7: Verify newly created computer is displayed in listing page
            WebElement newlyCreatedComputer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//table[@class='computers zebra-striped']/tbody/tr[1]/td[1]/a")));
                    
            if (newlyCreatedComputer != null) {
                System.out.println("Test Passed: Newly created computer is displayed in the listing page.");
            } else {
                System.out.println("Test Failed: Newly created computer is not displayed.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the test is done
            driver.quit();
        }
    }
}
