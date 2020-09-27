package bcntec.spring.beans.c_custom_qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@CustomQualifier(status = StatusType.B)
public class CustomBeanB extends CustomBean {

}