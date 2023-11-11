package christmas.domain;

import christmas.service.ValidateVisitDay;
import christmas.view.InputView;

public class SettingVisitDay {
    InputView inputView = new InputView();
    ValidateVisitDay validateVisitDay = new ValidateVisitDay();

    public int setVisitDay(){
        String visitDay = inputView.inputVisitDay();
        int visitDayInteger = validateVisitDay.checkInteger(visitDay);
        validateVisitDay.validate(visitDayInteger);
        return visitDayInteger;
    }
}
