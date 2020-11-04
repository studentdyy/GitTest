package learnjava;

import learnjava.service.AppService;
import learnjava.service.User;
import learnjava.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@example.com", "password");
        AppService appService = context.getBean(AppService.class);
        System.out.println(user.getName());
        System.out.println(appService.logo);
        User user1 = userService.register("123@example.com","123","Oppo");
    }
}
