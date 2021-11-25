package ltd.newbee.mall.util;

import java.util.regex.Pattern;

public class TimeFormartUtil{
  
//	public static boolean isDate (String date) {
//		boolean result = false;
//		if (date != null) {
//			Pattern pattern = Pattern.compile("^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$");
//		    result = pattern.matcher(date).matches();
//		}
//		return result; 
//	}
//	
//	public static boolean isTime (String time) {
//		boolean result = false;
//		if (time != null) {
//			Pattern pattern = Pattern.compile("^([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$");
//		    result = pattern.matcher(time).matches();
//		}
//		return result; 
//	}
	
//	public static boolean isValidDate (String date) {
//		boolean result = false;
//		if (date != null) {
//			Pattern pattern = Pattern.compile("^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])\\s([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$");
//		    result = pattern.matcher(date).matches();
//		}
//		return result;
//	}
	
	public static boolean isValidDate (String date) {
		boolean result = true;
		if (date != null) {
			Pattern pattern = Pattern.compile("^(?!([02468][1235679]|[13579][01345789])000229)"//否定先読みを行うことで、ありえないXX00年2月29日を除外する
					                                                                           //うるう年となる条件は以下の通り。
                                                                                               //年が4で割り切れる年はうるうただし、年が100で割り切れる年はうるう年ではないただし、年が400で割り切れる年はうるう年とする
                                                                                               //これを「XX00年」に限定して言い換えると以下のようになる。
                                                                                               //千の位が偶数の時、うるう年になるのは百の位が「0,4,8」の時だけである
                                                                                               //千の位が奇数の時、うるう年になるのは百の位が「2,6」の時だけである
                                                                                               //更に言い換えれば以下のようになる。
                                                                                               //千の位が偶数の時、百の位が「0,4,8」以外（つまり「1,2,3,5,6,7,9」）ならうるう年ではない
                                                                                               //千の位が奇数の時、百の位が「2,6」以外（つまり「0,1,3,4,5,7,8,9」）ならうるう年ではない
				   	+ "(([0-9]{4}(01|03|05|07|08|10|12)(0[1-9]|[12][0-9]|3[01]))"//31日まである月の日付が正しいことを確認する
					+ "|([0-9]{4}(04|06|09|11)(0[1-9]|[12][0-9]|30))"//30日まである月の日付が正しいことを確認する
					+ "|([0-9]{4}02(0[1-9]|1[0-9]|2[0-8]))"//2月で1～28日であることを確認する
					+ "|([0-9]{2}([02468][048]|[13579][26])0229))$");//うるう年の2月29日であることを確認する
		    result = pattern.matcher(date).matches();
		}
		return result;
	}
    
}
