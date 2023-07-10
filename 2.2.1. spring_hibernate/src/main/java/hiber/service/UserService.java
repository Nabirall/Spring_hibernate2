package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
void add(User user);

List<User> listUsers();

User findUserbyCar(String model, int series);

@Transactional(readOnly = true)
User findUserbyCars(Car car);
}
