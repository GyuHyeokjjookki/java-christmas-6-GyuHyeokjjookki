package christmas.domain;

import christmas.domain.enums.Badges;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventBadgeTest {
    EventBadge eventBadge = new EventBadge();

    @Test
    void 이벤트_배지_기능_테스트(){
        int priceSanta = 100000;
        int priceStar = 7000;
        int priceTree = 13000;

        String resultSanta = eventBadge.determineBadge(priceSanta);
        String resultStar = eventBadge.determineBadge(priceStar);
        String resultTree = eventBadge.determineBadge(priceTree);

        assertThat(resultSanta).isEqualTo(Badges.SANTA.getBadge());
        assertThat(resultStar).isEqualTo(Badges.STAR.getBadge());
        assertThat(resultTree).isEqualTo(Badges.TREE.getBadge());
    }
}
