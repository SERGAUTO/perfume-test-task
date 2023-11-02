package web.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import annotations.CheckBrowserErrors;
import io.qameta.allure.Step;

public class PerfumeFilterComponent {
    private final SelenideElement parent = $("div.facet-list");
    private final FilterMenuComponent filterMenuComponent = new FilterMenuComponent();

    @CheckBrowserErrors
    @Step("Select filter by name: {name} and value: {value}")
    public PerfumeFilterComponent selectFilterByNameAndValue(String filterName, String filterValue){
        getFilterByName(filterName).scrollTo().click();
        filterMenuComponent.clickOnFilterCheckboxByValue(filterValue);
        return this;
    }

    private SelenideElement getFilterByName(String filterName){
        return parent.$$("div.facet__title").find(Condition.exactOwnText(filterName)).parent();
    }
}