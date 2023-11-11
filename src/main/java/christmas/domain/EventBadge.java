package christmas.domain;

import christmas.domain.enums.Badges;

public class EventBadge {
    public String determineBadge(int price){
        if(price >= 20000){
            return Badges.SANTA.getBadge();
        }
        if(price >= 10000){
            return Badges.TREE.getBadge();
        }
        if(price >= 5000){
            return Badges.STAR.getBadge();
        }
        return Badges.NONE.getBadge();
    }
}
