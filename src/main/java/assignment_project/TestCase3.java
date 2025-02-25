package assignment_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase3 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement bankManagerLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Bank Manager Login']")));
            bankManagerLoginButton.click();

            WebElement openAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Open Account')]")));
            openAccountButton.click();

            WebElement customerDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userSelect")));
            
            Select customerSelect = new Select(customerDropdown);

            boolean customerFound = false;
            for (WebElement option : customerSelect.getOptions()) {
                if (option.getText().equals("Harry Potter")) {
                    customerFound = true;
                    break;
                }
            }

            if (customerFound) {
                customerSelect.selectByVisibleText("Harry Potter");
            } else {
                System.out.println("Harry Potter not found in the dropdown");
                return;
            }

            WebElement currencyDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency")));
            currencyDropDown.click();
            WebElement selectCurrency = driver.findElement(By.xpath("//option[text()='Rupee']"));
            selectCurrency.click();

            WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
            processButton.click();

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertMessage = alert.getText();

            System.out.println("Alert Message: " + alertMessage);


            alert.accept();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}
