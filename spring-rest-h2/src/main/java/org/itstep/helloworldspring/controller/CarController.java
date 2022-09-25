package org.itstep.helloworldspring.controller;

import org.itstep.helloworldspring.Model.Car;
import org.itstep.helloworldspring.repository.CarRepository;
import org.itstep.helloworldspring.service.CarService;
import org.itstep.helloworldspring.service.CarServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    public  CarController (CarRepository carRepository) {
        this.carRepository = carRepository;
    }

//    @PostMapping(value = "/cars")
//    public Car save(@Valid @RequestBody Car car) {
//        return carService.save(car);
//    }
//
//    @GetMapping("/cars")
//    public List<Car> fetchCarList() {
//        return carService.fetchCarList();
//    }
//
//    @PutMapping("/cars/{id}")
//    public Car updateCar(@RequestBody Car car, @PathVariable("id") Long carId) {
//        return carService.updateCar(car, carId);
//    }
//
//    @DeleteMapping("/cars/{id}")
//    public String deleteCarById(@PathVariable("id") Long carId) {
//        carService.deleteCarById(carId);
//        return "Deleted Successfully";
//    }
    @GetMapping("/signup")
    public String showSignUpForm(Car car) {
        return "add-car";
    }

    @PostMapping("/addcar")
    public String addCar(@Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-car";
        }

        carRepository.save(car);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("car", carRepository.findAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));

        model.addAttribute("car", car);
        return "update-car";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Car car,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            car.setId(id);
            return "update-car";
        }

        carRepository.save(car);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        carRepository.deleteById(id);
        return "redirect:/index";
    }
}