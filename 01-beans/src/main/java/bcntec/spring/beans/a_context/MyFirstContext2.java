package bcntec.spring.beans.a_context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyFirstContext1.class)
public class MyFirstContext2 {

}
