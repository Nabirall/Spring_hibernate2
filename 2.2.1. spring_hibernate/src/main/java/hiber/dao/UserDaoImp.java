package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

@Autowired
private SessionFactory sessionFactory;

@Override
public void add(User user) {
    sessionFactory.getCurrentSession().save(user);
}

@Override
@SuppressWarnings("unchecked")
public List<User> listUsers() {
    TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
    return query.getResultList();
}

@Override
public List<User> findUserbyCar(String model, int series) {
    TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from cars where model = :model and series= :series")
            .setParameter("model", model)
            .setParameter("series", series);
    Car qwe=query.getResultList().get(3);
    TypedQuery<User> result=sessionFactory.getCurrentSession().createQuery("from users where id =:id")
            .setParameter("id",qwe);
    return result.getResultList();
}


}
