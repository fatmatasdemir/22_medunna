package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
public class Authentication2 {
    public static String generateToken() {

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();

        Map<String,Object > data = new HashMap<String,Object>();
        data.put("username", "Batch81");
        data.put("password", "Batch81+");
        data.put("rememberMe", true);

        //Set the url
        spec.pathParams("1", "api", "2" , "authenticate");
        //Send the request and get the response / Request gonder  response elde et
        Response response    = given().spec(spec).contentType(ContentType.JSON).body(data).when().post("/{1}/{2}");
//        response.prettyPrint();
        JsonPath json = response.jsonPath();
        System.out.println("token : " +json.getString("id_token"));
        return  json.getString("id_token");
    }
    public static void main(String[] args) {

        String guncelToken = generateToken();
        System.out.println(guncelToken);
    }
}
