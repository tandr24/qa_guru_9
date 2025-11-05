package pages.component;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class CheckComponent {
    private SelenideElement checkResultInput = $("div.table-responsive");
    private SelenideElement checkInput = $("#example-modal-sizes-title-lg");

    @Step("checking result")
    public CheckComponent checkResult(String value) {
        checkResultInput.shouldHave(text(value));
        return this;
    }

    @Step("checking phrase")
    public CheckComponent haveResultPhrase() {
        checkInput.shouldHave(visible);
        return this;
    }

    @Step("checking there is no phrase")
    public CheckComponent notHaveResultPhrase() {
        checkInput.shouldNotHave(visible);
        return this;
    }
}
