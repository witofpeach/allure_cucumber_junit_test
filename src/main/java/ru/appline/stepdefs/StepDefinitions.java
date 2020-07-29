package ru.appline.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.appline.steps.MortgagePageSteps;
import ru.appline.steps.PersonStartPageSteps;

public class StepDefinitions {

    private PersonStartPageSteps personStartPageSteps = new PersonStartPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @When("навелись на 'Ипотека'")
    public void selectAndClickMortgageButton() {
        personStartPageSteps.selectAndClickMortgageButton();
    }

    @Then("дождались появления выпадающего меню - выбрали 'Ипотека на готовое жилье'")
    public void selectAndClickMortgageForCompleteHouses() {
        personStartPageSteps.selectAndClickMortgageForCompleteHouses();
    }

    @Then("закрытие предупреждения об использовании куки")
    public void closeCookieWarning() {
        mortgagePageSteps.closeCookieWarning();
    }

    @When("заполняются поля:")
    public void fillFields(DataTable fields) {
        mortgagePageSteps.fillFields(
                fields.asMap(String.class, String.class)
        );
    }

    @And("изменено состояние checkbox'а {string}")
    public void invertCheckBox(String checkboxName) {
        mortgagePageSteps.invertCheckBox(checkboxName);
    }

    @Then("выполнена проверка заполнения полей:")
    public void checkFillFields(DataTable fields) {
        mortgagePageSteps.checkFillFields(
                fields.asMap(String.class, String.class)
        );
    }

    @And("выполнена проверка результатов:")
    public void checkResults(DataTable results) {
        mortgagePageSteps.checkResults(
                results.asMap(String.class, String.class)
        );
    }
}
