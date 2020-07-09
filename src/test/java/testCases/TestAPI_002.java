package testCases;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

import org.testng.annotations.Test;

public class TestAPI_002 {
	
	@Test
	public void getData(){
		RestAssured.baseURI="https://reqres.in/";
		
		String apiUsers2 = given().log().all().
				when().get("/api/users/2").
				then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(apiUsers2);
	}

}
