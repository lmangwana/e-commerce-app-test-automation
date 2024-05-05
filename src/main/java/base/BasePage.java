package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * BasePage is a base class that provides common functionality for all Page Object Model (POM) classes.
 * It initialises the WebDriver instance and provides methods to get the WebDriver instance and the URL for the application.
 * 
 * The WebDriver instance used by this class is determined by the config.properties file.
 * The URL for the application is also obtained from the config.properties file.
 * 
 * This class contains methods to get the WebDriver instance and the URL.
 * The WebDriver instance and the URL are used by the Test class that extends this class.
 * 
 * In addition to the above, this class also provides several utility methods:
 * - `getRandomString()`: Generates a random string of alphabetic characters.
 * - `getRandomBirthdate()`: Generates a random birthdate between 1900 and 2022.
 * - `getRandomPhoneNumber()`: Generates a random phone number.
 * - `getRandomAlphaNumeric()`: Generates a random alphanumeric string.
 * - `windowSetUp()`: Sets up the window for the WebDriver instance.
 * - `takeSnapShot()`: Takes a screenshot of the current state of the web application.
 * 
 * These utility methods can be used to generate random test data and perform common setup tasks.
 *
 * @author LuthoMangwana
 *
 */

public class BasePage 
{
	public static WebDriver driver;
    private Properties prop;
    private FileInputStream data;
    private String url;

    /**
     * Constructor for BasePage.
     * Initialises the Properties instance and loads the config.properties file.
     * @throws IOException if an I/O error occurs when loading the config.properties file.
     */
    public BasePage() throws IOException {
        prop = new Properties();     
        data = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\resources\\config.properties");   
        prop.load(data); // Load properties file once here
    }	
	
   
    
    /**
     * This method initialises and returns a WebDriver instance based on the browser type specified in the config.properties file.
     * The WebDriver instance is maximised and implicitly waits for a specified duration before throwing a NoSuchElementException.
     *
     * @throws IOException if an I/O error occurs when getting the 'browser' property.
     * @return the initialised WebDriver instance.
     */
	public WebDriver getDriver() throws IOException
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		
		else if(browser.equals("safari"))
		{
			driver = new SafariDriver();
			
		}
		
		else
		{
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		return driver;
		
	}
	
	/**
	 * This method generates a random string of alphabetic characters.
	 * The length of the generated string is 5 characters.
	 * This can be useful for generating unique identifiers or random test data.
	 *
	 * @return a random string of 5 alphabetic characters.
	 */
	
	public String getRandomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	/**
	 * This method generates a random birthdate between January 1, 1900 and December 31, 2022.
	 * The birthdate is returned as a string in the format "MM/dd/yyyy".
	 * This can be useful for generating random test data for fields that require a date.
	 *
	 * @return a random birthdate as a string in the format "MM/dd/yyyy".
	 */
	public String getRandomBirthdate() {
        long minDay = LocalDate.of(1900, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2022, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        LocalDate randomBirthdate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return randomBirthdate.format(formatter);
    }
	
	/**
	 * This method generates a random phone number.
	 * The phone number consists of a leading zero followed by 9 random numeric characters.
	 * This can be useful for generating random test data for fields that require a phone number.
	 *
	 * @return a random phone number as a string.
	 */
	
	public String getRandomPhoneNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(9);
		return "0"+generatedString;
	}
	
	/**
	 * This method generates a random alphanumeric string.
	 * The string consists of 3 random alphabetic characters, followed by an '@' symbol, followed by 3 random numeric characters.
	 * This can be useful for generating random test data for fields that require an alphanumeric string such as password field.
	 *
	 * @return a random alphanumeric string.
	 */
	
	public String getRandomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	
	/**
	 * This method sets up the window for the WebDriver instance.
	 * It maximises the window and sets an implicit wait of 10 seconds.
	 * This is typically called after the WebDriver instance has been initialised.
	 */
	public void windowSetUp()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
     * Returns the URL for the application.
     * The URL is determined by the 'url' property in the config.properties file.
     * @throws IOException if an I/O error occurs when getting the 'url' property.
     * @return the URL for the application.
     */
	
	public String getUrl() throws IOException
	{
		url = prop.getProperty("url");
		return url;
	}
	
	/**
	 * This method takes a screenshot of the current state of the web application.
	 * The screenshot is saved as a .png file in the target/screenshots directory.
	 * The filename of the screenshot is a timestamp, which ensures that each screenshot has a unique filename.
	 *
	 * @throws IOException if an I/O error occurs when writing the screenshot to a file.
	 */
	public void takeSnapShot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") +"\\target\\screenshots\\"
				+ timestamp() + ".png");

		FileUtils.copyFile(srcFile, destFile);
	}

	/**
	 * This method returns a timestamp as a String. 
	 * The timestamp is in the format "yyyy-MM-dd HH-mm-ss", which is a common format for timestamps.
	 * This timestamp can be used to uniquely identify events, such as the taking of a screenshot.
	 *
	 * @return a timestamp as a String.
	 */
	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}