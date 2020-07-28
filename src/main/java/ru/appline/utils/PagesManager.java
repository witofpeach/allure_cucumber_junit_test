package ru.appline.utils;

import ru.appline.pages.MortgagePage;
import ru.appline.pages.PersonStartPage;

public class PagesManager {

    private static PagesManager pagesManager;

    PersonStartPage personStartPage;
    MortgagePage mortgagePage;

    private PagesManager() {
    }

    public static PagesManager getPagesManager() {
        if (pagesManager == null) {
            pagesManager = new PagesManager();
        }
        return pagesManager;
    }

    public PersonStartPage getPersonStartPage() {
        if (personStartPage == null) {
            personStartPage = new PersonStartPage();
        }
        return personStartPage;
    }

    public MortgagePage getMortgagePage() {
        if (mortgagePage == null) {
            mortgagePage = new MortgagePage();
        }
        return mortgagePage;
    }

    public static void nullPagesManager() {
        pagesManager = null;
    }
}
