package stepsdefinition.ToolsApi;

import static org.testng.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseWhenSendRequestSuccessfullySteps {
	String givenurl, method;
	HttpResponse<String> response;
	
	@Given("I have url and method")
	public void i_have_url_and_method() {
	  givenurl = "https://simple-tool-rental-api.glitch.me/tools";
	  method = "GET";
	}

	@When("I send tool request")
	public void i_send_tool_request() {
		URL url;
		try {
//			url = new URL(givenurl);
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod(method);
			HttpRequest	request = HttpRequest.newBuilder().uri(new URI(givenurl)).GET().build();
			response =  HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Then("Status code is returned as {int}")
	public void status_code_is_returned_as(Integer int1) {
	   assertEquals( response.statusCode(), 200);
	}

	@Then("Response body is correctly")
	public void response_body_is_correctly() {
	  
	}

}
