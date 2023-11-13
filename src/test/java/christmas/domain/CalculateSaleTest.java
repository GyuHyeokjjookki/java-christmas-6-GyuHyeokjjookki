package christmas.domain;

import christmas.service.ParsingOrderInput;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateSaleTest {
    CalculateSales calculateSales = new CalculateSales();
    ParsingOrderInput parsingOrderInput = new ParsingOrderInput();

    @Test
    void 전체_할인_기능_테스트(){
        int day = 3;
        int price = 142000;
        String order = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        HashMap<String,Integer> orderList = parsingOrderInput.orderResultList(order);

        int result = calculateSales.calculateSalesPrice(day,price,orderList);

        assertThat(result).isEqualTo(31246);

        HashMap<String,Integer> saleList = calculateSales.getSaleList();
        assertThat(saleList).containsEntry("증정 이벤트", 25000);
        assertThat(saleList).containsEntry("크리스마스 디데이 할인", 1200);
        assertThat(saleList).containsEntry("평일 할인", 4046);
        assertThat(saleList).containsEntry("특별 할인", 1000);
    }
}
