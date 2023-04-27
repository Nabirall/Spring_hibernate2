package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;

public class CarServiceImp implements CarService{
@Autowired
private CarDao carDao;
@Override
public void add(Car car) {
    carDao.add(car);
}
}
