import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples {

    @DataProvider(name = "dataForPost")
    public Object[][] dataForPost(){
        //Excel with 2 rows 3 columns
        Object[][] data = new Object[2][3];
        data[0][0] = "Brayan";
        data[0][1] = "Alve";
        data[0][2] = 2;

        data[1][0] =  "Laika";
        data[1][1] =  "Gaty";
        data[1][2] = 1;

        return data;
    }

    @Test(dataProvider = "dataForPost")
    public void testPost(String firstName, String lastName, int subjectId){
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
}
