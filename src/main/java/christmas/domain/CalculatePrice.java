package christmas.domain;

import christmas.domain.enums.MenuPrice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.consts.ConstValue.ZERO;

public class CalculatePrice {
    public int calculateTotalPrice(HashMap<String, Integer> orderList){
        int totalPrice;
        List<String> orderMenu = getMenuList(orderList);
        totalPrice = calculateMenuPrice(orderList,orderMenu);
        return totalPrice;
    }

    public List<String> getMenuList(HashMap<String, Integer> orderList){
        List<String> menuList = new ArrayList<>();
        for(Map.Entry<String, Integer> item : orderList.entrySet()){
           menuList.add(item.getKey());
        }
        return menuList;
    }

    private int calculateMenuPrice(HashMap<String, Integer> orderList, List<String> menuList){
        int sum = ZERO;
        for(String menu : menuList){
            sum += orderList.get(menu) * MenuPrice.valueOf(menu).getPrice();
        }
        return sum;
    }
}
