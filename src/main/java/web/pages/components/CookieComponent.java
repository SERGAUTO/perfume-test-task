package web.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CookieComponent {

    private final SelenideElement parent = $("[role=dialog]");
    private final SelenideElement acceptCookieBtn = parent.$("button.uc-list-button__accept-all");

    @Step("Click on 'Accept' cookie button")
    public void clickOnAcceptCookieBtn() {
        acceptCookieBtn.click();
    }
}