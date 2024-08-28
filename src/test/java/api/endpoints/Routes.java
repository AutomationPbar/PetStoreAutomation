package api.endpoints;


public class Routes {
	
	// maintain only urls 
	
	public static String base_url= "https://petstore.swagger.io/v2";  // can be accessed anywhere with name without object because static
	
	//user module
	
	public static String post_url =base_url+"/user";
	public static String get_url =base_url+"/user/{username}";     // get the respective urls from swagger username is path parameter
	public static String update_url =base_url+"/user/{username}";
	public static String delete_url =base_url+"/user/{username}";
	
	//store module
	//store module urls
	
	
	//pet module
	//pet module urls
	
}
