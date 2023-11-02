package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Filters {

    MARKE("Marke"),
    PRODUCTART("Produktart"),
    FURWEN("Für Wen"),
    GESHCHENK("Geschenk für");

    private final String filter;
}