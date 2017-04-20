package com.hisd.common.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public final class UtcTimeZoneConverter implements Converter<String, Date> {

	//private static final String UTC_OFFSET = "GMT+05:30";
	@Override
	public Date convert(String source) {
		String dateFormatStr = null;
		Date convertedDate = null;
		dateFormatStr = getClientDateFormat().replace("Y", "y").replace("D", "d")/*.replace("MMM", "MM")*/;
		if(source.contains(":")) {
			dateFormatStr += " HH:mm";
		}
		try{
			/*SimpleDateFormat dbDateFormat = new SimpleDateFormat(dateFormatStr);
			dbDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"+getUserTimeZone()));
			Date date = dbDateFormat.parse(source);

			SimpleDateFormat clientDateFormat = new SimpleDateFormat(dateFormatStr);
			clientDateFormat.setTimeZone(TimeZone.getTimeZone(UTC_OFFSET));
			String formatedDate = clientDateFormat.format(date);
			
			clientDateFormat.setTimeZone(TimeZone.getTimeZone(UTC_OFFSET));
			TimeZone.setDefault(TimeZone.getTimeZone(UTC_OFFSET));*/
			SimpleDateFormat clientDateFormat = new SimpleDateFormat(dateFormatStr);
			convertedDate = clientDateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return convertedDate;
	}
	
	private String getClientDateFormat() {
		String dateFormat = "";
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Cookie[] cookies = attr.getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("dateFormat".equals(cookie.getName())) {
                    dateFormat = cookie.getValue();
                }
            }
        }
        if(!StringUtils.hasLength(dateFormat)){
        	dateFormat = "dd/MM/yyyy";
        }
        return dateFormat;
    }
	
	private String getUserTimeZone() {
		String timeZoneOffset = "";
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        if (session != null) {
        	SessionBean sessionBean = (SessionBean) session.getAttribute("sessionObject");
        	if(sessionBean != null) {
        		timeZoneOffset = sessionBean.getTimeZoneOffset();
        	}
        }
        return timeZoneOffset;
    }
}
