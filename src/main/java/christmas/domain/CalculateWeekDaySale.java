package christmas.domain;

import christmas.domain.enums.MenuCategory;

import java.util.HashMap;
import java.util.Map;

import static christmas.consts.ConstValue.*;

public class CalculateWeekDaySale {
    CalculateWeekendSale calculateWeekendSale = new CalculateWeekendSale();

    public int calculateWeekDaySales(int day, HashMap<String,Integer> orderList){
        int sale = ZERO;
        if(checkWeekDaySale(day,orderList)){
            sale = countWeekDayDessertMenu(orderList);
            return sale * WEEKDAY_SALE_PRICE;
        }
        return sale;
    }

    private int countWeekDayDessertMenu(HashMap<String,Integer> orderList){
        int count = ZERO;
        for(Map.Entry<String,Integer> item : orderList.entrySet()){
            if(MenuCategory.valueOf(item.getKey()).getCategory().equals(DESSERT)){
                count += orderList.get(item.getKey());
            }
        }
        return count;
    }

    private boolean checkWeekDaySale(int day, HashMap<String,Integer> orderList){
        return (!calculateWeekendSale.checkWeekend(day) && calculateWeekendSale.makeCategoryList(orderList).contains(DESSERT));
    }
}
