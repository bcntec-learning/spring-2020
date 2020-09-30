package bcntec.spring.beans.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"bean2","!my_profile"})
@Component("FourthBean")
public class MyFourthBean2 implements FourthBean {
}
