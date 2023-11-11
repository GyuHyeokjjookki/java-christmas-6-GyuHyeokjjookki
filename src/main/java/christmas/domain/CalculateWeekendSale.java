package christmas.domain;

import christmas.domain.enums.MenuCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.consts.ConstValue.*;
import static christmas.consts.ConstValue.CHECK_WEEKEND_SAT;

public class CalculateWeekendSale {
    CalculatePrice calculatePrice = new CalculatePrice();
    public int calculateWeekendSales(int day, HashMap<String,Integer> orderList){
        int sale = ZERO;
        if(checkWeekendSale(day,orderList)){
            sale = countWeekendMainMenu(orderList);
            return sale * WEEKEND_SALE_PRICE;
        }
        return sale;
    }

    private int countWeekendMainMenu(HashMap<String,Integer> orderList){
        int count = ZERO;
        for(Map.Entry<String,Integer> item : orderList.entrySet()){
            if(MenuCategory.valueOf(item.getKey()).getCategory().equals(MAIN)){
                System.out.println(item.getKey());
                count += orderList.get(item.getKey());
            }
        }
        return count;
    }

    private boolean checkWeekendSale(int day, HashMap<String,Integer> orderList){
        return (checkWeekend(day) && makeCategoryList(orderList).contains(MAIN));
    }

    public boolean checkWeekend(int day){
        return (day % WEEK_DAYS == CHECK_WEEKEND_FRI || day % WEEK_DAYS == CHECK_WEEKEND_SAT);
    }

    public List<String> makeCategoryList(HashMap<String,Integer> userInput){
        List<String> categoryList = new ArrayList<>();
        List<String> menuList= calculatePrice.getMenuList(userInput);
        for(String menu : menuList){
            categoryList.add(MenuCategory.valueOf(menu).getCategory());
        }
        return categoryList;
    }
}
