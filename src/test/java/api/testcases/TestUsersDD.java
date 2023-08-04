package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints2;
import api.payloads.Users;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class TestUsersDD {
	
	Users Userdata;
	
	@Test(priority=1, dataProvider= "data", dataProviderClass =Dataproviders.class )
	public void postusers(String exceldata[])
	{
		Userdata=new Users();
		Userdata.setId(Integer.parseInt(exceldata[0]));
		Userdata.setFirstname(exceldata[2]);
		Userdata.setLastname(exceldata[3]);
		Userdata.setUsername(exceldata[1]);
		Userdata.setEmail(exceldata[4]);
		Userdata.setPhone(exceldata[6]);
		Userdata.setPassword(exceldata[5]);
		
		Response ures=Userendpoints2.createusers(Userdata);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider = "username", dataProviderClass = Dataproviders.class)
	public void Getusers(String uname)
	{
		Response ures=Userendpoints2.Getusers(uname);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
	}
	
	@Test(priority=3, dataProvider = "username", dataProviderClass = Dataproviders.class)
	public void Putusers(String uname)
	   {
			Userdata.setPassword("triotend1");		
			Userdata.setPhone("6382741353");
			Userdata.setEmail("triotend1@gmail.com");
			Response ures=Userendpoints2.putusers(Userdata, uname);
			ures.then().log().all();
			Assert.assertEquals(ures.getStatusCode(), 200);
	   }
	
	@Test(priority=4, dataProvider = "username", dataProviderClass = Dataproviders.class)
	   public void Deleteusers(String uname)
	   {
		   Response ures=Userendpoints2.Deleteusers(uname);
		   ures.then().log().all();
		   Assert.assertEquals(ures.getStatusCode(), 200);
	   }
}

