package testCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import org.testng.annotations.Test;

import base.Base;
import base.EndPointURL;
import pojoClass.EmployeeData;

public class TestAPI_003 extends Base{
	
	
	@Test
	public void userDataAPITest() throws IOException{
		getEmployeeDataReqRes();
		// Use of simple get method to get JSON response and convert it to String response
		String apiUsers2 = given().log().all().
				when().get(EndPointURL.getAPIEmployees).
				then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(apiUsers2);
	}
	@Test
	public void getUserDataPOJO(){
		
		// use of POJO class to get all details
				/*EmployeeData empDataPOJO  = given().expect().defaultParser(Parser.JSON).
				when().get(EndPointURL.getAPIEmployees).
				then().assertThat().log().all().statusCode(200).extract().response().as(EmployeeData.class);
				System.out.println(empDataPOJO.getStatus());*/
	}

}
