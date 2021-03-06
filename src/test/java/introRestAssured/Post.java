package introRestAssured;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Post {

	@Test
	public void postNewCustomer () {
		RestAssured.baseURI = "https://reqres.in/api/users?/page1";
		RequestSpecification httprequest = RestAssured.given();
		
		//********************************************
		
		//Request payload along with post request
		//Add data and body
		
		JSONObject json = new JSONObject();
		json.put("page", 0);
		json.put("per_page", 5);
		json.put("total", 10);
		json.put("total_pages", 5);
		
		httprequest.header("content-Type", "application/json");
		httprequest.body(json.toJSONString());
		
		
		//send request
		Response resp = httprequest.request(Method.POST);
		
		  // make it Json
		
		int statusCode= resp.getStatusCode();
		Assert.assertEquals(201,statusCode);
		
		System.out.println("Status code: "+ statusCode);
		
		
		String bodyValue = resp.getBody().asString();
		System.out.println("This is response Body: " + bodyValue);
	}
}
