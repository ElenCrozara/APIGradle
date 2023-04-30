package apigradle.teste;

import apigradle.dominio.Usuario;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


public class TesteRegistro extends TesteBase {

    private static final String REGISTRA_USUARIO_ENDPOINT = "/register";

    @Test
    public void testNãoEfetuaRegistroQuandoSenhaEstaFaltando() {
        Usuario usuario = new Usuario() ;
        usuario.setEmail("sydney@fife");

        given().
                body(usuario).
                log().all().
        when().
                post(REGISTRA_USUARIO_ENDPOINT).
        then().
                log().all().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                body("error", is("Missing password"));

    }
}
