package bcntec.spring.templates.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "users", url = MyTemplate.apiUrl)
public interface UserClient {


    @RequestMapping(method = RequestMethod.GET, value = "/list-2", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<User> list();
}
