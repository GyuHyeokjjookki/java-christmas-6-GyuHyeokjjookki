package christmas.service;

import christmas.domain.enums.ErrorMessages;

import static christmas.consts.ConstValue.FIRST_DAY;
import static christmas.consts.ConstValue.LAST_DAY;

public class ValidateVisitDay {
    public void validate(int userinput){
        isVaildRange(userinput);
    }

    private void isVaildRange(int userInput){
        if(userInput < FIRST_DAY || userInput > LAST_DAY){
            throw new IllegalArgumentException(ErrorMessages.INVALID_DAY_ERROR.getMessage());
        }
    }

    public int checkInteger(String userInput){
        try{
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.INVALID_DAY_ERROR.getMessage());
        }
    }
}
