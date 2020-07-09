package testCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import base.EndPointURL;
import pojoClass.EmployeeData;
import pojoClass.GetAllUsers;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class TestAPI_004 extends Base{

	
	@Test
	public void getAllUsersAPITest() throws IOException{
		
		getBaseURLResReq();
		GetAllUsers getUsers = given().expect().defaultParser(Parser.JSON).
				when().get(EndPointURL.getAPIUserPage2).
				then().assertThat().log().all().statusCode(200).extract().response().as(GetAllUsers.class);
			System.out.println(getUsers.getAd().getUrl());
	}
}
