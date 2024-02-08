package com.example.tests;

import com.example.base.CapabilityFactory;
import org.openqa.selenium.JavascriptExecutor;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.time.Duration;

//BASE TEST WILL BE INHERITED FROM OTHER TEST CLASSES
public class BaseTest {

    protected RemoteWebDriver driver;
    public CapabilityFactory capabilityFactory = new CapabilityFactory();
    boolean status = false;
    public final static int TIMEOUT = 3;

    //SETUP FUNCTION OF TESTS WITH PARAMETERS COMING FROM TESTNG.XML FILE
    @BeforeMethod
    @Parameters(value={"browser","version","platform"})
    public void setup(String browser,String version,String platform) throws MalformedURLException{

        System.out.println("Browser: " +browser+ " started");

        //DEFINE REMOTE WEB DRIVER FOR LAMBDA TEST
        driver = new RemoteWebDriver(new URL("http://dummyselenium:JWjnYt82ldlZGdLMhrsRKIAtzjv7kYYBqYAuWfJ1jrxeDFSDPy@hub.lambdatest.com/wd/hub"), capabilityFactory.getCapabilities(browser,version,platform));

        driver.get("https://stage.psn.cx/widget-preview?code=PSN-eh35zwa");

        System.out.println("Go to widget page");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));

    }

    //TEAR DOWN FUNCTION OF TESTS
    @AfterMethod
    public  void closeBrowser() {

        ((JavascriptExecutor) driver).executeScript("lambda-status=" + Boolean.toString(status));

        driver.quit();

    }




}
