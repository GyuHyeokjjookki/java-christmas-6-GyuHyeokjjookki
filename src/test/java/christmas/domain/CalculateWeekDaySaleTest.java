package christmas.domain;

import christmas.service.ParsingOrderInput;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateWeekDaySaleTest {
    ParsingOrderInput parsingOrderInput = new ParsingOrderInput();
    CalculateWeekDaySale calculateWeekDaySale = new CalculateWeekDaySale();

    @Test
    void 평일_할인_기능_테스트(){
        int day = 31;
        String order = "티본스테이크-1,바비큐립-1,초코케이크-1,제로콜라-1";

        HashMap<String, Integer> orderList = parsingOrderInput.orderResultList(order);
        int result = calculateWeekDaySale.calculateWeekDaySales(day,orderList);

        assertThat(result).isEqualTo(2023);
    }
}
