package MavenFramework;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class PostRequest {

Properties prop =  new Properties();
	
	@BeforeTest
	public void getProperties() throws IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\$mit\\Desktop\\Seekers_Test\\SEEKERS\\src\\main\\java\\MavenFramework\\env.properties");
		prop.load(fis);		
	}
	
	@Test
	public void postEmployee() {
		RestAssured.baseURI = prop.getProperty("HOST");
		Response res = given().header("Content-Type","application/json").
		body(PayLoad.getPostData()).
		when().
		post(resources.postDataOne()).
		then().assertThat().statusCode(200).
		extract().response();
		
		String responseData = res.asString();
		System.out.println("Post Request- "+responseData);
				
	}
	
}
