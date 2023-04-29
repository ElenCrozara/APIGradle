package apigradle.teste;

import apigradle.dominio.Usuario;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


public class UsuarioTeste extends BaseTeste{

    private static final String LISTA_USUARIOS_ENDPOINT = "/users"; // variaveis de endpoint que são passados no metodo
    private static final String CRIAR_USUARIO_ENDPOINT = "/user";

    @Test
    public void testeListaMetadadosDousuario() {
        given().
                log().all().
                params("page","2").
        when().
                get(LISTA_USUARIOS_ENDPOINT).
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
               body(usuario).
        when().
                post(CRIAR_USUARIO_ENDPOINT).
        then().
                log().all().
                statusCode(HttpStatus.SC_CREATED).
                body("name", is(("Rafael"))).
                body("job", is("eng test"));
    }
}
