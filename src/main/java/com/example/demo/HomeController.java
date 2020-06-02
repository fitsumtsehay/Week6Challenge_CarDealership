package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CarCategoryRepository carCategoryRepository;


    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("allCarCategory", carCategoryRepository.findAll());
        return "list";
    }

    @RequestMapping("/newcarCategory")
    public String newCarCategory(Model model) {
        model.addAttribute("category", new CarCategory());
        return "newCarCategory";
    }
     @RequestMapping("/newcar")
     public String newCar(Model model){
         model.addAttribute("allcarCategory", carCategoryRepository.findAll());
         model.addAttribute("newcar", new Car());
         return "newcar";
        }
    @PostMapping("processCar")
    public String processCar(@Valid Car car){
         carRepository.save(car);
         return "redirect:/";
        }
    @PostMapping("processcarCategory")
    public String procressCategory(@ModelAttribute("category") CarCategory carCategory){
        carCategoryRepository.save(carCategory);
        return "redirect:/";
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
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
}}