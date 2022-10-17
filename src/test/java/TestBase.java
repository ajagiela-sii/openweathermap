import config.AllProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.Matchers.is;

public class TestBase {

    private static AllProperties allProperties;

    @BeforeAll
    static void setUp() {
        allProperties = AllProperties.getInstance();
    }

    public RequestSpecification getRequestSpec(String cityID) {
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("baseUri"))
                .setBasePath(System.getProperty("basePath"))
                .addParam("appid",System.getProperty("appId"))
                .addParam("id", cityID)
                .setContentType(ContentType.JSON)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public ResponseSpecification getResponseSpec(String city, String country) {
        return new ResponseSpecBuilder()
                .expectBody("name", is(city))
                .expectBody("sys.country", is(country))
                .expectStatusCode(200)
                .build();
    }
}
