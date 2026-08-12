package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.datafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import specs.RequestSpecs;

public abstract class BaseTest {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    static void setUp(){

        requestSpec = RequestSpecs.forBaseUrl("https://restful-booker.herokuapp.com/");
        Faker faker = new Faker();
    }

    @AfterEach
    void tearDown(){

    }
}
