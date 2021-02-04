import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Tests_POST {
    //@Test
    public void Test_01_post(){
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "Brayan");
//        map.put("job", "SDET");
//
//        System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("name", "Brayan");
        request.put("job", "SDET");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/Json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }
    //@Test
    public void Test_01_put(){
        JSONObject request = new JSONObject();

        request.put("name", "Brayan");
        request.put("job", "QA Automation");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/Json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
    //@Test
    public void Test_01_patch(){
        JSONObject request = new JSONObject();

        request.put("name", "Brayan");
        request.put("job", "QA Automation");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/Json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
    @Test
    public void Test_01_delete(){
        JSONObject request = new JSONObject();

        request.put("name", "Brayan");
        request.put("job", "QA Automation");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/Json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();
    }
}
