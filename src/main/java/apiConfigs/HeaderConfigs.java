package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {
	
	public HeaderConfigs() {
		
	}
	
	public Map<String, String> defaultHeaders(){
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		
		return defaultHeaders;
	}
	
	public Map<String, String> headersWithBearerToken(String token){
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Authorization", "Bearer " + token);
		
		return defaultHeaders;
	}
	
	public Map<String, String> headersWithCookieBearerToken(String token){
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Authorization", "Bearer " + token);
		defaultHeaders.put("Cookie", "JSESSIONID=8E90A3AE881631EC68EAE37E8AE1CF32");
		
		return defaultHeaders;
	}
}
