package web.engine;

import java.util.Arrays;

import config.ConfigProvider;

public enum DriverType {
    chrome, firefox, remote;

    public static DriverType getFromConfig() {
        String driverType = ConfigProvider.CONFIG_PROPS.driverType();
        if(driverType == null || driverType.isEmpty()){
           throw  new IllegalArgumentException("Driver type is not provided or config file is not correct");
        }
        return Arrays.stream(DriverType.values())
                .filter(it -> it.name().equals(driverType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Provided driver type is not supported\n" +
                        "Driver Type: " + driverType));
    }
}
