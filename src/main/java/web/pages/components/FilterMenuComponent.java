package web.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class FilterMenuComponent {

    private final SelenideElement parent = $("div.facet__menu-content");
    private final SelenideElement applyButton = parent.$("button.facet__close-button");

    @Step("Click on filter checkbox by value: {value}")
    public void clickOnFilterCheckboxByValue(String value) {
        getCheckboxByName(value).click();
        clickOnApplyBtn();
    }

    public void clickOnApplyBtn() {
        applyButton.scrollTo().click();
    }

    private SelenideElement getCheckboxByName(String name) {
        return parent.$$("div[class*=checkbox--rating-stars]").find(Condition.matchText("^" + name + ".*")).parent();
    }
}