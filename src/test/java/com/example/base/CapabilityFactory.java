
package com.example.base;
import org.openqa.selenium.Capabilities;
public class CapabilityFactory
{

    public Capabilities capabilities;
    public Capabilities getCapabilities (String browser,String version,String platform) {

        switch (browser) {
            case "firefox":
                capabilities = OptionsManager.getFirefoxOptions(version,platform);
                break;
            case "edge":
                capabilities = OptionsManager.getEdgeOptions(version,platform);
                break;
            case "chrome":
                capabilities = OptionsManager.getChromeOptions(version,platform);
                break;
        }

        return capabilities;
    }

}
