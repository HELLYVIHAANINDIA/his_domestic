/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.common.utility;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hisd.common.services.ExceptionHandlerService;

public class CommonUtility {
	
	@Autowired
	private static ExceptionHandlerService exceptionHandlerService;
	
    public static String indianCurrencyFormat(double value, int acceptDecimalUpto, boolean isRoundUp, boolean isNationalCurr) {
        DecimalFormat formatter = null;
        switch (acceptDecimalUpto) {
            case 1:
                formatter = new DecimalFormat("0.0");
                break;
            case 2:
                formatter = new DecimalFormat("0.00");
                break;
            case 3:
                formatter = new DecimalFormat("0.000");
                break;
            case 4:
                formatter = new DecimalFormat("0.0000");
                break;
            case 5:
                formatter = new DecimalFormat("0.00000");
                break;
            default:
                formatter = new DecimalFormat("0.00000");
                break;
        }

        if (!isRoundUp) {
            formatter.setRoundingMode(RoundingMode.DOWN);
        }
        String formattedValue = formatter.format(value);
        String integral = formattedValue.replaceAll("\\D\\d++", "");
        String fraction = formattedValue.replaceAll("\\d++\\D", "");
        if (integral.length() <= 3) {
            return formattedValue;
        }

        if (isNationalCurr == true) {
            char lastDigitOfIntegral = integral.charAt(integral.length() - 1);
            integral = integral.replaceAll("\\d$", "");
            return integral.replaceAll("(?<=.)(?=(?:\\d{2})+$)", ",") + lastDigitOfIntegral + "." + fraction;

        } else {
            return integral.replaceAll("(?<=.)(?=(?:\\d{3})+$)", ",") + "." + fraction;//+lastDigitOfIntegral+"."+fraction;
        }
    }

