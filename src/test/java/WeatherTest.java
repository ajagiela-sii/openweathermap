import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;

public class WeatherTest extends TestBase{

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    public void shouldGetCurrentWeatherForCityWithID(String city, String country, String cityId) {
        given().
                spec(getRequestSpec(cityId)).
        when().
                get().
        then().
                spec(getResponseSpec(city, country));
    }
}
