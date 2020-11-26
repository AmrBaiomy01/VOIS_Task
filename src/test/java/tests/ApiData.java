package tests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ApiData {	
			
//		API properties
		
	public String userId;
	public String id;
	public String title;
	public String body;

	
}
