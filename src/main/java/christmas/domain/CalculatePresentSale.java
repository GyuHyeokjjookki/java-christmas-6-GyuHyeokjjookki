package christmas.domain;

import christmas.domain.enums.MenuPrice;

import static christmas.consts.ConstValue.ZERO;
import static christmas.consts.ConstValue.CAMPAGNE;
import static christmas.consts.ConstValue.NONE;
import static christmas.consts.ConstValue.PRESENT_BASE_PRICE;

public class CalculatePresentSale {
    public String getPresent(int price){
        if(checkGetPresent(price)){
            return CAMPAGNE;
        }
        return NONE;
    }

    public int calculatePresentPrice(int price){
        int sales = ZERO;
        if(checkGetPresent(price)){
            sales += MenuPrice.valueOf(CAMPAGNE).getPrice();
        }
        return sales;
    }

    private boolean checkGetPresent(int price){
        return price > PRESENT_BASE_PRICE;
    }
}
