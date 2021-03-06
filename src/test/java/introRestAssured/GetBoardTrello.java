package introRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBoardTrello {
	
	@Test
	public void getTrello () {
	RestAssured.baseURI = "https://api.trello.com";
	RequestSpecification httprequest = RestAssured.given();
	
	//send request
	Response resp = httprequest.request(Method.GET, "/1/members/me/boards?key=d8ef6865bbce856419c32ef3334ba326&token=d62453accdc918004c0997f9584c901c793714e6ad08d0b5b751c3a1f20c828f");
	System.out.println(resp.then().log().all());
}
}