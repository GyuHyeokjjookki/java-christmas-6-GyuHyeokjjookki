package christmas.domain.enums;

public enum SpecialSaleDay {
    DAY_3(3),
    DAY_10(10),
    DAY_17(17),
    DAY_24(24),
    DAY_25(25),
    DAY_31(31);

    private final int day;

    SpecialSaleDay(int day){
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
