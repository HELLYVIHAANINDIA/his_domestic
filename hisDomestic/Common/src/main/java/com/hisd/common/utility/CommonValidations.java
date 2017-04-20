package com.hisd.common.utility;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisd.common.services.CommonService;
import org.springframework.stereotype.Component;

@Component
public class CommonValidations {

    @Autowired
    private CommonService commonService;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9\\-\\_]+(\\.[A-Za-z0-9\\-\\_]+)*(\\.[A-Za-z0-9\\-\\_]{2,})$";
    // private static final String NUMER_PATTERN="^\\d*$";
    private static final String NUMER_PATTERN = "\\d+(\\.\\d{1,12})?";
    private static final String ALPHA_PATTERN = "^^[a-z A-Z]+$";
    private static final String ALPHA_NUMERIC_PATTERN = "^[a-z A-Z0-9]+$";
    //website
    private static final String WEBSITE = "^(http(s)?:\\//)?([a-zA-Z0-9_\\-]+([\\-\\.]{1}[a-zA-Z0-9_\\-]+)(?:\\.[a-zA-Z0-9_\\-]+)*\\.[a-zA-Z]{2,4}(?:\\/[a-zA-Z0-9_]+)*(?:\\/[a-zA-Z0-9_]+\\.[a-zA-Z]{2,4}(?:\\?[a-zA-Z0-9_]+\\=[a-zA-Z0-9_]+)?)?(?:\\&[a-zA-Z0-9_]+\\=[a-zA-Z0-9_]+)*)$";
    //alphanumspecial  	:Alphanumeric and Special Characters (@,*, (,), -, +,/,., Space and ,)
    private static final String ALPHA_NUMERIC_SPECIAL = "^([0-9a-zA-Z\\@\\*\\(\\)\\-\\+\\.\\s\\/\\,\\#\\&\\;]*)[a-zA-Z]+([0-9a-zA-Z\\@\\*\\(\\)\\-\\+\\.\\s\\/\\,\\#\\&\\;]*)$";
    //fullname    :characters and Special character (’,- , .,Space)
    private static final String FULLNAME = "^([a-zA-Z\\'\\-\\.\\s\\ \\ ]*)[a-zA-Z\\ \\ ]+([a-zA-Z\\'\\-\\.\\s\\ \\ ]*)$"; // Changes Bug Id:#29306 (( \\ \\ )Added Two space in RegEx First for copying excel space and second For Normal keyboard space)
    //companyname   :Alphanumeric and Special character (’,- , ., &, (, ), Space)
    private static final String COMPANYNAME = "^([0-9a-zA-Z\\-\\.\\&\\(\\)\\s]*)[a-zA-Z]+([0-9a-zA-Z\\-\\.\\&\\(\\)\\s]*)$"; //Changes Bug Id:#30329
    //city	  :alphabats and only space
    private static final String CITY = "^[a-zA-Z ]*$";
    //phoneno  	:numbers and Special Characters (-,+)
    private static final String PHONENO = "^((\\+){0,1}[0-9][0-9](\\s){0,1}(\\-){0,1}(\\s){0,1}){0,1}[0-9]+(\\s){0,1}(\\-){0,1}(\\s){0,1}[0-9]+$";
    //keyword  :characters and Special Characters (, Space)

  //  private static final String KEYWORD = "^([a-zA-Z\\s]*)[a-zA-Z\\,]+([a-zA-Z\\s]*)$";
    //Added by urja 
    //private static final String KEYWORD = "([a-zA-Z0-9\\,\\s]*)[a-zA-Z0-9\\s]+([a-zA-Z0-9&\\-\\,\\/\\.\\s]*)";   //characters-numbers and Special Characters (/ , - , ., &, Space)
    private static final String KEYWORD = "([a-zA-Z0-9\\,\\s]*)[a-zA-Z0-9\\s]+([a-zA-Z0-9&\\-\\#\\;\\,\\/\\.\\s]*)";   //Add # and ; 
  
    //upto decimal
    private static final String UPTODECIMAL = "^[0-9]+(\\.([0-9]{0,decimal})?)?$";
    //brif :Alphanumeric and special characher  (- , ., /, Space)
    //private static final String BRIEF = "^([0-9a-zA-Z\\'\\-\\_\\&\\(\\)\\:\\+\\.\\,\\/\\s]*)[0-9a-zA-Z\\'\\-\\_\\&\\(\\)\\:\\+\\.\\,\\/\\s]+([0-9a-zA-Z\\'\\-\\_\\&\\(\\)\\:\\+\\.\\,\\/\\s]*)$";    //characters-numbers and Special Characters (()_:&,+, /, -, ., Space)
    private static final String BRIEF = "^([0-9a-zA-Z\\'\\-\\_\\&\\(\\)\\:\\+\\.\\,\\/\\#\\;\\s]*)[0-9a-zA-Z\\'\\-\\_\\&\\(\\)\\:\\+\\.\\,\\/\\#\\;\\s]+([0-9a-zA-Z\\'\\-\\_\\&\\(\\)\\:\\+\\.\\,\\/\\#\\;\\s]*)$";    //characters-numbers and Special Characters (()_:&,+, /, -, ., Space)
    //private static final String TENDERBRIEF = "^([0-9a-zA-Z\\(\\)\\+\\-\\.\\/\\s]*)[0-9a-zA-Z\\(\\)\\+\\-\\.\\/\\s]+([0-9a-zA-Z\\(\\)\\+\\-\\.\\/\\s]*)$";
    //private static final String TENDERBRIEF = "^([0-9a-zA-Z\\_\\:\\(\\)((\\+)|(&#43;))((\\-)|(&#45;))\\.\\/\\&\\,\\s]*)[0-9a-zA-Z\\_\\:\\(\\)((\\+)|(&#43;))((\\-)|(&#45;))\\.\\/\\&\\,\\s]+([0-9a-zA-Z\\_\\:\\(\\)((\\+)|(&#43;))((\\-)|(&#45;))\\.\\/\\&\\,\\s]*)$";
    private static final String TENDERBRIEF = "^([0-9a-zA-Z\\#\\;\\_\\:\\(\\)\\+\\-\\.\\/\\&\\,\\s]*)[0-9a-zA-Z\\#\\;\\_\\:\\(\\)\\+\\-\\.\\/\\&\\,\\s]+([0-9a-zA-Z\\#\\;\\_\\:\\(\\)\\+\\-\\.\\/\\&\\,\\s]*)$";
    //private static final String TENDERKEYWORD = "^([0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\/\\,\\s]*)[0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\,\\/\\s]+([0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\,\\/\\s]*)$";
    private static final String TENDERKEYWORD = "^([0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\/\\,\\#\\;\\s]*)[0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\,\\/\\#\\;\\s]+([0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\,\\/\\#\\;\\s]*)$";
    //private static final String COMMONKEYWORD = "^([0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\/\\&\\,\\s]*)[0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\&\\,\\/\\s]+([0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\&\\,\\/\\s]*)$";
    private static final String COMMONKEYWORD = "^([0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\/\\&\\,\\#\\;\\s]*)[0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\&\\,\\/\\#\\;\\s]+([0-9a-zA-Z\\@\\*\\(\\)\\+\\-\\.\\&\\,\\/\\#\\;\\s]*)$";
    private static final String DIGITS = "\\d+";
    private static final String ALLMONEY = "^-?[0-9]+(.?[0-9]{0,5})?$";
   
    /**
     * Method use for password match.
     *
     * @param password
     * @param confPassword
     * @return
     */
    public boolean passwordMatch(String password, String confPassword) {
        return password.equals(confPassword);
    }

    /**
     * Method user for maximum length validation.
     *
     * @param val
     * @param length
     * @return
     */
    public boolean validateLength(String val, int length) {
        boolean flag = false;
        if (val != null && val.length() <= length) {
            flag = true;
        }
        return flag;
    }

    /**
     * Method use for validate value length range.
     *
     * @param val
     * @param min
     * @param max
     * @return
     */
    public boolean rangeLengthValidation(String val, int min, int max) {
        boolean flag = false;
        if (val != null && val.length() >= min && val.length() <= max) {
            flag = true;
        }
        return flag;
    }

    /**
     * Method use for validate value between given range.
     *
     * @param val
     * @param min
     * @param max
     * @return
     */
    public boolean rangeValidation(int val, int min, int max) {
        boolean flag = false;
        if (val >= min && val <= max) {
            flag = true;
        }
        return flag;
    }

    /**
     * Method use for check value only numeric value.
     *
     * @param val
     * @return
     */
    public boolean isNumeric(String val) {
        Pattern p = Pattern.compile(NUMER_PATTERN);
        Matcher matcher = p.matcher(val);
//                System.out.println("value :: "+val+",matches :: "+matcher.matches());
        return matcher.matches();
    }

    /**
     * Method use for check value is not blank.
     *
     * @param val
     * @return
     */
    public boolean isNotBlank(String val) {
        return (val != null && !"".equalsIgnoreCase(val.trim()));
    }

    /**
     * Method use for validate for valid email id.
     *
     * @param val
     * @return
     */
    public boolean isValidEmailId(String val) {
        Pattern p = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method use for validate Website Address.
     *
     * @param val
     * @return
     */
    public boolean isValidWebAddress(String val) {
        Pattern p = Pattern.compile(WEBSITE);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method use for check value contains only Alphabets.
     *
     * @param val
     * @return
     */
    public boolean isOnlyAlpha(String val) {
        Pattern p = Pattern.compile(ALPHA_PATTERN);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method use for check value contains only AlphaNumeric.
     *
     * @param val
     * @return
     */
    public boolean isOnlyAlphaNumeric(String val) {
        Pattern p = Pattern.compile(ALPHA_NUMERIC_PATTERN);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method checks whether value contains Alphanumeric and special characters.
     *
     * @param val
     * @return
     */
    public boolean isAlphaNumericSpecial(String val) {
        Pattern p = Pattern.compile(ALPHA_NUMERIC_SPECIAL);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method validates the value of fields like Full Name that can contain
     * space.
     *
     * @param val
     * @return
     */
    public boolean isFullName(String val) {
        Pattern p = Pattern.compile(FULLNAME);
        Matcher matcher = p.matcher(commonService.reverseReplaceSpecialChars(val));
        return matcher.matches();
    }

    /**
     * Method validates the value of fields like Company Name that can contain
     * space, numbers and special characters like & also.
     *
     * @param val
     * @return
     */
    public boolean isCompanyName(String val) {
        Pattern p = Pattern.compile(COMPANYNAME);
        Matcher matcher = p.matcher(commonService.reverseReplaceSpecialChars(val));
        return matcher.matches();
    }

    /**
     * Method validates the value of fields like City that can contain space,
     * numbers and special characters like & also.
     *
     * @param val
     * @return
     */
    public boolean isCity(String val) {
        Pattern p = Pattern.compile(CITY);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method validates the value of fields Phone No that can contain numbers
     * and Special Characters (-,+).
     *
     * @param val
     * @return
     */
    public boolean isPhoneNo(String val) {
        Pattern p = Pattern.compile(PHONENO);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method validates the value of fields Keyword that can contain words with
     * comma separated values.
     *
     * @param val
     * @return
     */
    public boolean isKeyword(String val) {
        Pattern p = Pattern.compile(KEYWORD);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method validates the value of fields like it have allow upto decimal.
     *
     * @param val
     * @param decimal
     * @return
     */
    public boolean isUptoDecimal(String val, int decimal) {
        String uptoDecimal = UPTODECIMAL.replace("decimal", Integer.toString(decimal));
        Pattern p = Pattern.compile(uptoDecimal);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    /**
     * Method validates the value of fields like brief and detail of auction
     * that can contain space, numbers and special characters like & also.
     *
     * @param val
     * @return
     */
    public boolean isBrief(String val) {
        Pattern p = Pattern.compile(BRIEF);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }
    
    public boolean isTenderBrief(String val) {
        Pattern p = Pattern.compile(TENDERBRIEF);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }

    public boolean isTenderKeyword(String val) {
        Pattern p = Pattern.compile(TENDERKEYWORD);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }
    public boolean isCommonKeyword(String val) {
        Pattern p = Pattern.compile(COMMONKEYWORD);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }
    public int compareTwoVal(String val1, String val2) {
        BigDecimal bg1 = new BigDecimal(val1);
        BigDecimal bg2 = new BigDecimal(val2);
        return bg1.compareTo(bg2);
    }

    public int compareWithSysDate(Date date) throws Exception {
        Date sysDate = commonService.getServerDateTime();
        return sysDate.compareTo(date);
    }
    

    /**
     * Method compare two date
     *
     * @param date1
     * @param date2
     * @return
     */
    public int compareTwoDate(Date date1, Date date2) {
        return date1.compareTo(date2);
    }

    /**
     * Method validates the value of fields only positive number
     *
     * @param val
     * @return
     */
    public boolean isDigits(String val) {
        Pattern p = Pattern.compile(DIGITS);
        Matcher matcher = p.matcher(val);
        return matcher.matches();
    }
    
    public boolean isAllMoney(String val){
    	Pattern p = Pattern.compile(ALLMONEY);
        Matcher matcher = p.matcher(val);
        return matcher.matches();    	
    }
}
