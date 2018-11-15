import com.juancho.Model.User;
import com.juancho.Repository.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserRepository userRepository = context.getBean(UserRepository.class);

       // User user = new User("Antonio", "antoine");
        //userRepository.addUser(user);

        for(User user1 : userRepository.selectUsers()) {
            System.out.println(user1.toString());
        }

       /* System.out.println(userRepository.selectUser(user.getId()).toString());

        System.out.println(userRepository.deleteUser(user.getId()+5));
        System.out.println(userRepository.deleteUser(user.getId()));

        for(User user1 : userRepository.selectUsers()) {
            System.out.println(user1.toString());
        }*/
    }
}
