package com.zuikc.utils;

import javax.servlet.http.Cookie;

/**
 * 根据name查找指定cookie
 */
public class CookieUtils {
	// 工具方法
	public static Cookie findCookie(Cookie[] cookies, String name) {
		if (cookies == null) {
			return null;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
			return null;
		}
	}
}

