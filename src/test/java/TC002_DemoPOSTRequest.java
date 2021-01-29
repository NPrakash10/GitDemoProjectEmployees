import java.net.http.HttpRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import io.restassured.http.Headers;
import io.restassured.http.Header;


public class TC002_DemoPOSTRequest {
	
	@Test
	void RegistraionSuccessfull()
	{
		//Specify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		JSONObject requestParams = new JSONObject();
		
		//Request Payload 
		//{"name":"test","salary":"123","age":"23"}
		requestParams.put("name", "Neha");
		requestParams.put("salary", "5000");
		requestParams.put("age", "40");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		//Send the request
		Response response = httpRequest.request(Method.POST, "/create");
		
		//Verification
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Response Body is:" +statusCode);
				
		Assert.assertEquals(statusCode, 201);
		
		//Success code validation
		String statusSuccess = response.jsonPath().get("status");
		Assert.assertEquals(statusSuccess, "success");	
		
	}

	

}
