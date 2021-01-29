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
public class TC004_ValidateAllRespinseBody {
	
	@Test
	void ValidateResponseBody()
	{
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/1");
		
		  

		 Map<String, String> company = response.jsonPath().getMap("data");
		 System.out.println(company.get("employee_name"));
		 
		
	}
	
	

}
