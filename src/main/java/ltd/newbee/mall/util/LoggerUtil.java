package ltd.newbee.mall.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

// 1.1、java日志记录错误的文件、方法、行号、报错信息
	/**
	 * 
	 * 获取堆栈信息
	 * 
	 * @param throwable
	 * @return
	 * 
	 */

	public static String getStackTrace(Throwable throwable) {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			throwable.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}

	}

	/**
	 * 
	 * @Desc: 异常打印日志 ，提供给打印非正常异常
	 *
	 */

	public static void log(Throwable e, Class c) {

		Logger logger = LoggerFactory.getLogger(c);

		// logger.error("错误堆栈", e);

		StackTraceElement s = e.getStackTrace()[0];// 数组长度为 1

		logger.error("\n\n-----------------" +

				"\n报错文件名:" + s.getFileName() +

				"\n报错的类：" + s.getClassName() +

				"\n报错方法：：" + s.getMethodName() +

				"\n报错的行：" + s.getLineNumber() +

				"\n报错的message：" + e.getMessage() +

				"\n错误堆栈：\n" + getStackTrace(e) +

				"\n------------------\n\n");

	}

	// 1.2、使用

//	public static void main(String[] args) {
//
//		try {
//			int i = 1 / 0;
//		} catch (Exception e) {
//			log(e, xxx.class);
//		}
//
//	}
	
	
}
