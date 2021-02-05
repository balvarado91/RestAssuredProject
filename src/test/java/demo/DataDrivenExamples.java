package demo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples extends DataForTests {
    //@Test(dataProvider = "dataForPost")
    public void testPost(String firstName, String lastName, int subjectId) {
        JSONObject request = new JSONObject();

        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/Json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log()
                .all();
        System.out.println(request);
    }

    //@Test(dataProvider = "DeleteData")
    public void testDelete(int userId) {
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200)
                .log()
                .all();

    }

    @Parameters({"userId"})
    @Test
    public void testDelete2(int userId) {
        System.out.println("Value for userId is: " + userId);
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200)
                .log()
                .all();

    }
}
