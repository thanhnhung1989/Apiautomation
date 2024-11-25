//package stepsdefinition.SingleTool;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertNotNull;
//import static org.testng.Assert.assertTrue;
//
//import java.net.URI;
//import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpResponse.BodyHandlers;
//
//import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
//import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
//import io.cucumber.java.ParameterType;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class CheckResponseWhenSendRequestSuccessfullyStepsSingleTool {
//	boolean userManualFlag;
//	String givenurl, method;
//	HttpResponse<String> response;
//	
//	@Given("I have url and method test for single tool")
//	public void i_have_url_and_method() {
//	  givenurl = "https://simple-tool-rental-api.glitch.me/tools";
//	  method = "GET";
//	}
//	@Given("The user-manual flag is {boolean}")
//	public void the_user_manual_flag_is(boolean flag) {
//	    this.userManualFlag = flag;
//	    System.out.println("User-manual flag set to: " + this.userManualFlag);
//	}
//
//	@When("I send tool request with param toolID {string}")
//	public void i_send_tool_request_with_param_toolID(String toolId) {
//	    try {
//	    	 // Gửi yêu cầu GET đến URL với toolId trong path
//            String url = givenurl + "/" + toolId;
//                url += "?user-manual=" + userManualFlag;
//       
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(new URI(url))
//                    .GET()
//                    .build();
//            response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
//
////	@Then("Status code is returned test for single tool {int}")
////	public void status_code_is_returned_as(Integer int1) {
////	   assertEquals( response.statusCode(), 200);
////	}
//	  
//	@Then("Response body matches toolID {string}")
//	public void response_body_matches_category(String toolId ) {
//		 assertTrue(response.body().contains("\"id\":" + toolId), "Response body does not contain the expected tool ID!");
//	}
//	@Then("The response should match user-manual flag")
//	public void the_response_should_match_user_manual_flag() {
//	    assertNotNull(response, "Response is null!");
//	    String responseBody = response.body();
//	    if (Boolean.TRUE.equals(userManualFlag)) {
//	        assertTrue(responseBody.contains("\"user-manual\""), "Expected user-manual in the response, but not found!");
//	    } else if (Boolean.FALSE.equals(userManualFlag)) {
//	        assertTrue(!responseBody.contains("\"user-manual\""), "Expected no user-manual in the response, but it was found!");
//	    }
//	}
//
//
//
//}


