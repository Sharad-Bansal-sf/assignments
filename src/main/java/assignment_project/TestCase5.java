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
        

        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://computer-database.gatling.io/computers?p=0&s=companyName&d=desc");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement filterByName = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchbox")));
            filterByName.click();


            WebElement filterTooltip = driver.findElement(By.id("searchbox"));
            String tooltipMessage = filterTooltip.getAttribute("validationMessage");
            if (tooltipMessage.equals("Please fill in this field.")) {
                System.out.println("Test Passed: Tooltip message is displayed as expected.");
            } else {
                System.out.println("Test Failed: Tooltip message is incorrect.");
            }

            WebElement addComputerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add")));
            addComputerButton.click();


            WebElement computerNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
            computerNameField.sendKeys("Sharad Computer");

            WebElement introducedDateField = driver.findElement(By.id("introduced"));
            introducedDateField.sendKeys("2025-02-25");

            WebElement discontinuedDateField = driver.findElement(By.id("discontinued"));
            discontinuedDateField.sendKeys("2025-03-25");

            WebElement companyDropdown = driver.findElement(By.id("company"));
            companyDropdown.sendKeys("Apple Inc."); 


            WebElement createComputerButton = driver.findElement(By.xpath("//input[@value='Create this computer']"));
            createComputerButton.click();


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

            driver.quit();
        }
    }
}
