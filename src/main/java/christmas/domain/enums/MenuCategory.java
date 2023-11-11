package christmas.domain.enums;

public enum MenuCategory {
    양송이수프("애피타이저"),
    타파스("애피타이저"),
    시저샐러드("애피타이저"),
    티본스테이크("메인"),
    바비큐립("메인"),
    해산물파스타("메인"),
    크리스마스파스타("메인"),
    초코케이크("디저트"),
    아이스크림("디저트"),
    제로콜라("음료"),
    레드와인("음료"),
    샴페인("음료");

    private final String category;

    MenuCategory(String category){
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
