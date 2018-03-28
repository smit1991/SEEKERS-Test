package MavenFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {

	private static Logger log = LogManager.getLogger(GetRequest.class.getName());
	Properties prop =  new Properties();
	
	@BeforeTest
	public void getProperties() throws IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\$mit\\Desktop\\Seekers_Test\\SEEKERS\\src\\main\\java\\MavenFramework\\env.properties");
		prop.load(fis);		
	}
	
	@Test
	public void getEmployees() {
		log.info("Host Information "+prop.getProperty("HOST"));
		RestAssured.baseURI = prop.getProperty("HOST");
		Response res = given().
		when().
		get(resources.placeData()).
		then().assertThat().statusCode(200).extract().response();
		
		String responseData = res.asString();
		log.info("Get all employees- "+responseData);		
		
		
	}

	
}
