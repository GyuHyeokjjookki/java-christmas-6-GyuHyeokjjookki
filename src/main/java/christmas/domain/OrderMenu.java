package christmas.domain;

import christmas.service.ParsingOrderInput;
import christmas.service.ValidateOrder;
import christmas.view.InputView;

import java.util.HashMap;

public class OrderMenu {
    InputView inputView = new InputView();
    ValidateOrder validateOrderedMenu = new ValidateOrder();
    ParsingOrderInput parsingOrderInput = new ParsingOrderInput();

    public HashMap<String,Integer> setOrderList(){
        HashMap<String, Integer> orderList = makeOrder();
        validateOrderedMenu.validateOrder(orderList);
        return orderList;
    }

    public HashMap<String, Integer> makeOrder(){
        return parsingOrderInput.orderResultList(inputView.inputOrderMenu());
    }
}
