package web.pages;

import lombok.Getter;
import web.pages.components.PerfumeFilterComponent;
import web.pages.components.PerfumeResultsComponent;

public class PerfumeMainPage {

    @Getter
    private final PerfumeFilterComponent perfumeFilter = new PerfumeFilterComponent();
    @Getter
    private final PerfumeResultsComponent perfumeResults = new PerfumeResultsComponent();
}