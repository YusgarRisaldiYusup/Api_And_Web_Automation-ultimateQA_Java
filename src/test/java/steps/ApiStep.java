package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;
public ApiStep(){
    this.apiPage = new ApiPage();
}
//    ALL STEP
    @Given("preapre url for {string}")
    public void preapreUrlFor(String activeUrl) {
        apiPage.preapreUrl(activeUrl);
    }

    @And("verify status code {int}")
    public void verifyStatusCode(int statusCode) {
         apiPage.verifyStatusCode(statusCode);
    }

    @And("verify with json schema {string}")
    public void verifyWithJsonSchema(String fileName) {
        apiPage.verifyWithJsonSchema(fileName);
    }


//    GET ALL STEP

    @And("hit api for get list users")
    public void hitApiForGetListUsers() {
        apiPage.hitApiForGetListUsers();
    }


    @Then("verify response body for get all users")
    public void verifyResponseBodyForGetAllUsers() {
        apiPage.verifyResponseBodyForGetAllUsers();
    }

//    GET SPESIFIC STEP

    @And("hit api for get spesific user id {int}")
    public void hitApiForGetSpesificUserId(int userId) {
        apiPage.hitApiForGetSpesificUsers(userId);
    }

    @Then("verify response body for get spesific user")
    public void verifyResponseBodyForGetSpesificUser() {
        apiPage.verifyResponseBodyForGetSpesificUser();
    }

//    DELETE SPESIFIC USER

    @And("hit api for delete spesific user id {int}")
    public void hitApiForDeleteSpesificUserId(int deleteId) {
        apiPage.hitApiForDeleteSpesificUser(deleteId);
    }


//    CREATE USER

    @And("hit api for create new user")
    public void hitApiForCreateNewUser() {
         apiPage.hitApiForCreateNewUser();
    }

    @Then("verify response body for create user")
    public void verifyResponseBodyForCreateUser() {
        apiPage.verifyResponseBodyForCreateUser();
    }

}
