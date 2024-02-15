package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    private final CarService carService = new CarServiceImpl();

    @GetMapping("/cars")
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "show_all_cars";
    }

    @GetMapping("/cars/{count}")
    public String getCarsByAmount(@PathVariable("count") int count, Model model) {
        model.addAttribute("cars", carService.getCarsByAmount(count));
        return "show_cars_by_amount";
    }
}
