package base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import io.restassured.RestAssured;

public class Base {
	
	public Properties prop = new Properties();
	public FileInputStream fis;
	
	public void getBaseURLResReq() throws IOException{
		fis = dataPropertiesFile();
		prop.load(fis);
		RestAssured.baseURI=prop.getProperty("base");
		System.out.println(RestAssured.baseURI);
	}
	public void getEmployeeDataReqRes() throws IOException{
		fis = dataPropertiesFile();
		prop.load(fis);
		RestAssured.baseURI=prop.getProperty("empBaseURI");
		System.out.println(RestAssured.baseURI);	
	}
	public FileInputStream dataPropertiesFile() throws FileNotFoundException{
		fis = new FileInputStream(System.getProperty("user.dir")+ "\\resources\\data.properties");
		return fis;
	}

}
