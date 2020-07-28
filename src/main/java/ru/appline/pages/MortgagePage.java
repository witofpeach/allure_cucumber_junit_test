package ru.appline.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static ru.appline.utils.DriverManager.getDriver;

public class MortgagePage extends BasePage {

    @FindBy(xpath = "//div[text()='Стоимость недвижимости']//..//input")
    WebElement housePriceInput;

    @FindBy(xpath = "//div[text()='Первоначальный взнос']//..//input")
    WebElement initialPaymentInput;

    @FindBy(xpath = "//div[text()='Срок кредита']//..//input")
    WebElement loanPeriodInput;

    @FindBy(xpath = "//span[text()='Страхование жизни']//..//..//div[contains(@class, 'switch')]")
    WebElement lifeInsuranceCheckbox;

    @FindBy(xpath = "//span[text()='Молодая семья']//..//..//div[contains(@class, 'switch')]")
    WebElement youngFamilyCheckbox;

    @FindBy(xpath = "//div[contains(@class, 'resultSection')]//span[@data-e2e-id='mland-calculator/main-result-monthly-payment']//span")
    WebElement monthlyPaymentResult;

    @FindBy(xpath = "//div[contains(@class, 'resultSection')]//span[@data-e2e-id='mland-calculator/main-result-credit-sum']//span")
    WebElement totalLoanSumResult;

    @FindBy(xpath = "//div[contains(@class, 'resultSection')]//span[@data-e2e-id='mland-calculator/main-result-required-income']//span")
    WebElement requiredIncomeResult;

    @FindBy(xpath = "//div[contains(@class, 'resultSection')]//span[@data-e2e-id='mland-calculator/main-result-credit-rate']//span")
    WebElement creditRateResult;

    @FindBy(xpath = "//a[@class='cookie-warning__close']")
    WebElement cookieWarningCloseButton;

    public void selectFrame() {
        String xpathFrame = "//iframe[@title='Основной контент']";
        WebElement frame = getDriver().findElement(By.xpath(xpathFrame));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", frame);

        getDriver().switchTo().frame(frame);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Стоимость недвижимости":
                fillField(housePriceInput, value);
                break;
            case "Первоначальный взнос":
                fillField(initialPaymentInput, value);
                break;
            case "Срок кредита":
                fillField(loanPeriodInput, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void invertCheckBoxSelection(String name) {
        switch (name) {
            case "Страхование жизни":
                if (isElementPresent(lifeInsuranceCheckbox))
                    click(lifeInsuranceCheckbox);
                else
                    Assert.fail("sdfasdfasdf");
                break;
            case "Молодая семья":
                if (isElementPresent(youngFamilyCheckbox))
                    click(youngFamilyCheckbox);
                else
                    Assert.fail("sdfasdfasdf");
                break;
            default:
                throw new AssertionError("Чекбокс '" + name + "' не объявлен на странице");
        }
        action.pause(Duration.ofSeconds(2)).build().perform();
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Стоимость недвижимости":
                return housePriceInput.getAttribute("value");
            case "Первоначальный взнос":
                return initialPaymentInput.getAttribute("value");
            case "Срок кредита":
                return loanPeriodInput.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public String getResult(String resultName) {
        switch (resultName) {
            case "Ежемесячный платеж":
                return monthlyPaymentResult.getText().replaceAll("₽", "").trim();
            case "Сумма кредита":
                return totalLoanSumResult.getText().replaceAll("₽", "").trim();
            case "Необходимый доход":
                return requiredIncomeResult.getText().replaceAll("₽", "").trim();
            case "Процентная ставка":
                return creditRateResult.getText().replaceAll("[,]", ".").replaceAll("[%]", "");
        }
        throw new AssertionError("Результат не объявлен на странице");
    }

    public void closeCookieWarning() {
        cookieWarningCloseButton.click();
    }
}
