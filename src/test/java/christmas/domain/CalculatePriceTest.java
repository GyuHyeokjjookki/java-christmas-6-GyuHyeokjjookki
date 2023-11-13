package christmas.domain;

import christmas.service.ParsingOrderInput;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatePriceTest {
    CalculatePrice calculatePrice = new CalculatePrice();
    ParsingOrderInput parsingOrderInput = new ParsingOrderInput();

    @Test
    void 주문_메뉴_리스트_반환_기능_테스트(){
        String order = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        HashMap<String, Integer> result = parsingOrderInput.orderResultList(order);
        List<String> menuList = calculatePrice.getMenuList(result);

        assertThat(menuList).contains("티본스테이크");
        assertThat(menuList).contains("바비큐립");
        assertThat(menuList).contains("초코케이크");
        assertThat(menuList).contains("제로콜라");
    }

    @Test
    void 주문_메뉴_가격_계산_테스트(){
        String order = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        HashMap<String, Integer> orderList = parsingOrderInput.orderResultList(order);
        int result = calculatePrice.calculateTotalPrice(orderList);

        assertThat(result).isEqualTo(142000);
    }
}
