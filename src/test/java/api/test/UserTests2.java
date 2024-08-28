package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User user_payload;
	public Logger logger;
	
	@BeforeTest
	public void setupdata() {
		
		faker=new Faker();
		
		user_payload=new User();   // create object of pojo class
		
		user_payload.setId(faker.idNumber().hashCode());    //call pojo class methods
		user_payload.setFirstName(faker.name().firstName());
		user_payload.setEmail(faker.internet().emailAddress());
		user_payload.setLastName(faker.name().lastName());
		user_payload.setPassword(faker.internet().password(5,10));
		user_payload.setPhone(faker.phoneNumber().cellPhone());
		user_payload.setUsername(faker.name().username());
		//user_payload.setUserStatus("");
		
		// for generating logs
logger= LogManager.getLogger(this.getClass());
		
		logger.debug("debugging.....");
		
		
	}

	@Test(priority=1)
	public void TestPostUser() {
		
		Response response=UserEndpoints2.CreateUser(user_payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**********User is creatged  ***************");
		
	}
	
	@Test(priority=2)
	
	void testgetUserbyName() {
		
		System.out.println("username is---> " +this.user_payload.getUsername());
	Response response=UserEndpoints2.readUser(this.user_payload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**********User info  is displayed ***************");
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		//update user data in payload
		user_payload.setFirstName(faker.name().firstName());
		user_payload.setEmail(faker.internet().emailAddress());
		user_payload.setLastName(faker.name().lastName());
		
		Response response=UserEndpoints2.updateUser(this.user_payload.getUsername(), user_payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("********** User updated ***************");
		
		//checking data after update
		
		Response updateresponse= UserEndpoints2.readUser(this.user_payload.getUsername());
		Assert.assertEquals(updateresponse.getStatusCode(),200);
		
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		logger.info("**********   Deleting User  ***************");
		Response res = UserEndpoints2.deleteUser(this.user_payload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("********** User deleted ***************");
	}
}
