package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import base.EndPointURL;
import pojoClass.CreateUser;
import pojoClass.EmployeeData;
import pojoClass.GetAllUsers;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestAPI_001 extends Base{
		
	@Test
	public void getTest() throws IOException{
		
		getBaseURLResReq();
		CreateUser cu = new CreateUser();
		cu.setName("Mehul");
		cu.setJob("Team Lead");
		cu.getName();
		cu.getJob();	
		
	    // Post Method used POJO class to create JSON, 
		given().log().all().
		body(cu).
		when().post(EndPointURL.getAPIUsers).
		then().assertThat().log().all().
		statusCode(201).extract().response().
		asString();
		
		
		
	
	}

}
