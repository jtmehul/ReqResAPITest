package testCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import pojoClass.EmployeeData;
import pojoClass.GetAllUsers;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class TestAPI_004 {

	
	@Test
	public void getAllUsersAPITest(){
		RestAssured.baseURI="https://reqres.in/";
				
				
		GetAllUsers getUsers = given().expect().defaultParser(Parser.JSON).
				when().get("api/users?page=2").
				then().assertThat().log().all().statusCode(200).extract().response().as(GetAllUsers.class);
		
			System.out.println(getUsers.getAd().getUrl());
	}
}
