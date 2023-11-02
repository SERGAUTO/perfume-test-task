package tests;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import enums.Filters;
import enums.HeaderMenu;
import web.features.OpenPerfumeFeature;
import web.features.PerfumeFilterFeature;
import web.pages.MainPage;

public class PerfumeSimpleTest extends WebBaseTest {

    private final MainPage mainPage = new MainPage();

    @DataProvider(name = "filters")
    public static Object[][] filtersDataProvider() {
        return new Object[][] {{Map.of(
                Filters.MARKE.getFilter(), "100BON",
                Filters.PRODUCTART.getFilter(), "Parfum",
                Filters.FURWEN.getFilter(), "Unisex")},
                {Map.of(Filters.PRODUCTART.getFilter(), "Duftset", Filters.FURWEN.getFilter(), "Unisex")},
                {Map.of(Filters.MARKE.getFilter(), "DIOR",
                        Filters.PRODUCTART.getFilter(), "Eau de Toilette",
                        Filters.FURWEN.getFilter(), "Unisex",
                        Filters.GESHCHENK.getFilter(), "Geburtstag")}};
    }

    @Test(dataProvider = "filters")
    public void verifyPerfumeFilter(Map<String, String> filters) {
        new OpenPerfumeFeature().openPerfume();
        mainPage.getHeaderMenuComponent().clickOnMenuItem(HeaderMenu.PARFUM.getHeaderMenu());
        new PerfumeFilterFeature(filters).setFilters();
        new PerfumeFilterFeature(filters).verifyFilteredResults();
    }
}