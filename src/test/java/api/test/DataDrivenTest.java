package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.payload.User;
import api.utilities.DataProvidermethod;
import api.endpoints.UserEndpoints;
import io.restassured.response.Response;


public class DataDrivenTest {
	User user_payload;
	@Test(priority=1,dataProvider="data",dataProviderClass=DataProvidermethod.class )
	public void testPostuser(String userId,String userName,String fname,String lname,String email,String pwd,String ph) {
		
		user_payload = new User();
		user_payload.setId(Integer.parseInt(userId));
		user_payload.setUsername(userName);
		user_payload.setFirstName(fname);
		user_payload.setLastName(lname);
		user_payload.setEmail(email);
		user_payload.setPassword(pwd);
		user_payload.setPhone(ph);
		
		Response response= UserEndpoints.CreateUser(user_payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProvidermethod.class)
	
	void delete_users(String userName) {
		
		
		Response response = UserEndpoints.deleteUser(userName);
		response.then().log().all();
		
		//Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
}
