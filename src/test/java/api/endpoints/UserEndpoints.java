package api.endpoints;
import static io.restassured.RestAssured.*;   // static packages to be imported manually
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//user endpoints.java 
// created for CRUD operations to user API
public class UserEndpoints {
	
	public static Response CreateUser(User payload) {     // import user pojo class
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		return response;
	}
	
	
	public static Response readUser(String userName) {
		
		Response response= given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.when()
				.get(Routes.get_url);
		return response;
		
	}
	
	public static Response updateUser(String userName, User payload) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				
				.when()
				.put(Routes.update_url);
		
		return response;
	}
	
	
	public static Response deleteUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
				
				.when()
				.delete(Routes.delete_url);
		
		return response;
		
		
	}

}
