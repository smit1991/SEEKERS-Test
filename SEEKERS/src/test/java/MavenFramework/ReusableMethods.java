package MavenFramework;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {
	private static Logger log = LogManager.getLogger(GetRequest.class.getName());

		public static XmlPath rawToXml(Response r) {
			
			String s = r.asString();
			XmlPath x = new XmlPath(s);
			return x;
		}
		
		public static JsonPath rawToJson(Response r) {
			
			String s = r.asString();
			JsonPath x = new JsonPath(s);
			return x;
		}
		
		public static String putRequestGetId() {
			RestAssured.baseURI = "http://dummy.restapiexample.com";
			Response res = given().header("Content-Type","application/json").
					body(PayLoad.getPostData()).
					when().
					post(resources.postDataOne()).
					then().assertThat().statusCode(200).
					extract().response();
			
			String responseData = res.asString();
			log.info("Added Entry- "+responseData);
			JsonPath js = ReusableMethods.rawToJson(res);
			String id = js.get("id");
			return id;
		}
		
}
