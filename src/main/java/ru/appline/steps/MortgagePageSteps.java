package ru.appline.steps;

import io.qameta.allure.Step;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MortgagePageSteps extends BaseSteps {

    @Step("закрытие предупреждения об использовании куки")
    public MortgagePageSteps closeCookieWarning() {
        pagesManager.getMortgagePage().closeCookieWarning();
        return this;
    }

    @Step("заполняются поля:")
    public MortgagePageSteps fillFields(Map<String, String> fields) {
        pagesManager.getMortgagePage().selectFrame();
        fields.forEach(this::fillField);
        return this;
    }

    @Step("поле {fieldName} заполняется значением {value}")
    private void fillField(String fieldName, String value) {
        pagesManager.getMortgagePage().fillField(fieldName, value);
    }

    @Step("снятие галочки {name}")
    public MortgagePageSteps invertCheckBox(String name) {
        pagesManager.getMortgagePage().invertCheckBoxSelection(name);
        return this;
    }

    @Step("выполнена проверка заполнения полей:")
    public MortgagePageSteps checkFillFields(Map<String, String> fields) {
        fields.forEach(this::checkFillField);
        return this;
    }

    @Step("поле {fieldName} заполнено значением {value}")
    private void checkFillField(String fieldName, String value) {
        String actual = pagesManager.getMortgagePage().getFillField(fieldName);
        assertTrue(
                String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", fieldName, actual, value),
                actual.equals(value)
        );
    }

    @Step("выполнена проверка результатов:")
    public MortgagePageSteps checkResults(Map<String, String> results) {
        results.forEach(this::checkResult);
        return this;
    }

    @Step("результат {resultName} заполнен значением {value}")
    private void checkResult(String resultName, String value) {
        String actual = pagesManager.getMortgagePage().getResult(resultName);
        assertTrue(
                String.format("Значение результата [%s] равно [%s]. Ожидалось - [%s]", resultName, actual, value),
                actual.equals(value)
        );
    }
}
