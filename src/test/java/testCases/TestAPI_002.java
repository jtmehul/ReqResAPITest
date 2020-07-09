package testCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.RestAssured;

import org.testng.annotations.Test;

import base.Base;
import base.EndPointURL;

public class TestAPI_002 extends Base{
	
	@Test
	public void getData() throws IOException{
		getBaseURLResReq();
		String apiUsers2 = given().log().all().
				when().get(EndPointURL.getAPIUesrs2).
				then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(apiUsers2);
	}

}
