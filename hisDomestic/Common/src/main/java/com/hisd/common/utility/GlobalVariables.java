package com.hisd.common.utility;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.http.HttpSession;

public class GlobalVariables {
    public static final Map<String,HttpSession> sessions = Collections.synchronizedMap(new WeakHashMap<String, HttpSession>());
}
