package christmas.domain;

import christmas.service.ParsingOrderInput;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateWeekEndSaleTest {
    CalculateWeekendSale calculateWeekendSale = new CalculateWeekendSale();
    ParsingOrderInput parsingOrderInput = new ParsingOrderInput();

    @Test
    void 주말_판별_기능_테스트(){
        int day = 1;
        boolean result =  calculateWeekendSale.checkWeekend(day);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void 주말_할인_기능_테스트(){
        int day = 1;
        String order = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        HashMap<String, Integer> orderList = parsingOrderInput.orderResultList(order);
        int result = calculateWeekendSale.calculateWeekendSales(day,orderList);

        assertThat(result).isEqualTo(4046);
    }
}
