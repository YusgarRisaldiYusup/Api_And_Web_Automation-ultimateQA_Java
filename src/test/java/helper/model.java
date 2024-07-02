package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.utility.generateRandomEmail;

public class model {

    private static RequestSpecification request;

    public static void setupHeader (){

        request = RestAssured.given()
                .headers("Content-Type", "application/json")
                .headers("accept", "application/json");
    }

    public static Response getListUsers(String endpoint){
            setupHeader();
            return request.when().get(endpoint);
    }

    public static Response getSpesificUsers(String endpoint, int userId){
        setupHeader();
        return request.when().get(endpoint+userId);
    }

    public static Response deleteSpesificId(String endpoint, int deleteId){
        setupHeader();
        return request.when().delete(endpoint+deleteId);
    }

    public static Response createNewUser(String endpoint){

        String email = generateRandomEmail();
        String first_name = "Yusgar Risaldi ";
        String last_name = "Yusup";
        String avatar = "https:exampleimage.jpg";
        JSONObject payload = new JSONObject();
        payload.put("email", email);
        payload.put("first_name", first_name);
        payload.put("last_name", last_name);
        payload.put("avatar", avatar);

        setupHeader();
        return request.body(payload.toString()).when().post(endpoint);
    }

}

