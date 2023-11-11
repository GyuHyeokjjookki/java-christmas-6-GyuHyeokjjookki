package christmas.domain;

import christmas.domain.enums.SpecialSaleDay;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static christmas.consts.ConstValue.SPECIAL_SALES;
import static christmas.consts.ConstValue.ZERO;

public class CalculateSpecialDay {
    private List<Integer> specialDay = new ArrayList<>();

    public int calculateSpecialSale(int day){
        int sale = ZERO;
        if(checkSpecialSales(day)){
            return SPECIAL_SALES;
        }
        return sale;
    }

    private boolean checkSpecialSales(int day){
        return getSpecialDayInt(getSpecialDays()).contains(day);
    }

    private List<Integer> getSpecialDayInt(List<String> dayList){
        for(String day : dayList){
            specialDay.add(SpecialSaleDay.valueOf(day).getDay());
        }
        return specialDay;
    }

    private List<String> getSpecialDays(){
        return Stream.of(SpecialSaleDay.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
