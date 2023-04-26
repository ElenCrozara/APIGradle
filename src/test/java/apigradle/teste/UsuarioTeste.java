package apigradle.teste;

import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Test;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.JVM)
public class UsuarioTeste {

    @BeforeClass
    public static void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api";
    }
    @Test
    public void testeListaMetadadosDousuario() {
        given().
                log().all().
                params("page","2").
        when().
                get("/users").
        then().
                statusCode(HttpStatus.SC_OK).
                body("page", Matchers.is(2)).
                body("data", is(notNullValue()));
        System.out.println("first");
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
        System.out.println("second");
    }
}
