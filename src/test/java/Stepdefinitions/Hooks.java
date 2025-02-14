package Stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Deleteplace")
	public void beforedelete() throws IOException {
		Stepdefinitions s = new Stepdefinitions();
		if(s.placeid==null) {
			s.user_needs_to_add_the_addplace_payload_with("-54.5959","-54.5950","50","naveen","phone","address","type1","type2","website","language");
		    s.user_needs_to_use_the_using_http_method("Addplaceapi", "post");
		    s.user_needs_to_validate_if_response_status_code_is(200);
		    s.user_needs_to_verify_the_response_of_is("status", "OK");
		}
	}

}
