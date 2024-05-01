import com.example.springapi.topic.Topic;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;



public class APITests {



    @Test
    public void TestaddTopic(){
        baseURI = "http://localhost:8080";

//        baseURI = "localhost:8080";
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("id", "testNG");
//        map.put("name", "testNG title");
//        map.put("description", "testNG description");

        JSONObject request = new JSONObject();

        request.put("id","testNG");
        request.put("name","testNG title");
        request.put("description","testNG description");

        given().
            contentType(ContentType.JSON).
        accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            post("/topics").
        then().
            statusCode(200);
    }

    @Test
    public void TestgetTopic(){
        baseURI = "http://localhost:8080";

        given().get("/topics").then().statusCode(200).body("id", equalTo("testNG"));
    }

    @Test
    public void TestupdateTopic(){
        baseURI = "http://localhost:8080";

        JSONObject request = new JSONObject();

        request.put("id","testNG");
        request.put("name","updated testNG title");
        request.put("description","updated testNG description");

        given().contentType(ContentType.JSON).accept(ContentType.JSON).put("/topics/request.get(\"id\")").then().statusCode(200);
    }


    @Test
    public void TestdeleteTopic(){
        baseURI = "http://localhost:8080";

        when().delete("topics/testNG").then().statusCode(200);
    }

}
