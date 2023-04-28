package apigradle.teste;

import apigradle.dominio.Usuario;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;


public class RegistroTeste {

    @BeforeClass
    public static void setup() {
        baseURI = "https://reqres.in";
        basePath = "/api";
    }
    @Test
    public void testNãoEfetuaRegistroQuandoSenhaEstaFaltando() {
        Usuario usuario = new Usuario() ;
        usuario.setEmail("sydney@fife");

        given().
                contentType(ContentType.JSON).
                body(usuario).
                log().all().
        when().
                post("/register").
        then().
                log().all().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                body("error", is("Missing password"));

    }
}
