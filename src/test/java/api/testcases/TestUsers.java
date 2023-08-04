package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints2;
import api.payloads.Users;
import io.restassured.response.Response;

public class TestUsers {
	Faker fk;
	Users userpayload;
	
	@BeforeClass
	public void setupdata()
	{
		fk=new Faker();
		userpayload=new Users();
		
		userpayload.setId(fk.idNumber().hashCode());
		userpayload.setFirstname(fk.name().firstName());
		userpayload.setLastname(fk.name().lastName());
		userpayload.setUsername(fk.name().username());
		userpayload.setPassword(fk.internet().password(5, 9));
		userpayload.setEmail(fk.internet().safeEmailAddress());
		userpayload.setPhone(fk.phoneNumber().cellPhone());	
	}
	
	@Test(priority=1)
	
	public void PostUserTest()
	{
		Response Ures=Userendpoints2.createusers(userpayload);
		Ures.then().log().all();
		Assert.assertEquals(Ures.getStatusCode(), 200);
	}

	@Test(priority=2)
	public void GetUserTest()
	{
		Response Ures=Userendpoints2.Getusers(userpayload.getUsername());
		Ures.then().log().all();
		Assert.assertEquals(Ures.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void PutUsersTest()
	{
		userpayload.setPassword(fk.internet().password(5, 9));
		userpayload.setEmail(fk.internet().safeEmailAddress());
		userpayload.setPhone(fk.phoneNumber().cellPhone());	
		
		Response Ures=Userendpoints2.putusers(userpayload, userpayload.getUsername());
		Ures.then().log().all();
		Assert.assertEquals(Ures.getStatusCode(), 200);
		
		//check the data
		Response Cres=Userendpoints2.Getusers(userpayload.getUsername());
		Cres.then().log().all();
		
	}
	
	@Test(priority=4)
	public void DeleteUsersTest()
	{
		Response Ures=Userendpoints2.Deleteusers(userpayload.getUsername());
		Ures.then().log().all();
		Assert.assertEquals(Ures.getStatusCode(), 200);
	}
}
