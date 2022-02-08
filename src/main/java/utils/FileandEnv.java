package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileandEnv {

	public static Map<String, String> fileandenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	public static Map<String, String> envAndFile(String environment) {

		try {
			FileInputStream fis;
			if (environment.equalsIgnoreCase("prod"))
				fis = new FileInputStream(System.getProperty("user.dir") + "/inputs/prod.properties");
			else
				 fis = new FileInputStream(System.getProperty("user.dir") + "/inputs/uat.properties");
			
			propMain.load(fis);
			fileandenv.put("ServerUrl", propMain.getProperty("ServerUrl"));
			fileandenv.put("UtilUrl", propMain.getProperty("UtilUrl"));
			fileandenv.put("countryID", propMain.getProperty("countryID"));
			fileandenv.put("JobseekerLogin", propMain.getProperty("JobseekerLogin"));
			fileandenv.put("JobseekerPass", propMain.getProperty("JobseekerPass"));
			fileandenv.put("JobseekerSignup", propMain.getProperty("JobseekerSignup"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		return fileandenv;

	}
}
