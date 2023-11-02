package web.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class HeaderMenuComponent {

    private final SelenideElement parent = $("div.navigation-main__container");
    private final ElementsCollection menuItems = parent.$$("a.link--nav-heading");

    @Step("Click on menu item: {menuItem}")
    public void clickOnMenuItem(String menuItem) {
        menuItems.find(Condition.exactOwnText(menuItem)).click();
    }
}