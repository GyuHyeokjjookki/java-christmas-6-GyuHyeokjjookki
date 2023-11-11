package christmas.domain.enums;

public enum ErrorMessages {
    INVALID_ORDER_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DAY_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private static final String HEAD_MESSAGE = "[ERROR] ";
    private final String message;

    ErrorMessages(String message) {
        this.message = HEAD_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
