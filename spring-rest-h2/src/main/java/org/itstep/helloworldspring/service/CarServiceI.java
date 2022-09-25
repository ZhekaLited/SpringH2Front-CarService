package org.itstep.helloworldspring.service;

import org.apache.commons.lang3.StringUtils;
import org.itstep.helloworldspring.Model.Car;
import org.itstep.helloworldspring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarServiceI implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> fetchCarList() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car updateCar(Car car, Long id) {
        Car carDB = carRepository.findById(id).get();

        if (StringUtils.isNotBlank(car.getCarName())) {
            carDB.setCarName(car.getCarName());
        }

        if (Objects.nonNull(car.getCarColor()) && !"".equalsIgnoreCase(car.getCarColor())) {
            carDB.setCarColor(car.getCarColor());
        }

        if (Objects.nonNull(car.getCarModel()) && !"".equalsIgnoreCase(car.getCarModel())) {
            carDB.setCarModel(car.getCarModel());
        }

        return carRepository.save(carDB);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}
