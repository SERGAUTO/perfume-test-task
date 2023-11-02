package web.pages;

import lombok.Getter;
import web.pages.components.CookieComponent;
import web.pages.components.HeaderMenuComponent;

public class MainPage {
    @Getter
    private final CookieComponent cookieComponent = new CookieComponent();
    @Getter
    private final HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent();
}
