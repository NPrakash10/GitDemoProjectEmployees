import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC005_GetVerifyNestedvalues {
	
	@Test
	void GetNestedValuesVerification()
	{
		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/employees";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response= httpRequest.request(Method.GET);
		
		Map<String, String> empData = response.jsonPath().getMap("data[1]");
		
		System.out.println(empData.get("employee_name"));
		
	}

}
