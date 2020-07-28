package ru.appline.steps;

import io.qameta.allure.Step;

public class PersonStartPageSteps extends BaseSteps {

    @Step("навелись на 'Ипотека'")
    public PersonStartPageSteps selectAndClickMortgageButton() {
        pagesManager.getPersonStartPage().selectMenuMortgageButton();
        return this;
    }

    @Step("дождались появления выпадающего меню - выбрали 'Ипотека на готовое жилье'")
    public void selectAndClickMortgageForCompleteHouses() {
        pagesManager.getPersonStartPage().selectAndClickMortgageForCompleteHousesButton();
    }
}
