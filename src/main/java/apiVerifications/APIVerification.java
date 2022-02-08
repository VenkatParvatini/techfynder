package apiVerifications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListner;

public class APIVerification extends ExtentReportListner {

	public static void responseCodeValiddation(Response response, int statusCode) {

		try {
			Assert.assertEquals(response.getStatusCode(), statusCode);
			test.log(LogStatus.PASS,
					"Successfully validated for status code :: " + response.getStatusCode());
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL,
					"Expected status code is :: " + statusCode + " , actual status code is :: " + response.getStatusCode());
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	public static void responseCodeValiddation(Response response, int statusCode, int statusCode2) {

		try {
			int statusResponse = response.getStatusCode();
			Assert.assertTrue(statusResponse == statusCode || statusResponse == statusCode2);
			test.log(LogStatus.PASS,
					"Successfully validated for status code :: " + response.getStatusCode());
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL,
					"Expected status code is :: " + statusCode + " , actual status code is :: " + response.getStatusCode());
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	public static void responseKeyValidationfromArray(Response response, String key) {
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			for(int i=0; i<array.length();i++) {
				JSONObject obj = array.getJSONObject(i);
				test.log(LogStatus.PASS, "Validated values are  " + obj.get(key));
				
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	
	public static void responseKeyValidationFromJsonObject(Response response, String key) {
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			Assert.assertTrue(json.has(key), key + " key not present in response");
			if(json.has(key) && json.get(key)!= null) {
				test.log(LogStatus.PASS, "Sucessfully validated, Key : \"" + key + "\" value is " + json.get(key));
			}else {
				test.log(LogStatus.FAIL,"Key is not availble");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	
	public static void responseTimeValidation(Response response) {
		try {
			long time=response.time();
			test.log(LogStatus.INFO, "Api response time is :: " + time);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	public static void responseTimeValidationForTimeout(Response response, long timeout) {
		try {
			long time=response.time();
			Assert.assertTrue(time < timeout, "Api response time is " + time);
			if (time < timeout)
				test.log(LogStatus.PASS, "Api response time is :: " + time);
			else
				test.log(LogStatus.FAIL, "Api response time is :: " + time + ", Expected is " + timeout + " or less");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

}
