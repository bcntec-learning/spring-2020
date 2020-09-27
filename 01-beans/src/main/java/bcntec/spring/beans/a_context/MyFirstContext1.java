package bcntec.spring.beans.a_context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"bcntec.spring.beans.a_context"}, basePackageClasses = {MyFirstContext1.class})
public class MyFirstContext1 {

}
