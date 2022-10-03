package org.itstep.helloworldspring.controller;

import org.itstep.helloworldspring.Model.Car;
import org.itstep.helloworldspring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    public  CarController (CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/index")
    public String showSignUpForm(Car car) {
        return "index";
    }

    @GetMapping("/contact")
    public String showSignUpFormContact(Car car) {
        return "contact";
    }

    @GetMapping("/about")
    public String showSignUpFormAbout(Car car) {
        return "about";
    }

    @PostMapping("/contact")
    public String addCar(@Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contact";
        }

        carRepository.save(car);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String showUserList(Model model) {
        model.addAttribute("car", carRepository.findAll());
        return "orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        carRepository.deleteById(id);
        return "redirect:/index";
    }
}