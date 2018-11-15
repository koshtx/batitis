package tutorial;

import com.juancho.Model.User;
import com.juancho.Repository.UserRepository;
import com.mysql.cj.jdbc.Driver;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.juancho.Repository")
public class Application {
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource sdds = new SimpleDriverDataSource();
        sdds.setDriverClass(Driver.class);
        sdds.setUrl("jdbc:mysql://127.0.0.1:3306/testing?useSSL=false&serverTimezone=UTC");
        sdds.setUsername("root");
        return sdds;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserRepository userRepository = context.getBean(UserRepository.class);

        // User user = new User("Antonio", "antoine");
        //userRepository.addUser(user);

       /* for(User user1 : userRepository.selectUsers()) {
            System.out.println(user1.toString());
        }*/

       /* System.out.println(userRepository.selectUser(user.getId()).toString());

        System.out.println(userRepository.deleteUser(user.getId()+5));
        System.out.println(userRepository.deleteUser(user.getId()));

        for(User user1 : userRepository.selectUsers()) {
            System.out.println(user1.toString());
        }*/
    }
}
