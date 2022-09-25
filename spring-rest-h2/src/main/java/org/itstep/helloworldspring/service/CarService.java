package org.itstep.helloworldspring.service;

import org.itstep.helloworldspring.Model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {

    // Save operation

    Car save(Car car);

    // Read operation
    List<Car> fetchCarList();

    // Update operation
    Car updateCar(Car car , Long id);

    Optional <Car> findById (Long Id);

    // Delete operation
    void deleteCarById(Long Id);
}
