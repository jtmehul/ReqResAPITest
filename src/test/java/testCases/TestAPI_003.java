package testCases;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import org.testng.annotations.Test;

import pojoClass.EmployeeData;

public class TestAPI_003 {
	
	
	@Test
	public void userDataAPITest(){
		
		RestAssured.baseURI="http://dummy.restapiexample.com";
		
		///api/v1/employees
		
		// Use of simple get method to get JSON response and convert it to String response
		String apiUsers2 = given().log().all().
				when().get("/api/v1/employees").
				then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(apiUsers2);
		
		
		
	// use of POJO class to get all details
		EmployeeData empDataPOJO  = given().expect().defaultParser(Parser.JSON).
		when().get("/api/v1/employees").
		then().assertThat().log().all().statusCode(200).extract().response().as(EmployeeData.class);
		
		System.out.println(empDataPOJO.getStatus());
	}

}
