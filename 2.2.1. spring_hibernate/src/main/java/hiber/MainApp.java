package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
public static void main(String[] args) throws SQLException {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    UserService userService = context.getBean(UserService.class);


//
//    User user1=new User("Kolya","Pavlov","dqwdq13");
//    Car car1=new Car("BMW",123);
//    car1.setCarUser(user1);
    userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
    userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
    userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
    userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
    List<User> oio=userService.listUsers();

    CarService carService = context.getBean(CarService.class);
    carService.add(new Car("BMW", 10, oio.get(0)));
    carService.add(new Car("AUDI", 20, "user2@mail.ru"));
    carService.add(new Car("lamba", 30, "user3@mail.ru"));
    carService.add(new Car("giw",40, "user4@mail.ru"));


    List<User> users = userService.listUsers();
    for (User user : users) {
        System.out.println("Id = " + user.getId());
        System.out.println("First Name = " + user.getFirstName());
        System.out.println("Last Name = " + user.getLastName());
        System.out.println("Email = " + user.getEmail());
        System.out.println();
    }

    context.close();
}
}
