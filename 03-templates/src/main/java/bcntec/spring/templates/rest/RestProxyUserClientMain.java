package bcntec.spring.templates.rest;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication(scanBasePackageClasses = RestProxyUserClientMain.class)
public class RestProxyUserClientMain {


    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(RestProxyUserClientMain.class).run(args);
    }
}
