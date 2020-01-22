package com.jun.crawler.novatec.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	public static String Cut(String text, String pattern) {
		Pattern regex = Pattern.compile(pattern);
		Matcher m = regex.matcher(text);
		
		if(m.find()) return m.group(0);
		return "";
	}
}
