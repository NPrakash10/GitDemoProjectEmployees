import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GetHeadersCheck {

	
	@Test
 	void GetEmpDetails_HeadersValodate()
 	{
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/employee";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response=  httpRequest.request(Method.GET, "/1");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		Assert.assertEquals(responseBody.contains("Tiger1"), true);
		
		Headers allHeaders = response.headers();
		
		for (Header header:allHeaders)
		{
			
			System.out.print(header.getName()+"   "+header.getValue());
			
		}
		
 	}
}
