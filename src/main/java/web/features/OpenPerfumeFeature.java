package web.features;

import com.codeborne.selenide.Selenide;
import config.ConfigProvider;
import io.qameta.allure.Step;
import web.pages.MainPage;

public class OpenPerfumeFeature {
    private final String baseUrl;
    private final MainPage mainPage;

    public OpenPerfumeFeature() {
        this.baseUrl = ConfigProvider.CONFIG_PROPS.webUrl();
        this.mainPage = new MainPage();
    }

    @Step("Open Perfume page")
    public void openPerfume() {
        Selenide.open(baseUrl);
        mainPage.getCookieComponent().clickOnAcceptCookieBtn();
    }
}