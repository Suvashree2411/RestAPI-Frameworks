package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Userendpoints {

	public static Response createusers (Users payload)
	
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.user_postURL);
		
		
	return res;
	}
public static Response Getusers (String uname)
	
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.get(Routes.user_getURL);
		
		
	return res;
	}
	
public static Response putusers (Users payload, String uname)

{
	Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", uname)
			.body(payload)
			.when()
			.get(Routes.user_putURL);
	
	
return res;
}

public static Response Deleteusers (String uname)

{
	Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", uname)
			.when()
			.delete(Routes.user_deleteURL);
	
	
return res;
}
}
