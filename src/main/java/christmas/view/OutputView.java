package christmas.view;

import java.util.HashMap;
import java.util.Map;

import static christmas.consts.ConstValue.SPLIT_INTEGER;
import static christmas.consts.ConstValue.ZERO;
import static christmas.consts.ConstValue.NONE;

public class OutputView {

    private final String givenPresent = "<증정 메뉴>";
    private final String givenPresentCount = " 1개";
    private final String beforeSale = "<할인 전 총주문 금액>";
    private final String beforeSalePrint = "%d,%03d원";
    private final String infoSales = "<혜택 내역>";
    private final String infoSalesPrint = "%s: -%d,%03d원";
    private final String orderedMenu = "<주문 메뉴>";
    private final String orderedMenuPrint = "%s %d개";
    private final String totalSale = "<총혜택 금액>";
    private final String totalSalePrint = "-%d,%03d원";
    private final String afterSalePrice = "<할인 후 예상 결제 금액>";
    private final String afterSalePrint = "%d,%d원";
    private final String eventBadge = "<12월 이벤트 배지>";

    public void displayPresent(String present){
        System.out.println(givenPresent);
        if(present != NONE){
            System.out.println(present + givenPresentCount);
            System.out.println();
        }
        if(present == NONE){
            System.out.println(NONE);
            System.out.println();
        }
    }

    public void displayTotalPrice(int price){
        System.out.println(beforeSale);
        System.out.printf(beforeSalePrint, price / SPLIT_INTEGER, price % SPLIT_INTEGER);
        System.out.println();
        System.out.println();
    }

    public void displaySaleList(HashMap<String,Integer> saleList){
        System.out.println(infoSales);
        if(saleList.size() != ZERO){
            for(Map.Entry<String,Integer> item : saleList.entrySet()){
                System.out.printf(infoSalesPrint, item.getKey(), item.getValue() / SPLIT_INTEGER, item.getValue() % SPLIT_INTEGER);
                System.out.println();
            }
        }
        if(saleList.isEmpty()){
            System.out.println(NONE);
        }
        System.out.println();
    }

    public void displayMenuList(HashMap<String,Integer> orderList){
        System.out.println(orderedMenu);
        for(Map.Entry<String,Integer> item : orderList.entrySet()){
            System.out.printf(orderedMenuPrint, item.getKey(), item.getValue());
            System.out.println();
        }
        System.out.println();
    }

    public void displayTotalSale(int price){
        System.out.println(totalSale);
        if(price != ZERO){
            System.out.printf(totalSalePrint, price / SPLIT_INTEGER, price % SPLIT_INTEGER);
            System.out.println();
            System.out.println();
        }
        if(price == ZERO){
            System.out.println(NONE);
            System.out.println();
        }
    }

    public void displayAfterSale(int price){
        System.out.println(afterSalePrice);
        System.out.printf(afterSalePrint,price / SPLIT_INTEGER, price % SPLIT_INTEGER);
        System.out.println();
        System.out.println();
    }

    public void displayBadge(String badge){
        System.out.println(eventBadge);
        System.out.println(badge);
        System.out.println();
    }

    public void displayErrorMessage(Exception e){
        System.out.println(e.getMessage());
    }
}
