package com.marlonviado.util;

import java.util.Random;

public class NumberUtil {
	
	public static String generateCustomerNumber(int len) {
		Random random = new Random();
		StringBuilder randomString = new StringBuilder();

		for (int i = 0; i < len; i++) {
			char randomChar = (char) ('0' + random.nextInt(10));
			randomString.append(randomChar);
		}

		return randomString.toString();

	}

}
