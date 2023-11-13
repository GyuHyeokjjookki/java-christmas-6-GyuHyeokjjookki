package christmas.service;


import christmas.domain.enums.ErrorMessages;

import java.util.HashMap;
import java.util.List;

import static christmas.consts.ConstValue.ONE;
import static christmas.consts.ConstValue.ZERO;

public class ParsingOrderInput {
    ListConverter listConverter = new ListConverter();
    NumberConverter numberConverter = new NumberConverter();

    public HashMap<String, Integer> orderResultList(String input) {
        HashMap<String, Integer> orderList = new HashMap<>();
        List<String> parsingRestPoint = parseRestPoint(input);
        for (String order : parsingRestPoint) {
            checkValidHypen(order);
            List<String> parseHypenOrder = parseHypen(order);
            checkValidInput(orderList,parseHypenOrder);
            orderList.put(parseHypenOrder.get(ZERO), numberConverter.numberConvert(parseHypenOrder.get(1)));
        }
        return orderList;
    }

    private void checkValidInput(HashMap<String,Integer> orderList, List<String> menuList){
        checkDuplicated(orderList, menuList);
        checkValidParse(menuList);
    }

    private void checkDuplicated(HashMap<String,Integer> orderList, List<String> menuList){
        if(orderList.containsKey(menuList.get(ZERO))){
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
        }
    }

    private void checkValidHypen(String userInput){
        if(!userInput.contains("-")){
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
        }
    }

    private void checkValidParse(List<String> userInput){
        try{
            numberConverter.numberConvert(userInput.get(ONE));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR.getMessage());
        }
    }

    private List<String> parseRestPoint(String input) {
        List<String> parsingRestPointList = listConverter.convertToList(input.split(","));
        return parsingRestPointList;
    }

    private List<String> parseHypen(String input) {
        List<String> parsingHypen = listConverter.convertToList(input.split("-"));
        return parsingHypen;
    }
}
