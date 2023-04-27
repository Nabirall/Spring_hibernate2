package hiber.model;

import javax.persistence.*;


@Entity
@Table(name = "cars")
public class Car {
public Car(String model, int series) {
    this.model = model;
    this.series = series;
}
@OneToOne()
@JoinColumn(name = "user_id")
private Car carUser;


public Car getCarUser() {
    return carUser;
}

public void setCarUser(Car carUser) {
    this.carUser = carUser;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public Car() {
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column
private String model;

@Column
private int series;

@Column(name = "user_id")
private int userId;

public String getModel() {
    return model;
}

public void setModel(String model) {
    this.model = model;
}

public int getSeries() {
    return series;
}

public void setSeries(int series) {
    this.series = series;
}

@Override
public String toString() {
    return "Car{" +
            "model='" + model + '\'' +
            ", series=" + series +
            '}';
}
}
