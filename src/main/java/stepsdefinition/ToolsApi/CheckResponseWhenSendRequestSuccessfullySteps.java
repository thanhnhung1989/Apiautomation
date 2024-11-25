package stepsdefinition.ToolsApi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.lang.module.Configuration;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.Configurations;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseWhenSendRequestSuccessfullySteps {
	String givenUrl, method;
	HttpResponse<String> response;

	@Given("I have url and method")
	public void i_have_url_and_method(List<Map<String, String>> givenTable) {
		String configsFile = System.getProperty("user.dir") + "\\src\\main\\resources\\Configs.properties";
		Configurations config = new Configurations(configsFile);
		String baseUrl = config.getConfigValueByKey("baseUrl");

		Map<String, String> map = givenTable.get(0);// lấy phần tử đầu tiên của danh sách
		String endpoint = map.get("URL");// lấy giá trị của khóa "URL" tức là: "/tools?category=ladders&results=2".
		givenUrl = baseUrl + endpoint; // tạo url hoàn chỉnh
		method = map.get("Method");// lấy giá trị của khóa "Method" tức là GET

	}

	@When("I send tool request")
	public void i_send_tool_request() {
		URL url;
		try {
//			url = new URL(givenurl);
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod(method);
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(givenUrl)).GET().build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
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

	@Then("Response return status code and body successfully")
	public void status_code_is_returned_as() {
		assertEquals(response.statusCode(), 200);
		// verify response body:
		JSONParser parser = new JSONParser();// JSONParser sẽ giúp chuyển chuỗi JSON (string) thành các đối tượng Java
		try {
			JSONArray jsonArray = (JSONArray) parser.parse(response.body());// JSONArray chứa một danh sách các đối tượng JSON
			// (hoặc các giá trị khác như chuỗi, số, v.v.), và bạn có thể duyệt qua nó để lấy từng phần tử trong mảng.
			assertEquals(jsonArray.size(), 2);
			int count = 0;
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject tool = (JSONObject) jsonArray.get(i);//sử dụng lớp JSONObject để làm việc với các thuộc tính của các phần tử
				String category = tool.get("category").toString();
				String inStock = tool.get("inStock").toString();
				if (category.equalsIgnoreCase("ladders") && inStock.equalsIgnoreCase("true")) {
					count = count + 1;
				}
			}
			assertEquals(count, jsonArray.size());

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("Response body is correctly")
	public void response_body_is_correctly() {

	}
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

}
