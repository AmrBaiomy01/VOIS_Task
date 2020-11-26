package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.json.JSONObject;



public class RestAssuredApi {

	@Test (priority = 0 )
	public void Creatpost() throws Exception
	{

		String baseUri = "https://jsonplaceholder.typicode.com/";

		RestAssured.baseURI =baseUri;
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("title", "foo");
		requestParams.put("body", "bar");
		requestParams.put("userId", "1");

		System.out.println(requestParams.toString());
		request.header("Content-Type","application/json");
		request.body(requestParams.toString());
		Response response =	request.post("posts");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		System.out.println(response.asString());
		assertTrue(statusCode == 201);
		assertTrue(response.jsonPath().get("title").equals("foo"));
		assertTrue(response.jsonPath().get("body").equals("bar"));
		assertTrue(response.jsonPath().get("userId").equals("1"));
		assertTrue(response.jsonPath().get("id") != "");

	}



	@Test (priority = 1)
	public void Getallposts() throws Exception
	{

		String baseUri = "https://jsonplaceholder.typicode.com/";

		RestAssured.baseURI =baseUri;
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type","application/json");

		Response response =	request.get("posts");

		SoftAssert sa = new SoftAssert();


		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		System.out.println(response.asString());
		sa.assertTrue(statusCode == 200);

		ApiData[] jsonData = response.jsonPath().getObject("", ApiData[].class);

		for(ApiData data : jsonData)
		{
			System.out.println(data.userId);
			sa.assertTrue(!data.userId.isEmpty());
			System.out.println(data.body);
			sa.assertTrue(!data.body.isEmpty());
			System.out.println(data.title);
			sa.assertTrue(!data.title.isEmpty());
			System.out.println(data.id);
			sa.assertTrue(!data.id.isEmpty());
			
			GetpostswithId(data.id);		
		}
		

	sa.assertAll();
}



public void GetpostswithId(String postId) throws Exception
{

	String baseUri = "https://jsonplaceholder.typicode.com/";

	RestAssured.baseURI =baseUri;
	RequestSpecification request = RestAssured.given();

	request.header("Content-Type","application/json");
	Response response =	request.get("posts/" + postId);

	SoftAssert sa = new SoftAssert();


	int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	System.out.println(response.asString());
	sa.assertTrue(statusCode == 200);

	if(statusCode == 200) {

		String userId = response.jsonPath().getString("userId");
		String body = response.jsonPath().getString("body");
		String title = response.jsonPath().getString("title");
		String id = response.jsonPath().getString("id");

			sa.assertTrue(!userId.isEmpty());
			sa.assertTrue(!body.isEmpty());
			sa.assertTrue(!title.isEmpty());
			sa.assertTrue(!id.isEmpty());

	
	}

	sa.assertAll();
}

}
