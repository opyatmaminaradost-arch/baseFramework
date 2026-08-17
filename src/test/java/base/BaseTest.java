package base;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import steps.*;

import config.ApiSpecs;

public abstract class BaseTest {

  protected static RequestSpecification requestSpec;

    @BeforeAll
    static void setUp(){
      requestSpec = ApiSpecs.defaultSpec();
    }
}
