package api.endpoints;
import static io.restassured.RestAssured.*;   // static packages to be imported manually
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.ResourceBundle;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//user endpoints.java 
// created for CRUD operations to user API
public class UserEndpoints2 {
	
	//method for getting urls from properties file
	static ResourceBundle getUrl(){
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response CreateUser(User payload) {     // import user pojo class
		
		String post_url=getUrl().getString("post_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post( post_url);
		return response;
	}
	
	
	public static Response readUser(String userName) {
		String get_url=getUrl().getString("get_url");
		Response response= given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.when()
				.get(get_url);
		return response;
		
	}
	
	public static Response updateUser(String userName, User payload) {
		String update_url=getUrl().getString("update_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				
				.when()
				.put(update_url);
		
		return response;
	}
	
	
	public static Response deleteUser(String userName) {
		String delete_url=getUrl().getString("delete_url");
		Response response = given()
				.pathParam("username", userName)
				
				.when()
				.delete(delete_url);
		
		return response;
		
		
	}

}
