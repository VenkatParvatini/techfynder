package utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtilis {
	
	public static String randomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		String id = Integer.toString(randomNumber);
		
		return id;		
	}
	
	public static String randomString(int length) {
		String randomSTring = RandomStringUtils.randomAlphabetic(length);
		return randomSTring;
	}

}
