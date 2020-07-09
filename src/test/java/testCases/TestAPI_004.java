package testCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Scanner;

import org.testng.Assert;
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
	@Test
	public void getUserData() throws IOException{
		String firstName = "";
		String lastName="";
		int id=0;
		getBaseURLResReq();
		GetAllUsers getUsersOne = given().expect().defaultParser(Parser.JSON).
				when().get(EndPointURL.getAPIUserPage2).
				then().assertThat().log().all().statusCode(200).extract().response().as(GetAllUsers.class);
			int count = getUsersOne.getData().size();
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter the Id: - ");
			int input = scan.nextInt();
			for(int i=0;i<count;i++){
				id = getUsersOne.getData().get(i).getId();
				if(id == input){
					firstName = getUsersOne.getData().get(i).getFirst_name();
					lastName = getUsersOne.getData().get(i).getLast_name();
					break;
				}
			}
			Assert.assertEquals(input, id);
			System.out.println("The user with Id is " + id + " Fist Name is " + firstName + " and Last Name is " + lastName);
	}
}