    public static String convertTimezone(Object... source) {
        String convertedDate = null;
        try {
            String dateFormatStr = null;
            if (source.length>0 && source[0] != null) {
                if (source[0].toString().contains(":")) {
                    dateFormatStr = "yyyy-MM-dd" + " HH:mm:ss";
                } else {
                    dateFormatStr = "yyyy-MM-dd";
                }
                SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormatStr);
                dbDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
                TimeZone.setDefault(TimeZone.getTimeZone("GMT+0:00"));
                Date date = dbDateFormat.parse(source[0].toString());

                String HHMMSS = source.length > 1 ? " HH:mm" : " HH:mm:ss";
                SimpleDateFormat clientDateFormat = new SimpleDateFormat(getClientDateFormat() + HHMMSS);
                clientDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + getTimeZone()));
                convertedDate = clientDateFormat.format(date);
                /*System.out.println("date format :: " + getClientDateFormat()+" HH:mm:ss");
                 System.out.println("timezone :: " + getUserTimeZone());
                 System.out.println("converted :: " + convertedDate);*/
            }
        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);
        }

        return convertedDate;
    }
    
    public static String convertTimezoneWithMilliSec(Object... source) {
        String convertedDate = null;
        /*System.out.println("original date :: " + source.toString());*/
        try {
            String dateFormatStr = null;
            if (source.length>0 && source[0] != null) {
                if (source[0].toString().contains(":")) {
                    dateFormatStr = "yyyy-MM-dd" + " HH:mm:ss.SSS";
                } else {
                    dateFormatStr = "yyyy-MM-dd";
                }
                SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormatStr);
                dbDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
                TimeZone.setDefault(TimeZone.getTimeZone("GMT+0:00"));
                Date date = dbDateFormat.parse(source[0].toString());

                String HHMMSS = source.length > 1 ? " HH:mm" : " HH:mm:ss.SSS";
                SimpleDateFormat clientDateFormat = new SimpleDateFormat(getClientDateFormat() + HHMMSS);
                clientDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + getTimeZone()));
                convertedDate = clientDateFormat.format(date);
                /*System.out.println("date format :: " + getClientDateFormat()+" HH:mm:ss.SSS");
                 System.out.println("timezone :: " + getUserTimeZone());
                 System.out.println("converted :: " + convertedDate);*/
            }
        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);
        }

        return convertedDate;
    }

    public static String convertTimezone(Object source,String timeFormat) {
        String convertedDate = null;
        /*System.out.println("original date :: " + source.toString());*/
        try {
            String dateFormatStr = null;
            if (source != null) {
                if (source.toString().contains(":")) {
                    dateFormatStr = "yyyy-MM-dd" + " HH:mm:ss";
                } else {
                    dateFormatStr = "yyyy-MM-dd";
                }
                SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormatStr);
                dbDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
                TimeZone.setDefault(TimeZone.getTimeZone("GMT+0:00"));
                Date date = dbDateFormat.parse(source.toString());

                SimpleDateFormat clientDateFormat = new SimpleDateFormat(timeFormat + " HH:mm:ss");
                clientDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + getTimeZone()));
                convertedDate = clientDateFormat.format(date);
            }
        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);
        }

        return convertedDate;
    }
    public static String convertTimezoneToClientTimezone(Object source) {
        String convertedDate = null;
        try {
            String dateFormatStr = null;
            SimpleDateFormat clientDateFormat=null;
            if (source != null) {
                if (source.toString().contains(":")) {
                    dateFormatStr = "yyyy-MM-dd" + " HH:mm:ss";
                    clientDateFormat = new SimpleDateFormat(getClientDateFormat() + " HH:mm:ss");
                } else {
                    dateFormatStr = "yyyy-MM-dd";
                    clientDateFormat = new SimpleDateFormat(getClientDateFormat());
                }
                SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormatStr);
                dbDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
                TimeZone.setDefault(TimeZone.getTimeZone("GMT+0:00"));
                Date date = dbDateFormat.parse(source.toString());

                clientDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + getTimeZone()));
                convertedDate = clientDateFormat.format(date);
            }
        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);
        }

        return convertedDate;
    }

    public static int lastIndexOf(String text, String searchString) {
        return text.lastIndexOf(searchString);
    }
 
    
    public static String convertUtcTimezone(Object source) {
        String convertedDate = null;
        try {
            String dateFormatStr = null;
            if (source != null) {
                if (source.toString().contains(":")) {
                    dateFormatStr = getClientDateFormat().replace("Y", "y").replace("D", "d") + " HH:mm";
                } else {
                    dateFormatStr = getClientDateFormat().replace("Y", "y").replace("D", "d");
                }
                SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormatStr);
                dbDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + getTimeZone()));
                TimeZone.setDefault(TimeZone.getTimeZone("GMT" + getTimeZone()));
                Date date = dbDateFormat.parse(source.toString());

                SimpleDateFormat clientDateFormat = new SimpleDateFormat("yyyy-MM-dd" + " HH:mm:ss");
                clientDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
                convertedDate = clientDateFormat.format(date);
            }
        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);
        }

        return convertedDate;
    }
    
    public static Date converTotUtcTimezone(Object source) {
        Date convertedDate = null;
        try {
            String dateFormatStr = null;
            if (source != null) {
                if (source.toString().contains(":")) {
                    dateFormatStr = getClientDateFormat().replace("Y", "y").replace("D", "d") + " HH:mm";
                } else {
                    dateFormatStr = getClientDateFormat().replace("Y", "y").replace("D", "d");
                }
                SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormatStr);
                dbDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + getTimeZone()));
                TimeZone.setDefault(TimeZone.getTimeZone("GMT+00:00"));
                Date date = dbDateFormat.parse(source.toString());
                SimpleDateFormat clientDateFormat = new SimpleDateFormat("yyyy-MM-dd" + " HH:mm:ss");
                clientDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
                String tempconvertedDate = clientDateFormat.format(date);
                convertedDate=clientDateFormat.parse(tempconvertedDate);
            }
        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);
        }

        return convertedDate;
    }
    
    public static Date getDateObj(Object source) {
        Date retDate=null;
        try {
            String dateFormatStr = null;
            if (source != null) {
                if (source.toString().contains(":")) {
                    dateFormatStr = getClientDateFormat().replace("Y", "y").replace("D", "d") + " HH:mm";
                } else {
                    dateFormatStr = getClientDateFormat().replace("Y", "y").replace("D", "d");
                }
                SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormatStr);
                retDate = dbDateFormat.parse(source.toString());
            }
        } catch (Exception e) {
        	
        	exceptionHandlerService.writeLog(e);
            
        }
        return retDate;
    }

    public static String getClientDateFormat() {
        String dateFormat = null;
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Cookie[] cookies = attr.getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("dateFormat".equals(cookie.getName())) {
                    dateFormat = cookie.getValue();
                    dateFormat = dateFormat.replace("YYYY", "yyyy").replace("DD", "dd");
                }
            }
        }
        if(dateFormat == null){
        	dateFormat ="DD MMM YYYY";
        	dateFormat = dateFormat.replace("YYYY", "yyyy").replace("DD", "dd");
        }
        return dateFormat;
    }

    public static String getTimeZone() {       
        return "+5:30";
    }

    public static boolean showLink(String linkId) {        
        return true;
    }

    private static HttpServletRequest getServletRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }
    
    public static String strToHex(String str){
    	String hexStr = "";
    	if(str.length() > 0){
    		byte[] bytes = str.getBytes();
    		BigInteger bigInt = new BigInteger(bytes);
    		hexStr = bigInt.toString(16);	
    	}
    	return hexStr; 
    }
    
    public static String checkNull(String value) {
        if (StringUtils.hasLength(value)) {
            return value;
        } else {
            return "";
        }
    }
    
    public static int checkValue(String value) {
        if (StringUtils.hasLength(value)) {
            return Integer.parseInt(value);
        } else {
            return 0;
        }
    }

}

