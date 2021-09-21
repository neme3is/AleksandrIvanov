package com.epam.tc.hw6.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends BasePage {
    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//label[text()[contains(.,'Water')]]/input")
    private WebElement waterCheckbox;

    @FindBy (xpath = "//label[text()[contains(.,'Wind')]]/input")
    private WebElement windCheckbox;

    @FindBy (xpath = "//label[text()[contains(.,'Selen')]]/input")
    private WebElement selenRadiobutton;

    @FindBy (css = ".colors")
    private WebElement dropdownColorsList;

    @FindBy (xpath = "//select[@class='uui-form-element']/option[text()[contains(.,'Yellow')]]")
    private WebElement yellowColorInList;

    @FindBy (css = ".logs li")
    private List<WebElement> logRecords;

    @FindBy (css = ".checkbox-row .label-radio input")
    private List<WebElement> radiobuttons;

    @FindBy (css = ".checkbox-row .label-checkbox input")
    private List<WebElement> checkboxes;

    @FindBy (css = "select.uui-form-element option")
    private List<WebElement> dropdownColorsElements;

    public void selectWaterCheckbox() {
        waterCheckbox.click();
    }

    public void selectWindCheckbox() {
        windCheckbox.click();
    }

    public void selectSelenRadiobutton() {
        selenRadiobutton.click();
    }

    public void selectYellowColorInDropdownList() {
        dropdownColorsList.click();
        yellowColorInList.click();
    }

    public List<WebElement> getLogRecords() {
        return logRecords;
    }

    public void clickAllRadiobuttons() {
        for (WebElement we : radiobuttons) {
            we.click();
        }
    }

    public void clickAllDropdownColorsElements() {
        for (WebElement we : dropdownColorsElements) {
            we.click();
        }
    }

    public void clickAllCheckboxButtons() {
        for (WebElement we : checkboxes) {
            we.click();
        }
    }
}
