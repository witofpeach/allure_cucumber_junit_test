import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.appline.steps.BaseSteps;
import ru.appline.steps.MortgagePageSteps;
import ru.appline.steps.PersonStartPageSteps;

import java.util.HashMap;

public class AllureTest {

    private PersonStartPageSteps personStartPageSteps = new PersonStartPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @Before
    public void setUp() {
        BaseSteps.setUp();
    }

    @Test
    public void testMortgageResults() {
        personStartPageSteps
                .selectAndClickMortgageButton()
                .selectAndClickMortgageForCompleteHouses();

        mortgagePageSteps
                .closeCookieWarning()
                .fillFields(
                        new HashMap<String, String>() {{
                            put("Стоимость недвижимости", "5180000");
                            put("Первоначальный взнос", "3058000");
                            put("Срок кредита", "30");
                        }}
                )
                .invertCheckBox("Страхование жизни")
                .invertCheckBox("Молодая семья")
                .checkFillFields(
                        new HashMap<String, String>() {{
                            put("Стоимость недвижимости", "5 180 000");
                            put("Первоначальный взнос", "3 058 000");
                            put("Срок кредита", "30");
                        }}
                )
                .checkResults(
                        new HashMap<String, String>() {{
                            put("Ежемесячный платеж", "16 922");
                            put("Необходимый доход", "21 784");
                            put("Сумма кредита", "2 122 000");
                            put("Процентная ставка", "11");
                        }}
                );
    }

    @After
    public void tearDown() {
        personStartPageSteps = null;
        mortgagePageSteps = null;
        BaseSteps.tearDown();
    }
}
