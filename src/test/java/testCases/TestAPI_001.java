package testCases;

import org.testng.annotations.Test;

import pojoClass.CreateUser;
import pojoClass.EmployeeData;
import pojoClass.GetAllUsers;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestAPI_001 {
		
	@Test
	public void getTest(){
		
		RestAssured.baseURI="https://reqres.in/";
		
		CreateUser cu = new CreateUser();
		cu.setName("Mehul");
		cu.setJob("Team Lead");
		cu.getName();
		cu.getJob();	
		
	    // Post Method used POJO class to create JSON, 
		given().log().all().
		body(cu).
		when().post("api/users").
		then().assertThat().log().all().
		statusCode(201).extract().response().
		asString();
		
		
		
	
	}

}
