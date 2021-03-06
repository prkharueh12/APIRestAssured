package introRestAssured;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Basic {
	public static void main(String[] args) {
	
	// Validate if add place API is working as expected
	RestAssured.baseURI = "https://reqres.in/api/users?/page1";
	
	//Create request Object
	RequestSpecification httpRequest = RestAssured.given();
	
	//Response Object
	Response response = httpRequest.request(Method.GET);
	
	// Start validation and verification
//					String responseBody = response.getBody().asString();
//					System.out.println("This is response Body: " + responseBody);
	System.out.println(response.then().log().all());
	
	
	//Validate status code 
	int statusCode= response.getStatusCode();
	Assert.assertEquals(200,statusCode);
	String codeName = response.getStatusLine();
	System.out.println("Status code: "+ statusCode);
	System.out.println(codeName);
	
		
		

	}
}
