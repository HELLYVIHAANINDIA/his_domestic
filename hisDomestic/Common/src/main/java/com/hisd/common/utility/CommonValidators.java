package com.hisd.common.utility;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.Errors;

@Component
public class CommonValidators {

    public static void compareWithSysDate(Date date) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Autowired
    private CommonValidations validations;
    String message = null;

    public boolean isEmpty(String val) {
        return val == null || "".equalsIgnoreCase(val);
    }

    public void isEmpty(String val, String controlName, Errors e) {
        if (val == null || "".equalsIgnoreCase(val)) {
            e.rejectValue(controlName, "msg_js_common_validations_required");
        }
    }

    public boolean passwordMatch(String password, String confPassword) {
        return validations.passwordMatch(password, confPassword);
    }

    public void passwordMatch(String password, String confPassword, String controlName, Errors e) {
        if (!validations.passwordMatch(password, confPassword)) {
            e.rejectValue(controlName, "message.passwordmatch");
        }
    }

    public boolean validateLength(String val, int length) {
        return validations.validateLength(val, length);
    }

    public void validateLength(String val, int length, String controlName, Errors e) {
        if (!validations.validateLength(val, length)) {
            Integer[] obj = new Integer[1];
            obj[0] = length;
            e.rejectValue(controlName, "msg_for_length_validatechar", obj, null);
        }
    }

    public void validateLengthDecimal(String val, int length, String controlName, Errors e) {
        if (!validations.validateLength(val, length)) {
            Integer[] obj = new Integer[1];
            obj[0] = length;
            e.rejectValue(controlName, "msg_for_length_validate", obj, null);
        }
    }

    public boolean rangeLengthValidation(String val, int min, int max) {
        return validations.rangeLengthValidation(val, min, max);
    }

    public void rangeLengthValidation(String val, int min, int max, String controlName, Errors e) {
        if (!validations.rangeLengthValidation(val, min, max)) {
            e.rejectValue(controlName, null, "Invalid Value. Value length must be between " + min + " and " + max);
        }

    }

    public boolean rangeValidation(int val, int min, int max) {
        return validations.rangeValidation(val, min, max);
    }

    public void rangeValidation(int val, int min, int max, String controlName, Errors e) {
        if (!validations.rangeValidation(val, min, max)) {
            e.rejectValue(controlName, null, "Invalid Input. Value must be between " + min + " and " + max);
        }
    }

    public boolean isNumeric(String val) {
        return validations.isNumeric(val);
    }
    
    public boolean isAllMoney(String val){
    	return validations.isAllMoney(val);
    }

    public void isNumeric(String val, String controlName, Errors e) {
        if (!validations.isNumeric(val)) {
            e.rejectValue(controlName, "msg_js_common_validations_only_numeric");
        }
    }

    public void nonZero(String val, String controlName, Errors e){
        if(Float.parseFloat(val)==0){
            e.rejectValue(controlName, "zero_value_isnot_allow");
        }
    }
    
    public boolean isNotBlank(String val) {
        return validations.isNotBlank(val);
    }

    public void isNotBlank(String val, String controlName, Errors e) {
        if (!validations.isNotBlank(val)) {
            e.rejectValue(controlName, "msg_please_enter_value");
        }
    }

    public boolean isValidEmailId(String val) {
        return validations.isValidEmailId(val);
    }

    public void isValidEmailId(String val, String controlName, Errors e) {
        if (!validations.isValidEmailId(val)) {
            e.rejectValue(controlName, "validation_email_userregistration_invalid");
        }
    }

    public boolean isValidWebAddress(String val) {
        return validations.isValidWebAddress(val);
    }

    public void isValidWebAddress(String val, String controlName, Errors e) {
        if (!validations.isValidWebAddress(val)) {
            e.rejectValue(controlName, "validation_website_invalid");
        }
    }

    public boolean isOnlyAlpha(String val) {
        return validations.isOnlyAlpha(val);
    }

    public void isOnlyAlpha(String val, String controlName, Errors e) {
        if (!validations.isOnlyAlpha(val)) {
            e.rejectValue(controlName, "msg_js_common_validations_only_alphabets");
        }
    }

    public boolean isOnlyAlphaNumeric(String val) {
        return validations.isOnlyAlphaNumeric(val);
    }

