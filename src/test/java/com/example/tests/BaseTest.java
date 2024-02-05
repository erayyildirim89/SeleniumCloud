package com.example.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.time.Duration;


public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();//RemoteWebDriver

    public String username = "enteryourusernamehere";
    public String accesskey = "enteryourkeyhere";
    public String gridURL = "@hub.lambdatest.com/wd/hub";

    boolean status = false;
    public final static int TIMEOUT = 5;


    @BeforeMethod
    @Parameters(value={"browser","version","platform"})
    public void setUp(String browser,String version,String platform) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", version);
        capabilities.setCapability("platform", platform);
        capabilities.setCapability("build", "Selenium Grid");
        capabilities.setCapability("name", "Sample Test");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs


        driver.set(new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities));

        System.out.println("Browser Started : " + browser );

        getDriver().get("https://stage.psn.cx/widget-preview?code=PSN-eh35zwa");

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT)); // implicit wait

        getDriver().manage().window().maximize();
    }


    public WebDriver getDriver() {

        return  driver.get();

    }

    @AfterMethod
    public  void closeBrowser() {

        driver.get().quit();

        ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);

        driver.remove();

    }




}
