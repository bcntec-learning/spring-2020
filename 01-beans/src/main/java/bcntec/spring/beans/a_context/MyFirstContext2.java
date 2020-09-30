package bcntec.spring.beans.a_context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = {"bcntec.spring.beans.b_context"})
@Import(MyFirstContext1.class)
public class MyFirstContext2 {

}
