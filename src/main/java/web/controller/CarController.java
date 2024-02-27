package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    private final CarService carService = new CarServiceImpl();

//    @GetMapping("/cars")
//    public String getCars(Model model) {
//        model.addAttribute("cars", carService.getAllCars());
//        return "show_all_cars";
//    }
//
//    @GetMapping("/cars/{count}")
//    public String getCarsByAmount(@PathVariable("count") int count, Model model) {
//        model.addAttribute("cars", carService.getCarsByAmount(count));
//        return "show_cars_by_amount";
//    }


//    Хорошо, но давай объединим getCars и getCarsByAmount. Они делают то же самое в сущности
    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null) {
            model.addAttribute("cars", carService.getAllCars());
        } else {
            model.addAttribute("cars", carService.getCarsByAmount(count));
        }
        return "cars";
    }
}
