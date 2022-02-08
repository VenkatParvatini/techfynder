package apiTest;

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

public class BearerToken extends BaseTest{
	
	public String generateToken(String environment) {
		
		test.log(LogStatus.INFO, "Token Started - " + environment.toUpperCase());
		String uri = FileandEnv.envAndFile(environment).get("UtilUrl");
		RequestSpecification requestSpecBuilder = new RequestSpecBuilder().setBaseUri(uri).build();
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();

		Response response = RestAssured
				.given()
					.spec(requestSpecBuilder)
				.when()
					.headers(header.defaultHeaders())
					.body(builder.tokenBody())
				.when()
					.post(APIPath.apiPath.GENERATE_TOKEN);

		//APIVerification.responseKeyValidationFromJsonObject(response, "access_token");
		APIVerification.responseCodeValiddation(response, 200);
		APIVerification.responseTimeValidationForTimeout(response, 5000);
		
//		System.out.println(response.asString());

		test.log(LogStatus.INFO, "Token generated.....");
		
		return response.jsonPath().getString("access_token");
	}

}
