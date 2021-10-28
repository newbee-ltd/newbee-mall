package ltd.newbee.mall.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.regex.Pattern;

public class TimeUtil {

	public static boolean TimeCompare(Date start, Date end) {
		int compareTo = start.compareTo(end);
		if (compareTo >= 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isValidDate(String str) {
		boolean isValidDate = true;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
			return true;
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			isValidDate = false;
		}
		return isValidDate;

	}

	public static boolean isValidDate2(String str) {
		String date = str.substring(0, 10);
		String time = str.substring(11);
		if (isDate(date) && isTime(time)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isDate(String value) {
		boolean result = false;
		if (value != null) {
			Pattern pattern = Pattern.compile("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
			result = pattern.matcher(value).matches();
		}
		return result;
	}

	public static boolean isTime(String value) {
		boolean result = false;
		if (value != null) {
			Pattern pattern = Pattern
					.compile("^([0-1][0-9]|[2][0-3]):[0-5][0-9]$|^([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$");
			result = pattern.matcher(value).matches();
		}
		return result;
	}

//	public static boolean isDate(String value) {
//	    boolean result = false;
//	    if (value != null) {
//	        try {
//	            String checkDate = value.replace("-", "").replace("/", "");
//	            DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT).parse(checkDate, LocalDate::from);
//	            result = true;
//	        } catch (Exception e) {
//	            result = false;
//	        }
//	    }
//	    return result;
//	}

}
