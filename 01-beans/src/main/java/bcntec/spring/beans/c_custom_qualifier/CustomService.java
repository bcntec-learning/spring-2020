package bcntec.spring.beans.c_custom_qualifier;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomService {
    @Autowired
    @CustomQualifier(status = StatusType.A)
    private CustomBean customBean;

    public CustomBean getCustomBean() {
        return customBean;
    }

    public void setCustomBean(CustomBean customBean) {
        this.customBean = customBean;
    }
} 