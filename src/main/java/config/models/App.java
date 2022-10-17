package config.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    Map<String, Object> properties = new LinkedHashMap<>();

    @JsonAnySetter
    public void setAppProperties(String key, Object value) { properties.put(key, value); }

    @JsonAnyGetter
    public Map<String, Object> getAppProperties() { return properties; }
}
