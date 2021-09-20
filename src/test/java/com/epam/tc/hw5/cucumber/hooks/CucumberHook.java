package com.epam.tc.hw5.cucumber.hooks;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CucumberHook {

    private WebDriver driver;

    @Before
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        TestContext.getInstance().addTestObject("web_driver", driver);
    }

    @Before
    public void testData() {
        List<String> radiobuttonLog = List.of("metal: value changed to Selen");
        List<String> colorLog =  List.of("Colors: value changed to Yellow");
        List<String> checkboxLog = List.of(
                "Wind: condition changed to true", "Water: condition changed to true");
        TestContext.getInstance().addTestObject("radiobutton_log", radiobuttonLog);
        TestContext.getInstance().addTestObject("color_log", colorLog);
        TestContext.getInstance().addTestObject("checkbox_log", checkboxLog);
    }

    @After
    public void tearDownDriver() {
        driver.quit();
        TestContext.getInstance().clean();
    }
}
