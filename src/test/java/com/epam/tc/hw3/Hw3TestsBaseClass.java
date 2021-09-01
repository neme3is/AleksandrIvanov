package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hw3TestsBaseClass {
    protected static WebDriver webDriver;
    private String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final List<String> MENU_ELEMENTS = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected static final List<String> TEXTS = List.of("To include good practices and ideas from successful"
            + " EPAM project",
        "To be flexible and customizable", "To be multiplatform",
        "Already have good base (about 20 internal and some external projects), wish to get more…");
    protected static final List<String> TEXTS_SIDEBAR = List.of("Home", "Contact form", "Service",
        "Metals & Colors", "Elements packs");
    protected static final List<String> CHECKBOX_LOG_TEST_VALUES = List.of("Fire: condition changed to true",
        "Wind: condition changed to false",
        "Earth: condition changed to true", "Water: condition changed to false");
    protected static final List<String> RADIOBUTTON_TEST_VALUES = List.of("metal: value changed to Selen",
        "metal: value changed to Bronze",
        "metal: value changed to Silver", "metal: value changed to Gold");
    protected static final List<String> DROPDOWN_TEST_ELEMENTS = List.of("Colors: value changed to Yellow",
        "Colors: value changed to Blue",
        "Colors: value changed to Green", "Colors: value changed to Red");

    @BeforeClass (alwaysRun = true)
    public void beforeClassMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts()
                     .implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(baseURL);
    }

    @AfterClass(alwaysRun = true)
    public void afterTestMethod() {
        webDriver.quit();
    }
}
