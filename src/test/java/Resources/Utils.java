package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	
	public RequestSpecification requestspecificationn() throws IOException {
		if(req==null) {
		PrintStream log = new PrintStream("logging.txt");
		 req = new RequestSpecBuilder()
				 .setBaseUri(getbaseuri("baseuri"))
				 .addQueryParam("key", "qaclick123")
				 .setContentType(ContentType.JSON)
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .build();
		 return req;
		}
		return req;
	}
	
	
	public String getjsonparse(String key,Response response) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.getString(key).toString();
	}
	
	public static String getbaseuri(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\navee\\eclipse-workspace\\CucumberGmapsapiproject\\src\\test\\java\\Resources\\baseuri.properties");
	    prop.load(fis);
	    return prop.getProperty(key);
	
	    }
	
	
	
	

}
