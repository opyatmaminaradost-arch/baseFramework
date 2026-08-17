package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class ApiSpecs {
  
  private ApiSpecs(){

  }

  public static RequestSpecification defaultSpec(){
    return new RequestSpecBuilder()
    .setBaseUri(TestConfig.baseUrl())
    .setContentType(ContentType.JSON)
    .build();
  }

}
