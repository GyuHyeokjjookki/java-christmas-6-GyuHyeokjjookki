package christmas.domain;

import static christmas.consts.ConstValue.FIRSTDAY_CHRISTMAS_SALES;
import static christmas.consts.ConstValue.INCREASE_SALE_PRICE;
import static christmas.consts.ConstValue.FIRST_DAY;
import static christmas.consts.ConstValue.CHRISTMAS_DAY;
import static christmas.consts.ConstValue.ZERO;
import static christmas.consts.ConstValue.ONE;

public class ChristmasSale {

    public int calculateChristmasSale(int day){
        int salePrice = FIRSTDAY_CHRISTMAS_SALES;
        if(checkChristmasSale(day)) {
            salePrice += (day - ONE) * INCREASE_SALE_PRICE;
            return salePrice;
        }
        return ZERO;
    }

    private boolean checkChristmasSale(int day){
        return (day >= FIRST_DAY && day <= CHRISTMAS_DAY);
    }
}
