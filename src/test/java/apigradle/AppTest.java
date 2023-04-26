package apigradle;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AppTest {

    @BeforeClass
    public static void setup() {
//        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    @Test
    public void testeListaMetadadosDousuario() {
        when().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(HttpStatus.SC_OK).
                log().all().
                body("page", Matchers.is(2)).
                body("data", is(notNullValue()));
    }
    @Test
    public void testeCriarUsuarioComSucesso() {
        given().
               log().all().
               contentType(ContentType.JSON).
               body("{\n" +
                       "    \"name\": \"Rafael\",\n" +
                       "    \"job\": \"eng test\"\n" +
                       "}").
        when().
                post("https://reqres.in/api/users").
        then().
                log().all().
                statusCode(HttpStatus.SC_CREATED).
                body("name", is(("Rafael"))).
                body("job", is("eng test"));
    }
}
