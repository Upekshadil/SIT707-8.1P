package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {
    
    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testLoginSuccess() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/Users/Dila/Downloads/Compressed/chromedriver-win64_2/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        // Full path where login.html is located.
        driver.navigate().to(
                "D:/Deakin SEM2/SIT707/SIT707_8.1P/SIT707_8.1P/8.1P-resources/pages/login.html");
        sleep(5);

        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("dilshan");

        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("dilshan_pass");

        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("11/08/1993"); // Updated date of birth

        // Find Submit button and click on it
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        // Check the title of the page after login
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "success");

        driver.close();
    }

    @Test
    public void testLoginFailure() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/Users/Dila/Downloads/Compressed/chromedriver-win64_2/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        // Full path where login.html is located.
        driver.navigate().to(
                "D:/Deakin SEM2/SIT707/SIT707_8.1P/SIT707_8.1P/8.1P-resources/pages/login.html");
        sleep(5);

        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("invalid_user");

        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("invalid_password");

        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("11/08/1993"); // Updated date of birth

        // Find Submit button and click on it
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        // Check the title of the page after login
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");

        driver.close();
    }

    @Test
    public void testInvalidDateFormat() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/Users/Dila/Downloads/Compressed/chromedriver-win64_2/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        // Full path where login.html is located.
        driver.navigate().to(
                "D:/Deakin SEM2/SIT707/SIT707_8.1P/SIT707_8.1P/8.1P-resources/pages/login.html");
        sleep(5);

        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("dilshan");

        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("dilshan_pass");

        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("06/12/1989"); 

        // Find Submit button and click on it
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        // Check the title of the page after login
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");

        driver.close();
    }
}

