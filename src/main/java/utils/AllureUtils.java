package utils;

import java.util.List;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AllureUtils {
    public static void attachBrowserConsoleErrorLogs(List<String> errorLogs) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String logEntry : errorLogs) {
                stringBuilder.append(logEntry).append("\n");
            }
            log.info("Taking current browser console js error logs");
            try {
                Allure.addAttachment("Browser Console js error logs", "text/plain", stringBuilder.toString(), ".log");
            } catch (Exception e) {
                log.error("Error taking current browser console js error logs: " + e.getMessage());
            }
        }
    }
}
