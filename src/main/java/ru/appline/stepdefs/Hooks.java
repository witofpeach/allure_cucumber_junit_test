package ru.appline.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.appline.steps.BaseSteps;

import static ru.appline.utils.AllureUtils.addScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        BaseSteps.setUp();
    }

    @After
    public void tearDown(){
        addScreenshot();
        BaseSteps.tearDown();
    }
}
