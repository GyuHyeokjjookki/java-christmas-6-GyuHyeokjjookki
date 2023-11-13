package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChristmasSaleTest {
    ChristmasSale christmasSale = new ChristmasSale();

    @Test
    void 이벤트_기한이_아닌_경우_테스트(){
        int day = 31;
        int result = christmasSale.calculateChristmasSale(day);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 할인_가격_계산_테스트(){
        int day = 25;
        int result = christmasSale.calculateChristmasSale(day);

        assertThat(result).isEqualTo(3400);
    }
}
