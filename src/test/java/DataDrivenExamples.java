import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples {

    @Test
    public void Test_01_post(){
        JSONObject request = new JSONObject();

        request.put("name", "Brayan");
        request.put("job", "SDET");
        request.put("subjectId", "1");

        baseURI = "https://reqres.in/api/";
        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/Json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }
}
