package web.features;

import java.util.Map;

import web.pages.PerfumeMainPage;

public class PerfumeFilterFeature {
    private final PerfumeMainPage perfumeMainPage;

    private final Map<String, String> filters;

    public PerfumeFilterFeature(Map<String, String> filters) {
        this.filters = filters;
        this.perfumeMainPage = new PerfumeMainPage();
    }

    public void setFilters() {
        filters.forEach((key, value) -> perfumeMainPage.getPerfumeFilter().selectFilterByNameAndValue(key, value));
    }

    public void verifyFilteredResults() {
        filters.forEach((key, value) -> perfumeMainPage.getPerfumeResults().verifyFilterResults(key, value));
    }
}
