package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateSpecialDayTest {
    CalculateSpecialDay calculateSpecialDay = new CalculateSpecialDay();

    @Test
    void 특별_할인_기능_테스트(){
        int day = 10;

        int result = calculateSpecialDay.calculateSpecialSale(day);
        assertThat(result).isEqualTo(1000);
    }
}
