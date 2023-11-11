package christmas.controller;

import christmas.domain.CalculatePrice;
import christmas.domain.CalculateSales;
import christmas.domain.SettingVisitDay;
import christmas.domain.OrderMenu;
import christmas.domain.EventBadge;
import christmas.domain.CalculatePresentSale;
import christmas.view.OutputView;

import java.util.HashMap;

public class ChristmasEventController {
    CalculatePrice calculatePrice = new CalculatePrice();
    CalculateSales calculateSales = new CalculateSales();
    SettingVisitDay settingVisitDay = new SettingVisitDay();
    OrderMenu orderMenu = new OrderMenu();
    EventBadge eventBadge = new EventBadge();
    CalculatePresentSale calculatePresentSale = new CalculatePresentSale();
    OutputView outputView = new OutputView();

    private static int day;
    private static HashMap<String, Integer> orderList = new HashMap<>();
    private static int total;
    private int totalSale;

    private static final String intro = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String aboutSale = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public void run(){
        setVisitDay();
        setOrdering();
        outputView.displayMenuList(orderList);
        setTotalPrice();
        setTotalSale();
        setPresent();
        setSaleList();
        outputView.displayTotalSale(totalSale);
        afterSalePrice();
        setEventBadge();
    }

    private void setEventBadge(){
        String badge = eventBadge.determineBadge(totalSale);
        outputView.displayBadge(badge);
    }

    private void afterSalePrice(){
        int afterSale = calculateSales.applySalesPrice(day,total,orderList);
        outputView.displayAfterSale(afterSale);
    }

    private void setTotalSale(){
        totalSale = calculateSales.calculateSalesPrice(day, total, orderList);
    }

    private void setSaleList(){
        outputView.displaySaleList(calculateSales.getSaleList());
    }

    private void setPresent(){
        outputView.displayPresent(calculatePresentSale.getPresent(total));
    }

    private void setTotalPrice(){
        total = calculatePrice.calculateTotalPrice(orderList);
        outputView.displayTotalPrice(total);
    }

    private void setOrdering(){
        makeOrdering();
        System.out.println(aboutSale);
        System.out.println();
    }

    private void makeOrdering(){
        try{
            orderList = orderMenu.setOrderList();
        } catch (IllegalArgumentException e){
            outputView.displayErrorMessage(e);
            setOrdering();
        }
    }

    private void setVisitDay(){
        System.out.println(intro);
        makeVisitDay();
    }

    private void makeVisitDay(){
        try{
            day = settingVisitDay.setVisitDay();
        } catch (IllegalArgumentException e){
            outputView.displayErrorMessage(e);
            makeVisitDay();
        }
    }

}
