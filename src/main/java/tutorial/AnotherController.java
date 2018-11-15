package tutorial;

import com.juancho.Model.User;
import com.juancho.Repository.UserRepository;
import org.json.JSONArray;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class AnotherController {

    @RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Collection<User> getEmployees() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserRepository userRepository = context.getBean(UserRepository.class);

        return userRepository.selectUsers();
    }
}