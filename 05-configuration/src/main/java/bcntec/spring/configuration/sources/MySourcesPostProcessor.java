package bcntec.spring.configuration.sources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;


public class MySourcesPostProcessor implements EnvironmentPostProcessor {

    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment,
                                       SpringApplication application) {
        environment.getPropertySources().addLast(load("default.yml", "META-INF/ais-default.yml"));
    }

    private PropertySource<?> load(String name, String path) {
        Resource resource = new ClassPathResource(path);
        if (!resource.exists()) {
            throw new IllegalArgumentException("Resource " + resource + " does not exist");
        }
        try {
            return this.loader.load(name, resource).get(0);
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to load configuration from " + path, ex);
        }
    }

}