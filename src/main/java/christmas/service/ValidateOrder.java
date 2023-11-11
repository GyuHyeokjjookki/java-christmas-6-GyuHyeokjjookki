package christmas.service;

import christmas.domain.enums.ErrorMessages;
import christmas.domain.enums.MenuCategory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.consts.ConstValue.ZERO;
import static christmas.consts.ConstValue.MAX_ORDER_QUANTITY;
import static christmas.consts.ConstValue.ONE;
import static christmas.consts.ConstValue.DRINK;

public class ValidateOrder {

    public void validateOrder(HashMap<String,Integer> orderList){
        checkValidMenu(orderList);
        checkValidTotalQuantity(orderList);
        checkValidQuantity(orderList);
        checkOnlyDrink(orderList);
    }

    private void checkOnlyDrink(HashMap<String,Integer> orderList){
        Set<String> categoryList = new HashSet<>();
        for(Map.Entry<String, Integer> menuItem : orderList.entrySet()){
            categoryList.add(MenuCategory.valueOf(menuItem.getKey()).getCategory());
        }
        if(categoryList.contains(DRINK) && categoryList.size() == ONE){
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
        }
    }

    private void checkValidMenu(HashMap<String,Integer> orderList){
        for(Map.Entry<String, Integer> menuItem : orderList.entrySet()){
            if(!getAllMenu().contains(menuItem.getKey())){
                throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
            }
        }
    }

    private int caculateTotalQuantity(HashMap<String, Integer> orderList){
        int total = ZERO;
        for(Map.Entry<String, Integer> menuItem : orderList.entrySet()){
            total += menuItem.getValue();
        }
        return total;
    }

    private void checkValidTotalQuantity(HashMap<String,Integer> orderList){
        if(caculateTotalQuantity(orderList) > MAX_ORDER_QUANTITY){
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
        }
    }

    private void checkValidQuantity(HashMap<String,Integer> orderList){
        for(Map.Entry<String, Integer> menuItem : orderList.entrySet()){
            if(menuItem.getValue() <= ZERO){
                throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
            }
        }
    }

    private List<String> getAllMenu(){
        List<String> menu = Stream.of(MenuCategory.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return menu;
    }
}
