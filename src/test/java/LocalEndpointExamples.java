import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LocalEndpointExamples {

    //Instructions to run it
    //https://github.com/typicode/json-server​
    //npm install -g json-server
    //json-server --watch db.json


    //@Test
    public void testGet(){
        baseURI = "http://localhost:3000";
        given()
                .param("name", "Automation")
                .get("/subjects")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    //@Test
    public void testPost(){
        JSONObject request = new JSONObject();

        request.put("firstName", "Fresia");
        request.put("lastName", "Alve");
        request.put("subjectId", 1);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                //.header("Content-Type", "application/Json")
                .body(request.toJSONString())
        .when()
                .post("/users")
        .then()
            .statusCode(201)
            .log()
            .all();
        System.out.println(request);
    }

    //@Test
    public void testPatch(){
        JSONObject request = new JSONObject();

        request.put("firstName", "Daniela");

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                //.header("Content-Type", "application/Json")
                .body(request.toJSONString())
                .when()
                .patch("/users/4")
                .then()
                .statusCode(200)
                .log()
                .all();
        System.out.println(request);
    }

    //@Test
    public void testPut(){
        JSONObject request = new JSONObject();

        request.put("firstName", "Lauren");
        request.put("lastName", "Alve");
        request.put("subjectId", 1);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/Json")
                .body(request.toJSONString())
        .when()
                .put("/users/5")
        .then()
                .statusCode(200)
                .log()
                .all();
        System.out.println(request);
    }

    @Test
    public void testDelete(){
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/6")
        .then()
                .statusCode(200)
                .log()
                .all();

    }
}
