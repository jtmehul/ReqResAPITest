package testCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import pojoClass.GoogleAddPlace;
import base.EndPointURL;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class TestCase_GoogleAddPlace {
	
	@Test
	public void getGoogleAddPlace(){
		RestAssured.baseURI="https://wewewe.com";
		
		GoogleAddPlace gap = new GoogleAddPlace();
		gap.setAddress("Akola");
		gap.setName("Mehul");
		gap.setPhone_number("12345698");
		gap.setWebsite("https://google.com");
		gap.setLanguage("Hindi");
		gap.setAccuracy(20);
		
		List<String> str = new ArrayList<>();
		str.add("tarri poha");
		str.add("chana rassa");
		gap.setTypes(str);
		
		Map<String, Double> mp = new HashMap<String, Double>();
		mp.put("lat", 18.20);
		mp.put("lng", 73.20);
		gap.setLocation(mp);
		
		String str1 = given().log().all().queryParam("key", "wwww").
		body(gap).
		when().post("/add/json"). 
		then().assertThat().log().all().
		statusCode(200).extract().response().
		asString();
		
		System.out.println(str1);			
	}

}
