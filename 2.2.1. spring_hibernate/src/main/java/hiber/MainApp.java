package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
public static void main(String[] args) throws SQLException {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    UserService userService = context.getBean(UserService.class);

    User User1 = (new User("User1", "++", "User1@mail.ru"));
    User User2 =(new User("User2", "__", "User2@mail.ru"));
    User User3 =(new User("User3", "--", "User3@mail.ru"));
    User User4 =(new User("User4", "==", "User4@mail.ru"));

    Car Audi = new Car("Audi", 5);
    Car BMW = new Car("BMW", 6);
    Car Mercedes = new Car("Mercedes", 200);
    Car lamba = new Car("lamba", 1);

    List<User> users = userService.listUsers();
    for (User user : users) {
        System.out.println("Id = "+user.getId());
        System.out.println("First Name = "+user.getFirstName());
        System.out.println("Last Name = "+user.getLastName());
        System.out.println("Email = "+user.getEmail());
        System.out.println();
    }

    userService.add(User1.setCar(Audi).setUser(User1));
    userService.add(User2.setCar(BMW).setUser(User2));
    userService.add(User3.setCar(Mercedes).setUser(User3));
    userService.add(User4.setCar(lamba).setUser(User4));


    context.close();
}
}
