package com.epam.tc.hw6.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import javax.management.openmbean.InvalidOpenTypeException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class WebDriverFactory {
    private WebDriverFactory() {

    }

    private static final String CHROME = "chrome";
    private static final String EDGE = "MicrosoftEdge";

    private static final String REMOTE_DRIVER_TYPE = "remote";
    private static final String LOCAL_DRIVER_TYPE = "local";

    public static WebDriver createWebDriver(final String driverType, final String browsername) {
        if (REMOTE_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createRemoteWebDriver(browsername);
        } else if (LOCAL_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createLocalDriver(browsername);
        } else {
            throw new WebDriverTypeException(String.format("Unsupported driver type: %s", driverType));
        }
    }

    private static WebDriver createLocalDriver(final String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase(Locale.ROOT)) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case EDGE:
                driver = createEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Unsupported browser: %s", browserName));
        }
        return driver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createRemoteWebDriver(final String browsername) {
        Capabilities capabilities = null;
        if (CHROME.equalsIgnoreCase(browsername)) {
            capabilities = createRemoteChromeCapabilities();
        } else if (EDGE.equalsIgnoreCase(browsername)) {
            capabilities = createRemoteEdgeCapabilities();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported browser: %s", browsername));
        }
        try {
            return new RemoteWebDriver(new URL("http://192.168.0.182:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new InvalidOpenTypeException("Incorrect selenium grid url");
        }
    }

    private static Capabilities createRemoteChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createRemoteEdgeCapabilities() {
        return new EdgeOptions();
    }
}
