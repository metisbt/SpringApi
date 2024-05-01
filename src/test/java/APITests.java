import com.example.springapi.topic.Topic;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;



public class APITests {

    @Test
    public void TestaddTopic(){

//        baseURI = "localhost:8080";
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("id", "testNG");
//        map.put("name", "testNG title");
//        map.put("description", "testNG description");
//
        JSONObject request = new JSONObject();

        request.put("id","testNG");
        request.put("name","testNG title");
        request.put("description","testNG description");

        given().
            contentType(ContentType.JSON).
        accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            post("http://localhost:8080/topics").
        then().
            statusCode(200);



    }
}
