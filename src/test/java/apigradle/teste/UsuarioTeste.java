package apigradle.teste;

import apigradle.dominio.Usuario;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Test;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


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

    }
    @Test
    public void testeCriarUsuarioComSucesso() {
        Usuario usuario = new Usuario("Rafael", "eng test", "sydney@fife");
        given().
               log().all().
               contentType(ContentType.JSON).
               body(usuario).
        when().
                post("/users").
        then().
                log().all().
                statusCode(HttpStatus.SC_CREATED).
                body("name", is(("Rafael"))).
                body("job", is("eng test"));

    }
}
