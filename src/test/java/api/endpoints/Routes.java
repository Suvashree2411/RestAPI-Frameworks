package api.endpoints;

public class Routes {
	
	public static String baseurl="https://petstore.swagger.io/v2";
	
    //User module end points
	public static String user_postURL=baseurl+"/user";
	public static String user_getURL=baseurl+"/user/{username}";
	public static String user_putURL=baseurl+"/user/{username}";
	public static String user_deleteURL=baseurl+"/user/{username}";
	
}
