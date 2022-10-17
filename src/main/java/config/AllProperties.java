package config;

import config.models.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AllProperties {

    static Logger logger = LoggerFactory.getLogger(AllProperties.class);
    YamlReader yamlReader = new YamlReader();
    private App app;

    private AllProperties() {
        setAppProperties();
    }

    public static AllProperties getInstance() {
        return AllProperties.AllPropertiesSingleton.INSTANCE;
    }

    private void setAppProperties() {
        app = yamlReader.getConfig().getApp();
        Map<String, Object> appProperties = app.getAppProperties();
        for (Map.Entry entry : appProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Load app properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static class AllPropertiesSingleton {
        private static final AllProperties INSTANCE = new AllProperties();
    }
}
