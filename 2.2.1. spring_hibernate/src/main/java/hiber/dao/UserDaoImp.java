package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
@SuppressWarnings("unchecked")
public User findUserbyCar(String model, int series) {
    TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User user where user.car.model = :model and user.car.series = :series");
    query.setParameter("model", model).setParameter("series", series);
    return query.setMaxResults(1).getSingleResult();
}

@Override
@SuppressWarnings("unchecked")
public User findUserbyCars(Car car) {
    String hql = "from User user where user.car.model = :model and user.car.series = :series";
    TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
    query.setParameter("model", car.getModel()).setParameter("series", car.getSeries());
    return query.setMaxResults(1).getSingleResult();
}
}
