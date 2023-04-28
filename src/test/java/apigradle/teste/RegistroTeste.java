package apigradle.teste;

import apigradle.dominio.Usuario;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


public class RegistroTeste extends BaseTeste{

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
