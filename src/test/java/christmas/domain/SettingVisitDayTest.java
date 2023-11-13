package christmas.domain;

import christmas.domain.enums.ErrorMessages;
import christmas.service.NumberConverter;
import christmas.service.ValidateOrder;
import christmas.service.ValidateVisitDay;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SettingVisitDayTest {
    NumberConverter numberConverter = new NumberConverter();
    ValidateVisitDay validateVisitDay = new ValidateVisitDay();

    @Test
    void 숫자가_아닌_입력_예외처리(){
        String visitDay = "a";

        assertThatThrownBy(() -> validateVisitDay.checkInteger(visitDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_DAY_ERROR.getMessage());
    }

    @Test
    void 잘못된_날짜_입력_예외처리(){
        int visitDay = 0;
        assertThatThrownBy(() -> validateVisitDay.validate(visitDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_DAY_ERROR.getMessage());
    }

    @Test
    void 잘못된_날짜_예외처리(){
        int visitDay = 32;
        assertThatThrownBy(() -> validateVisitDay.validate(visitDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_DAY_ERROR.getMessage());
    }
}
