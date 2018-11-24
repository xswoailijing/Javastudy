package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regextext {
	public static void main(String[] args) {
		String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
		String str = "service@xsoftlab.net";
		Pattern pattern=Pattern.compile("\\.[a-zA-Z0-9]{0,4}");
		
		Matcher m=pattern.matcher("45646.JPg.asd .23aa");
		boolean rs=m.find();
		String string="";
		try {
			string = m.group();
		} catch (Exception e) {
			System.err.println(e);
			// TODO: handle exception
		}
		System.err.println(rs);
		 System.err.println(string);
		
	}

}
