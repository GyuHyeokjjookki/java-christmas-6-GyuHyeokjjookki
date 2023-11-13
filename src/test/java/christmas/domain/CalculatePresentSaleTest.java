package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatePresentSaleTest {
    CalculatePresentSale calculatePresentSale = new CalculatePresentSale();

    @Test
    void 증정_할인_계산_기능_테스트(){
        int over = 130000;
        int under = 30000;

        int resultOver = calculatePresentSale.calculatePresentPrice(over);
        int resultUnder = calculatePresentSale.calculatePresentPrice(under);

        assertThat(resultOver).isEqualTo(25000);
        assertThat(resultUnder).isEqualTo(0);
    }

    @Test
    void 증정_할인_품목_기능_테스트(){
        int over = 130000;
        int under = 30000;

        String resultOver = calculatePresentSale.getPresent(over);
        String resultUnder = calculatePresentSale.getPresent(under);

        assertThat(resultOver).isEqualTo("샴페인");
        assertThat(resultUnder).isEqualTo("없음");
    }
}
