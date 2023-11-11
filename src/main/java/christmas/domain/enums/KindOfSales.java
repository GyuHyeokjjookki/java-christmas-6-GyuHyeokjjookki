package christmas.domain.enums;

public enum KindOfSales {
    CHRISTMAS("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    PRESENT("증정 이벤트");

    private final String salse;

    KindOfSales(String sales){
        this.salse = sales;
    }

    public String getSales() {
        return salse;
    }
}
