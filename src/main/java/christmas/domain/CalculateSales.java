package christmas.domain;

import christmas.domain.enums.KindOfSales;


import java.util.HashMap;

import static christmas.consts.ConstValue.ZERO;
import static christmas.consts.ConstValue.MIN_BASE_SALE_PRICE;

public class CalculateSales {
    ChristmasSale christmasSale = new ChristmasSale();
    CalculateWeekDaySale calculateWeekDaySale = new CalculateWeekDaySale();
    CalculateWeekendSale calculateWeekendSale = new CalculateWeekendSale();
    CalculateSpecialDay calculateSpecialDay = new CalculateSpecialDay();
    CalculatePresentSale calculatePresentSale = new CalculatePresentSale();
    private HashMap<String,Integer> saleList = new HashMap<>();
    public int calculateSalesPrice(int day, int price, HashMap<String,Integer> orderList){
        int totalSale = ZERO;

        if(checkSales(price)) {
            int presentSale = calculatePresentSale.calculatePresentPrice(price);
            if(presentSale > ZERO){
                saleList.put(KindOfSales.PRESENT.getSales(),presentSale);
                totalSale += presentSale;
            }

            int christmas = christmasSale.calculateChristmasSale(day);
            if(christmas > ZERO){
                saleList.put(KindOfSales.CHRISTMAS.getSales(),christmas);
                totalSale += christmas;
            }

            int weekendSale = calculateWeekendSale.calculateWeekendSales(day,orderList);
            if(weekendSale > ZERO){
                saleList.put(KindOfSales.WEEKEND.getSales(),weekendSale);
                totalSale += weekendSale;
            }

            int weekday = calculateWeekDaySale.calculateWeekDaySales(day,orderList);
            if(weekday > ZERO){
                saleList.put(KindOfSales.WEEKDAY.getSales(),weekday);
                totalSale += weekday;
            }

            int special = calculateSpecialDay.calculateSpecialSale(day);
            if(special > ZERO){
                saleList.put(KindOfSales.SPECIAL.getSales(),special);
                totalSale += special;
            }
        }
        return totalSale;
    }

    public HashMap<String,Integer> getSaleList(){
        return saleList;
    }

    public int applySalesPrice(int day, int price, HashMap<String,Integer> orderList){
        return (price - calculateSalesPrice(day,price,orderList) + calculatePresentSale.calculatePresentPrice(price));
    }

    private boolean checkSales(int price){
        return price > MIN_BASE_SALE_PRICE;
    }
}
