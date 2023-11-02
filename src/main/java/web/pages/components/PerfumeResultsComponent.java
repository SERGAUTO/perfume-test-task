package web.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Filters;
import io.qameta.allure.Step;

public class PerfumeResultsComponent {

    private final SelenideElement parent = $("#productlisting");
    private final ElementsCollection brandElements = parent.$$("div.top-brand");
    private final ElementsCollection categoryElements = parent.$$("div.category");

    @Step("Verify result page contains filter {filterName} value: {filterValue}")
    public void verifyFilterResults(String filterName, String filterValue) {
        if (filterName.equals(Filters.MARKE.getFilter())) {
            verifyBrand(filterValue);
        }
        if (filterName.equals(Filters.PRODUCTART.getFilter())) {
            verifyCategory(filterValue);
        }
    }

    private PerfumeResultsComponent verifyBrand(String brandName) {
        brandElements.shouldHave(CollectionCondition.allMatch(
                "Item brand should contains text",
                brandElement -> brandElement.getText().contains(brandName)));
        return this;
    }

    private PerfumeResultsComponent verifyCategory(String categoryName) {
        categoryElements.shouldHave(CollectionCondition.allMatch(
                "Item category should contains text",
                brandElement -> brandElement.getText().contains(categoryName)));
        return this;
    }
}