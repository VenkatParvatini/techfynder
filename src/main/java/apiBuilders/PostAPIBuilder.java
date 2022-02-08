package apiBuilders;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pojo.DeleteUserPojo;
import pojo.JobseekerLoginPojo;
import pojo.JobseekerSignupCurrentLocationPojo;
import pojo.JobseekerSignupPhoneNumber;
import pojo.JobseekerSignupPojo;
import pojo.PreloginJobSearchPojo;
import pojo.PreloginTalentSearchPojo;
import pojo.SearchLocationPojo;

public class PostAPIBuilder {
	
	public String tokenBody() {
		JSONObject formParams = new JSONObject();
		formParams.put("client_id", "contractportal-app");
		formParams.put("username", "admin");
		formParams.put("password", "password");
		formParams.put("client_secret", "2d62d48e-4c73-483c-a2e4-97cce8841ad0");
		
		return formParams.toString();
	}
	
	public String postPreLoginJobSearchRequestBody(String countryID){
		
		SearchLocationPojo locations = new SearchLocationPojo();
		locations.setCountryId(countryID);
//		locations.setRegion(JSONObject.NULL);
//		locations.setStateId(JSONObject.NULL);
				
		PreloginJobSearchPojo preloginJobSearchPojo = new PreloginJobSearchPojo();
		//String[] nullArray = {};
		//preloginJobSearchPojo.setSkills(nullArray);
//		preloginJobSearchPojo.setJobTitle("Java Developer");
		//preloginJobSearchPojo.setMinDailyRate(0);
		//preloginJobSearchPojo.setMaxDailyRate(0);
		//preloginJobSearchPojo.setRateType("DAILY");
		//preloginJobSearchPojo.setIndustries(nullArray);
		//preloginJobSearchPojo.setLanguages(nullArray);
		//preloginJobSearchPojo.setContract(true);
		//preloginJobSearchPojo.setPermanent(true);
		preloginJobSearchPojo.setLocations(locations);
			
		Gson gson = new GsonBuilder().create();
		return gson.toJson(preloginJobSearchPojo);		
		
	}
	
	public String postPreLoginTalentSearchRequestBody(String countryID){
		
		SearchLocationPojo locations = new SearchLocationPojo();
		locations.setCountryId(countryID);
//		locations.setRegion(JSONObject.NULL);
//		locations.setStateId(JSONObject.NULL);
				
		PreloginTalentSearchPojo preloginTalentSearchPojo = new PreloginTalentSearchPojo();
		//String[] nullArray = {};
		//preloginTalentSearchPojo.setSkills(nullArray);
//		preloginTalentSearchPojo.setJobTitle("Java Developer");
		//preloginTalentSearchPojo.setMinDailyRate(0);
		//preloginTalentSearchPojo.setMaxDailyRate(0);
		//preloginTalentSearchPojo.setRateType("DAILY");
		//preloginTalentSearchPojo.setIndustries(nullArray);
		//preloginTalentSearchPojo.setLanguages(nullArray);
		//preloginTalentSearchPojo.setAvailability(null);
		//preloginTalentSearchPojo.setYearsOfExperience(null);
		//preloginTalentSearchPojo.setEligible(null);
		//preloginTalentSearchPojo.setContract(true);
		//preloginTalentSearchPojo.setPermanent(true);
		preloginTalentSearchPojo.setLocations(locations);
			
		Gson gson = new GsonBuilder().create();
		return gson.toJson(preloginTalentSearchPojo);		
		
	}
	
	public String jobseekerLoginRequestBody(String email, String password) {
		
		JobseekerLoginPojo jobseekerLoginPojo = new JobseekerLoginPojo();
		jobseekerLoginPojo.setEmail(email);
		jobseekerLoginPojo.setPassword(password);
		jobseekerLoginPojo.setUserType("CONTRACTOR");
		
		
		Gson gson = new GsonBuilder().create();
		return gson.toJson(jobseekerLoginPojo);
	}
	
	public String jobseekerSignupRequestBody(String email) {
		
		JobseekerSignupCurrentLocationPojo currentLocation = new JobseekerSignupCurrentLocationPojo();
		currentLocation.setCountryId("89");
		
		JobseekerSignupPhoneNumber phoneNumber = new JobseekerSignupPhoneNumber();
		phoneNumber.setCountryCode("+1671");
		phoneNumber.setPhoneNumber("9876543210");
		
		JobseekerSignupPojo jobseekerSignupPojo = new JobseekerSignupPojo();
		jobseekerSignupPojo.setEmail(email);
		jobseekerSignupPojo.setFirstName(utils.JavaUtilis.randomString(8));
		jobseekerSignupPojo.setLastName(utils.JavaUtilis.randomString(5));
		jobseekerSignupPojo.setPassword("rcwjJu8FbcWNm3FfDKxKvg==");
		jobseekerSignupPojo.setTypeUser("CONTRACTOR");
		jobseekerSignupPojo.setEnabled(true);
		
		jobseekerSignupPojo.setJobseekerSignupCurrentLocationPojo(currentLocation);
		
		jobseekerSignupPojo.setJobseekerSignupPhoneNumber(phoneNumber);
		
		String[] jobTitles = {"QA Engineer"};
		jobseekerSignupPojo.setJobTitles(jobTitles);
		
		String[] skills = {"Jira"};
		jobseekerSignupPojo.setSkills(skills);
		
		Gson gson = new GsonBuilder().create();
		return gson.toJson(jobseekerSignupPojo);
	}
	
	public String deleteUserBody(String email) {
		DeleteUserPojo deleteUserPojo = new DeleteUserPojo();
		deleteUserPojo.setEmail(email);
		
		Gson gson = new GsonBuilder().create();
		return gson.toJson(deleteUserPojo);
	}
}
