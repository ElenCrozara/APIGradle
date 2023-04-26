package apigradle;

import org.hamcrest.Matchers;
import org.junit.Test;



import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    public void testeListaMetadadosDousuario() {
        when().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(HttpStatus.SC_OK)
                .log().all()
                .body("page", Matchers.is(2))
                .body("data", is(notNullValue()))


        ;
    }
}
