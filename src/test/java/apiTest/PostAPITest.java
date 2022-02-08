package apiTest;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.FileandEnv;

public class PostAPITest extends BaseTest {
	
	@Test(priority = 1)
	@Parameters("environment")
	public void validatePreLoginJobSearchTest(@Optional("uat")String environment) {

		test = reports.startTest("Find Jobs Search Test");
		test.log(LogStatus.INFO, "Prelogin Find Job Search is started in - " + environment.toUpperCase());
		String uri = FileandEnv.envAndFile(environment).get("ServerUrl");
		String countryID = FileandEnv.envAndFile(environment).get("countryID");
		RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri(uri).build();
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();

		Response response = RestAssured
				.given()
					.spec(requestSpecBuilder)
				.when()
					.headers(header.headersWithBearerToken(getToken()))
					.body(builder.postPreLoginJobSearchRequestBody(countryID))
				.when()
					.post(APIPath.apiPath.CREATE_POST_JOB_SEARCH);

		APIVerification.responseKeyValidationFromJsonObject(response, "totalResults");
		APIVerification.responseCodeValiddation(response, 200);
		APIVerification.responseTimeValidationForTimeout(response, 5000);
		
//		System.out.println(response.asString());
		test.log(LogStatus.INFO, "Prelogin Find Job Search success.....");

	}
	
	@Test(priority = 2)
	@Parameters("environment")
	public void validatePreLoginTalentSearchTest(@Optional("uat")String environment) {

		test = reports.startTest("Find Talent Search Test");
		test.log(LogStatus.INFO, "Prelogin Find Talent Search started in - " + environment.toUpperCase());
		String uri = FileandEnv.envAndFile(environment).get("ServerUrl");
		String countryID = FileandEnv.envAndFile(environment).get("countryID");
		RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri(uri).build();
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();

		Response response = RestAssured
				.given()
					.spec(requestSpecBuilder)
				.when()
					.headers(header.headersWithBearerToken(getToken()))
					.body(builder.postPreLoginTalentSearchRequestBody(countryID))
				.when()
					.post(APIPath.apiPath.CREATE_POST_TALENT_SEARCH);

		APIVerification.responseKeyValidationFromJsonObject(response, "totalResults");
		APIVerification.responseCodeValiddation(response, 200);
		APIVerification.responseTimeValidationForTimeout(response, 5000);
		
//		System.out.println(response.asString());
		test.log(LogStatus.INFO, "Prelogin Find Talent Search success.....");

	}
	
	@Test(priority = 3)
	@Parameters("environment")
	public void validateJobseekerLoginTest(@Optional("uat")String environment) {

		test = reports.startTest("Jobseeker Login Test");
		test.log(LogStatus.INFO, "Jobseeker Login started in - " + environment.toUpperCase());
		String uri = FileandEnv.envAndFile(environment).get("ServerUrl");
		RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri(uri).build();
		String email = FileandEnv.envAndFile(environment).get("JobseekerLogin");
		String password = FileandEnv.envAndFile(environment).get("JobseekerPass");
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();

		Response response = RestAssured
				.given()
					.spec(requestSpecBuilder)
				.when()
					.headers(header.headersWithBearerToken(getToken()))
					.body(builder.jobseekerLoginRequestBody(email, password))
				.when()
					.post(APIPath.apiPath.JOBSEEKER_LOGIN);

		APIVerification.responseCodeValiddation(response, 200);
		APIVerification.responseTimeValidationForTimeout(response, 5000);
		
//		System.out.println(response.asString());
		test.log(LogStatus.INFO, "Jobseeker Login successful.....");
	}
	
	@Test(priority = 4)
	@Parameters("environment")
	public void validateJobseekerSignupTest(@Optional("uat")String environment) {

		test = reports.startTest("Jobseeker Signup Test");
		test.log(LogStatus.INFO, "Jobseeker Signup is started in - " + environment.toUpperCase());
		String uri = FileandEnv.envAndFile(environment).get("ServerUrl");
		String email = FileandEnv.envAndFile(environment).get("JobseekerSignup");
		RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri(uri).build();
		
		deleteUser(environment);
		
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();

		Response response = RestAssured
				.given()
					.spec(requestSpecBuilder)
				.when()
					.headers(header.headersWithBearerToken(getToken()))
					.body(builder.jobseekerSignupRequestBody(encrypt(email, environment)))
				.when()
					.post(APIPath.apiPath.JOBSEEKER_SIGNUP);

		APIVerification.responseCodeValiddation(response, 200);
		APIVerification.responseTimeValidationForTimeout(response, 5000);
		
//		System.out.println(response.asString());
		test.log(LogStatus.INFO, "Jobseeker Signup success.....");
//			encrypt("automation308@mail.techfynder.com","uat");
	}
	
	public void deleteUser(@Optional("uat")String environment) {

		test.log(LogStatus.INFO, "Deleting user in - " + environment.toUpperCase());
		String uri = "http://34.246.200.69:9004";
		RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri(uri).build();
		String email = FileandEnv.envAndFile(environment).get("JobseekerSignup");
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();

		Response response = RestAssured
				.given()
					.spec(requestSpecBuilder)
				.when()
					.headers(header.headersWithCookieBearerToken(getToken()))
					.body(builder.deleteUserBody(email))
				.when()
					.post(APIPath.apiPath.DELETE_USER);

		APIVerification.responseCodeValiddation(response, 202, 404);
		APIVerification.responseTimeValidationForTimeout(response, 5000);
		
//		System.out.println(response.asString());
		test.log(LogStatus.INFO, "User Deleted.....");
	}
	
//	@Test
//	@Parameters("environment")
	public String encrypt(@Optional("uat")String input, String environment) {
		
		test.log(LogStatus.INFO, "Encryption starting in - " + environment.toUpperCase());
		String uri = FileandEnv.envAndFile(environment).get("UtilUrl");
		RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri(uri).build();
		HeaderConfigs header = new HeaderConfigs();
		
		Response response = RestAssured
				.given()
					.spec(requestSpecBuilder)
				.when()
					.headers(header.headersWithBearerToken(getToken()))
					.body(input)
				.when()
					.post(APIPath.apiPath.CREATE_POST_ENCRYPT);

		APIVerification.responseCodeValiddation(response, 200);
		APIVerification.responseTimeValidationForTimeout(response, 5000);
		
//		System.out.println(response.asString());
		test.log(LogStatus.INFO, "Encrypted successfully.....");
		return response.asString();

	}
	
}
