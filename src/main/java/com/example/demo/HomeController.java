package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CarCategoryRepository carCategoryRepository;


    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("allCarCategory", carCategoryRepository.findAll());
        return "list";
    }

    @RequestMapping("/newcarCategory")
    public String newCarCategory(Model model) {
        model.addAttribute("carCategory", new CarCategory());
        return "newcarCategory";
    }
     @RequestMapping("/newcar")
     public String newCar(Model model){
         model.addAttribute("allcarCategory", carCategoryRepository.findAll());
         return "newcar";
        }
    @PostMapping("processCar")
    public String processCar(@ModelAttribute("car") Car car){
         carRepository.save(car);
         return "redirect:/list";
        }
    @PostMapping("processcarCategory")
    public String procressCategory(@ModelAttribute("category") CarCategory carCategory){
        carCategoryRepository.save(carCategory);
        return "redirect:/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "newcar";
}

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        CarCategory carCategory = carCategoryRepository.findById(id).get();
        carCategoryRepository.delete(carCategory);
        return "redirect:/list";
    }
    @RequestMapping("/show/{id}")
    public String detail(@PathVariable("id") long id, Model model){
        model.addAttribute(carRepository.findById(id).get());
        Car car = carRepository.findById(id).get();

        return "showCar";
}}