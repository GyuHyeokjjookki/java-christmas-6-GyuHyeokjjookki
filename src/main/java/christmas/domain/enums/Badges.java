package christmas.domain.enums;

public enum Badges {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NONE("없음");

    private final String badge;

    Badges(String badge){
        this.badge = badge;
    }

    public String getBadge() {
        return badge;
    }
}