    public void isOnlyAlphaNumeric(String val, String controlName, Errors e) {
        if (!validations.isOnlyAlphaNumeric(val)) {
            e.rejectValue(controlName, "msg_allow_only_alphanumeric");
        }
    }

    public boolean isAlphaNumericSpecial(String val) {
        return validations.isAlphaNumericSpecial(val);
    }

    public void isAlphaNumericSpecial(String val, String controlName, Errors e) {
        if (!validations.isAlphaNumericSpecial(val)) {
            e.rejectValue(controlName, "validation_addrerss_invalid");
        }
    }

    public boolean isFullName(String val) {
        return validations.isFullName(val);
    }

    public void isFullName(String val, String controlName, Errors e) {
        if (!validations.isFullName(val)) {
            e.rejectValue(controlName, "msg_js_common_validations_alpha_num_special");
        }
    }

    public boolean isCompanyName(String val) {
        return validations.isCompanyName(val);
    }

    public void isCompanyName(String val, String controlName, Errors e) {
        if (!validations.isCompanyName(val)) {
            e.rejectValue(controlName, "validation_companyname_invalid"); //Properties field name incorrect Changes Bug Id:#30329 
        }
    }

    public boolean isCity(String val) {
        return validations.isCity(val);
    }

    public void isCity(String val, String controlName, Errors e) {
        if (!validations.isCity(val)) {
            e.rejectValue(controlName, "validation_city_invalid");
        }
    }

    public boolean isPhoneNo(String val) {
        return validations.isPhoneNo(val);
    }

    public void isPhoneNo(String val, String controlName, Errors e) {
        if (!validations.isPhoneNo(val)) {
            e.rejectValue(controlName, "validation_phone_invalid");
        }
    }

    public boolean isKeyword(String val) {
        return validations.isKeyword(val);
    }

    public void isKeyword(String val, String controlName, Errors e) {
        if (!validations.isKeyword(val)) {
            e.rejectValue(controlName, "msg_validations_common_keyword");
        }
    }
     public void isTenderKeyword(String val, String controlName,int length, Errors e) {
        if (!validations.isTenderKeyword(val)) {
            e.rejectValue(controlName, "msg_js_common_validations_keyword");
        }else if(length>1000){
            e.rejectValue(controlName, "tender_keywordlength_validate");
        }
    }
     public void isCommonKeyword(String val, String controlName,int length, Errors e) {
         if (!validations.isCommonKeyword(val)) {
             e.rejectValue(controlName, "msg_validations_common_keyword");
         }else if(length>1000){
             e.rejectValue(controlName, "tender_keywordlength_validate");
         }
     }

    public void isUptoDecimal(String val, int decimal, String controlName, Errors e) {
        if (!validations.isUptoDecimal(val, decimal)) {
            Integer[] obj = new Integer[1];
            obj[0] = decimal;
            e.rejectValue(controlName, "msg_js_common_validations_upto_decimal", obj, null);
        }
    }

    public int compareTwoValue(String val1, String val2) {
        return validations.compareTwoVal(val1, val2);
    }

    public int compareWithSystemDate(Date date) throws Exception {
        return validations.compareWithSysDate(date);
    }

    public int compareTwoDate(Date date1, Date date2) throws Exception {
        return validations.compareTwoDate(date1, date2);
    }

    public void isTenderBrief(String str, String controlName, int length, Errors e) {
        if (!validations.isTenderBrief(str)) {
            Integer[] obj = new Integer[1];
            obj[0] = length;
            e.rejectValue(controlName, "msg_allow_tenderbrf", obj, null);
        }
    }

    public void isBrief(String str, String controlName, int length, Errors e) {
        if (!validations.isBrief(str)) {
            Integer[] obj = new Integer[1];
            obj[0] = length;
            e.rejectValue(controlName, "msg_allow_brief", obj, null);
        }
    }

    public void isDigits(String val, String controlName, Errors e) {
        if (!validations.isDigits(val)) {
            e.rejectValue(controlName, "msg_js_common_validations_only_positive_1");
        }
    }

    public boolean isDigits(String val){
        return validations.isDigits(val);
    }
    
    public boolean isUptoDecimal(String val, int decimal) {
        return validations.isUptoDecimal(val, decimal);
    }

    public void isPercentage(String val, String controlName, Errors e) {
        if (Float.parseFloat(val) > 100 || Float.parseFloat(val) <= 0) {
            e.rejectValue(controlName, "msg_incdecper_validate1");
        }
    }
}