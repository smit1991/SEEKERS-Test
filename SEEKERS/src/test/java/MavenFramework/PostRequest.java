package MavenFramework;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class PostRequest {
	private static Logger log = LogManager.getLogger(GetRequest.class.getName());
	Properties prop =  new Properties();
	
	@BeforeTest
	public void getProperties() throws IOException {
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\env.properties");
		prop.load(fis);		
	}
	
	@Test
	public void postEmployee() {
		log.info("Host Information "+prop.getProperty("HOST"));
		RestAssured.baseURI = prop.getProperty("HOST");
		Response res = given().header("Content-Type","application/json").
		body(PayLoad.getPostData()).
		when().
		post(resources.postDataOne()).
		then().assertThat().statusCode(200).
		extract().response();
		
		String responseData = res.asString();
		log.info("Post Request- "+responseData+"\n");
				
	}
	
}
