//package stepsdefinition.ToolsApi;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertNotNull;
//import static org.testng.Assert.assertTrue;
//
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpResponse.BodyHandlers;
//
//import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
//import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class CheckResponseWhenSendRequestSuccessfullySteps {
//	String givenurl, method;
//	HttpResponse<String> response;
//	
//	@Given("I have url and method")
//	public void i_have_url_and_method() {
//	  givenurl = "https://simple-tool-rental-api.glitch.me/tools";
//	  method = "GET";
//	}
//
//	@When("I send tool request")
//	public void i_send_tool_request() {
//		URL url;
//		try {
////			url = new URL(givenurl);
////			HttpURLConnection con = (HttpURLConnection) url.openConnection();
////			con.setRequestMethod(method);
//			HttpRequest	request = HttpRequest.newBuilder().uri(new URI(givenurl)).GET().build();
//			response =  HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
//	}
//	@When("I send tool request with param {string} and {int} and available {boolean}")
//	public void i_send_tool_request_with_category(String category, int results, boolean available ) {
//	    try {
//	        // Thêm tham số query vào URL
//	        String query = String.format("?category=%s&results=%d&available=%b", category, results, available);
//	        givenurl = "https://simple-tool-rental-api.glitch.me/tools" + query;
//
//	        HttpRequest request = HttpRequest.newBuilder()
//	            .uri(new URI(givenurl))
//	            .GET()
//	            .build();
//	        	//response: lưu trữ phản hồi nhận từ API, phản hồi chứa thông tin như status code, body...
//	        response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	@Then("Status code is returned as {int}")
//	public void status_code_is_returned_as(Integer int1) {
//	   assertEquals( response.statusCode(), 200);
//	}
//
//	@Then("Response body is correctly")
//	public void response_body_is_correctly() {
//	  
//	}
//	@Then("Response body matches category {string} and {int} and available {boolean}")
//	public void response_body_matches_category(String category, int results, boolean available ) {
//	    String responseBody = response.body();// lấy nội dung phản hồi, lưu dưới dạng chuỗi 
//	    assertNotNull(responseBody, "Response body should not be null");// kiểm tra response ko rỗng
//	    //ObjectMapper chuyển đổi chuỗi Json thành đối tượng Java.
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    try {
//	        JsonNode rootNode = objectMapper.readTree(responseBody);//Phân tích chuỗi JSON trong responseBody và lưu dưới dạng cây (JsonNode).
//
//	        // Kiểm tra body là một mảng JSON
//	        assertTrue(rootNode.isArray(), "Response body should be an array");
//	        
//	        assertTrue(rootNode.size()<= results, "Number of results exceeds expected limit");
////	        assertEquals(rootNode.size(), results, "Number of results exceeds expected limit");
//
//	        // Duyệt qua từng công cụ trong danh sách và kiểm tra category
//	        for (JsonNode tool : rootNode) {
//	            assertEquals(tool.get("category").asText(), category, "Category mismatch");
//	            boolean expectAvailable = tool.get("inStock").asBoolean();
//	            assertEquals(available, expectAvailable, "Tool availability mismatch");
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
//
//
//
//}
