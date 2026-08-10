package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
    }

    @AfterEach
    void tearDown(){

    }
}
