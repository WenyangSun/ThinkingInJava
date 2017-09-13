package com.ietree.log.log4j2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MyTest {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(MyTest.class);
		logger.fatal("fatal msg");
		logger.error("error msg");
		logger.warn("warn msg");
		logger.info("info msg");
		logger.debug("debug msg");
		logger.trace("trace msg");
	}
}
