package com.spring.boot.test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Bar {
	private static final Logger logger = LogManager.getLogger(Bar.class.getName());

	@SuppressWarnings("deprecation")
	public boolean doIt() {
		logger.entry();
		logger.error("Did it again!");
		return logger.exit(false);
	}

	/**
	 * 模拟文件体积超过10M和时间超过1分钟来验证log4j2日志系统
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 50000; i++) {
			logger.trace("trace level");
			logger.debug("debug level");
			logger.info("info level");
			logger.warn("warn level");
			logger.error("error level");
			logger.fatal("fatal level");
		}

		Thread.sleep(1000 * 61);

		logger.trace("trace level");
		logger.debug("debug level");
		logger.info("info level");
		logger.warn("warn level");
		logger.error("error level");
		logger.fatal("fatal level");
	}
}
