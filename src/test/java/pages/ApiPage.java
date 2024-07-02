package pages;

import helper.endPoint;
import helper.utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.model.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.FILE;

public class ApiPage {

    String setUrl;
    Response resp;

    public void preapreUrl(String activeUrl){
        switch (activeUrl) {
            case "GET_ALL_LIST":
                setUrl = endPoint.GET_ALL_LIST;
                break;
            case "GET_SPESIFIC_USER":
                setUrl = endPoint.GET_SPESIFIC_USER;
                break;
            case "DELETE_USER":
                setUrl = endPoint.DELETE_USER;
                break;
            case "CREATE_USER":
                setUrl = endPoint.CREATE_USER;
                break;
            default:

                System.out.println("masukkan url yang benar");
        }
        System.out.println("url yang terpakai adalah : " + setUrl);
    }

    public void verifyStatusCode(int statusCode){
        assertThat(resp.statusCode()).isEqualTo(statusCode);
    }

    public void  verifyWithJsonSchema(String fileName){
        File Jsonfile = utility.getJsonSchemaFile(fileName);
        resp.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(Jsonfile));
    }

// GET ALL LIST
    public void hitApiForGetListUsers(){
        resp = getListUsers(setUrl);
        System.out.println(resp.getBody().asString());
    }

    public void verifyResponseBodyForGetAllUsers() {
        // Mengambil data dari respons JSON
        List<Object> id = resp.jsonPath().getList("data.id");
        List<Object> email = resp.jsonPath().getList("data.email");
        List<Object> first_name = resp.jsonPath().getList("data.first_name");
        List<Object> last_name = resp.jsonPath().getList("data.last_name");
        List<Object> avatar = resp.jsonPath().getList("data.avatar");

        // Melakukan assertion untuk memastikan tidak ada nilai yang null
        assertThat(id.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(first_name.get(0)).isNotNull();
        assertThat(last_name.get(0)).isNotNull();
        assertThat(avatar.get(0)).isNotNull();
    }

//    GET SPESIFIC
    public void hitApiForGetSpesificUsers(int userid){
        resp = getSpesificUsers(setUrl, userid);
        System.out.println(resp.getBody().asString());
    }

    public void verifyResponseBodyForGetSpesificUser(){
        Integer id = resp.jsonPath().getInt("data.id");
        String email = resp.jsonPath().getString("data.email");
        String firstName = resp.jsonPath().getString("data.first_name");
        String lastName = resp.jsonPath().getString("data.last_name");
        String avatar = resp.jsonPath().getString("data.avatar");

        assertThat(id).isEqualTo(7);
        assertThat(email).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(avatar).isNotNull();
    }

//    DELETE USER
    public void hitApiForDeleteSpesificUser(int deleteId){
        resp = deleteSpesificId(setUrl, deleteId);
    }

// CREATE USER
    public void hitApiForCreateNewUser(){
        resp = createNewUser(setUrl);
        System.out.println("hasil hit apinya adalah : " + resp.getBody().asString());
    }

    public void verifyResponseBodyForCreateUser(){
        JsonPath JsonPathEvaluator = resp.jsonPath();

        String id = JsonPathEvaluator.get("id"); // Mengambil id sebagai String
        String email = JsonPathEvaluator.get("email");
        String firstName = JsonPathEvaluator.get("first_name");
        String lastName = JsonPathEvaluator.get("last_name");
        String avatar = JsonPathEvaluator.get("avatar");

        // Assertion
        assertThat(id).isNotNull();
        assertThat(email).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(avatar).isNotNull();
    }
}
