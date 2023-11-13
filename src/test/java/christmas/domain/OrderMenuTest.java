package christmas.domain;

import christmas.domain.enums.ErrorMessages;
import christmas.service.ParsingOrderInput;
import christmas.service.ValidateOrder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OrderMenuTest {

    ParsingOrderInput parsingOrderInput = new ParsingOrderInput();
    ValidateOrder validateOrder = new ValidateOrder();

    @Test
    void 입력_메뉴_변환_기능_테스트(){
        String order = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        HashMap<String, Integer> result = parsingOrderInput.orderResultList(order);
        assertThat(result).containsEntry("티본스테이크", 1);
        assertThat(result).containsEntry("바비큐립", 1);
        assertThat(result).containsEntry("초코케이크", 2);
        assertThat(result).containsEntry("제로콜라", 1);
    }

    @Test
    void 음료_주문_예외_처리_테스트(){
        String order = "제로콜라-1";
        HashMap<String, Integer> result = parsingOrderInput.orderResultList(order);

        assertThatThrownBy(() -> validateOrder.validateOrder(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
    }

    @Test
    void 최대주문_수량_예외_처리_테스트(){
        String order = "제로콜라-196,타파스-4";
        HashMap<String, Integer> result = parsingOrderInput.orderResultList(order);

        assertThatThrownBy(() -> validateOrder.validateOrder(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
    }

    @Test
    void 최소주문_수량_예외_처리_테스트(){
        String order = "타파스-0";
        HashMap<String, Integer> result = parsingOrderInput.orderResultList(order);

        assertThatThrownBy(() -> validateOrder.validateOrder(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
    }

    @Test
    void 목록에_없는_메뉴_주문_예외_처리_테스트(){
        String order = "우리엄마의고기완자-1";
        HashMap<String, Integer> result = parsingOrderInput.orderResultList(order);

        assertThatThrownBy(() -> validateOrder.validateOrder(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
    }

}
