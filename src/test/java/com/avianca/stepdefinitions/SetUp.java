package com.avianca.stepdefinitions;

import com.avianca.hooks.DriverChrome;
import com.avianca.utilities.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;



public class SetUp {
    public static WebDriver driver;

    @Before
    public void openBrowser() throws Exception {
        PropertiesReader propertiesReader= new PropertiesReader();
        switch (propertiesReader.getValue("browser")){
            case "chrome":
                driver= new DriverChrome(propertiesReader).initDriver(propertiesReader.getValue("url"));
                break;
            case "firefox":
                break;
        }
    }
    @After
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png","Scenario failed");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        driver.quit();
    }



}
