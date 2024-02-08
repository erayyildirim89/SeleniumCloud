package com.example.base;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

//BROWSER OPTIONS IMPLEMENTATION
public class OptionsManager {

    //Get Chrome Options
    public static ChromeOptions getChromeOptions(String version,String platform) {
        ChromeOptions options = new ChromeOptions();

        options.setPlatformName(platform);
        options.setBrowserVersion(version);
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", "Pisano");
        ltOptions.put("project", "SeleniumCloud");
        ltOptions.put("name", "Widget Test");
        ltOptions.put("selenium_version","4.0.0");
        ltOptions.put("w3c", true);
        options.setCapability("LT:Options", ltOptions);

        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--incognito");
        return options;
    }
    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions (String version,String platform) {

        FirefoxOptions options = new FirefoxOptions();

        options.setPlatformName(platform);
        options.setBrowserVersion(version);
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", "Pisano");
        ltOptions.put("project", "SeleniumCloud");
        ltOptions.put("name", "Widget Test");
        ltOptions.put("selenium_version","4.0.0");
        ltOptions.put("w3c", true);
        options.setCapability("LT:Options", ltOptions);

        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--incognito");
        return options;
    }

    //Set Edge Options
    public static EdgeOptions getEdgeOptions(String version,String platform){
        EdgeOptions options = new EdgeOptions();

        options.setPlatformName(platform);
        options.setBrowserVersion(version);
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", "Pisano");
        ltOptions.put("project", "SeleniumCloud");
        ltOptions.put("name", "Widget Test");
        ltOptions.put("selenium_version","4.0.0");
        ltOptions.put("w3c", true);
        options.setCapability("LT:Options", ltOptions);

        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--incognito");
        return options;

    }

}
