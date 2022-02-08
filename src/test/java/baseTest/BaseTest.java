package baseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import apiTest.BearerToken;
import utils.ExtentReportListner;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner{
	private String token = "";
	
	@BeforeClass
	@Parameters("environment")
	public void getToken(@Optional("uat")String environment) {
		test = reports.startTest("Generate Token");
		if (token.equals(""))
			token = new BearerToken().generateToken(environment);
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

}
