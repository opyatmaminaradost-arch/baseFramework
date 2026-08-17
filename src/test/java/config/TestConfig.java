package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestConfig {
  
  private static final Properties properties = new Properties();

  static {
    try (InputStream input = TestConfig.class
                          .getClassLoader()
                          .getResourceAsStream("config.properties")) {
        if (input == null){
          throw new IllegalStateException("config.properties not found");
        }

        properties.load(input);
      
    } catch (IOException e){
      throw new RuntimeException("Failed ot load config", e);
    }
  }

  private TestConfig(){
  }

  public static String baseUrl(){
    return properties.getProperty("base.url");
  }
}
