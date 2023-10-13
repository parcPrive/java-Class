package com.mok.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {
	public static void createCookie(HttpServletResponse response, 
			String cookieName, 
			String cookieValue, 
			int time) {
	Cookie cookie = new Cookie(cookieName, cookieValue);
	cookie.setPath("/");
	cookie.setMaxAge(time);
	response.addCookie(cookie);
	}
	public static void deleteCookie(HttpServletResponse response, 
				String cookieName) {
	createCookie(response, cookieName, "", 0);
	}
	public static String readCookie(HttpServletRequest request, String cookieName) {
	Cookie cookies [] = request.getCookies();
	String cookieValue = "";
	if(cookies!=null) {
	for(Cookie c : cookies) {
	if(c.getName().equals(cookieName)) {
	cookieValue = c.getValue();
	}
	}
	}
	return cookieValue;
}

}
