package ru.appline.steps;

import ru.appline.utils.PagesManager;

import static ru.appline.utils.InitManager.*;
import static ru.appline.utils.PagesManager.nullPagesManager;

public class BaseSteps {

    PagesManager pagesManager = PagesManager.getPagesManager();

    public static void setUp() {

        initFramework();

        getBaseUrl();
    }

    public static void tearDown() {
        nullPagesManager();

        quitFramework();
    }
}
