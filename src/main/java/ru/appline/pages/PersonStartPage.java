package ru.appline.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonStartPage extends BasePage {

    @FindBy(xpath = "//label[contains(text(), 'Ипотека')]")
    WebElement mortgageMenuButton;

    @FindBy(xpath = "//a[contains(text(), 'Ипотека на готовое жильё')]")
    WebElement mortgageForCompleteHousesButton;

    public void selectMenuMortgageButton() {
        if (isElementPresent(mortgageMenuButton))
            click(mortgageMenuButton);
        else
            Assert.fail("kasdfsdfasdfasdf");
    }

    public void selectAndClickMortgageForCompleteHousesButton() {
        if (isElementPresent(mortgageForCompleteHousesButton))
            click(mortgageForCompleteHousesButton);
    }
}
