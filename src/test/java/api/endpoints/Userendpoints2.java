package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Userendpoints2 {
	
public static ResourceBundle geturl() {
	
	ResourceBundle resource=ResourceBundle.getBundle("approutes");
	 
	return resource;
}

	public static Response createusers (Users payload)
	
	{
		String url=geturl().getString("user_postURL");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(url);
		
		
	return res;
	}
public static Response Getusers (String uname)
	
	{
	String url=geturl().getString("user_getURL");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.get(url);
		
		
	return res;
	}
	
public static Response putusers (Users payload, String uname)

{
	String url=geturl().getString("user_putURL");
	Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", uname)
			.body(payload)
			.when()
			.get(url);
	
	
return res;
}

public static Response Deleteusers (String uname)

{
	String url=geturl().getString("user_deleteURL");
	Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", uname)
			.when()
			.delete(url);
	
	
return res;
}
}
