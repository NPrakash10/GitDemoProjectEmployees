import java.net.http.HttpRequest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class TC001_DemoGETRequest {

	@Test
	void GetweatherDetails()
	{
		//specify Base URI
		//RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/1");
		
		//Print response in console window
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is:" +responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Response Body is:" +statusCode);
		
		Assert.assertEquals(statusCode, 200);
	}
}
