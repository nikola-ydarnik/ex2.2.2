package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
//4. Создайте сервис с методом, который будет возвращать указанное число машин из созданного списка.

public class CarServiceImpl implements CarService{

    //3. Создайте список из 5 машин.
    private List<Car> listOfCars;

    {
        listOfCars = new ArrayList<>();
        listOfCars.add(new Car(1, "lada", 9));
        listOfCars.add(new Car(2, "reno", 10));
        listOfCars.add(new Car(3, "merc", 11));
        listOfCars.add(new Car(4, "bmw", 12));
        listOfCars.add(new Car(5, "nissan", 13));
    }
    @Override
    public  List<Car> getCarsByAmount(int amount) {
        return listOfCars.stream().limit(amount).toList();
    }

    public List<Car> getAllCars() {
        return listOfCars;
    }
}
