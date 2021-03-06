package introRestAssured;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PrintAllHeaders {

	
	@Test
	public void printHeadersDetails () {
		RestAssured.baseURI = "https://reqres.in/api/users?/page1";
		RequestSpecification httprequest = RestAssured.given();
		
		//send request
		Response resp = httprequest.request(Method.GET);
		
		 String contentType = resp.getHeader("Content-Type");
		System.out.println("This is conten type: "+ contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		Headers allheader = resp.headers(); // capture all headers from response
		
		for (Header head : allheader) {
			System.out.println(head.getName()+" : "+head.getValue());
			//System.out.println(head);
		}
		
	}
}
