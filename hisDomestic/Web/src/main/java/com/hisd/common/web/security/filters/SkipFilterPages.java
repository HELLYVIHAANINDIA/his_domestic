package com.hisd.common.web.security.filters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class SkipFilterPages {    
    
	@Value("#{projectProperties['contextName']}")
	public static String contextName;
	
    private static final List<String> lst;    
    static {
            lst = new ArrayList<String>();
            lst.add("/"+contextName+"/");
            lst.add("/pagenotfound");
 }
    public static List<String> getSkipPages() {        
        return lst;
    }
}
