package app.rubetek.tests;

import app.rubetek.pages.external.GoogleAuthPage;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static app.rubetek.config.ConfigHelper.isVideoOn;
import static app.rubetek.helpers.AttachmentsHelper.*;
import static app.rubetek.helpers.DriverHelper.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


@ExtendWith({AllureJunit5.class})
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    GoogleAuthPage googleAuthPage = new GoogleAuthPage();

    @BeforeAll
    public static void beforeAll() {
        configureDriver();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
//        attachNetwork(); // todo
        attachAsText("Browser console logs", getConsoleLogs());

        closeWebDriver();

        if (isVideoOn()) attachVideo(sessionId); // in browserstack video url generates after driver close
    }

}
