package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;

@Controller
public class CustomerController {
    ArrayList<Customer> list = new ArrayList<>();

    @Autowired
    ICustomerService iCustomerService;

    @RequestMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        list = iCustomerService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("list", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Customer customer) {
        iCustomerService.save(customer);
        return new ModelAndView("redirect:/show");
    }

    @GetMapping("/edit/{index}")
    public ModelAndView showEdit(@PathVariable int index) {
        ModelAndView modelAndView = new ModelAndView(("edit"));
        modelAndView.addObject("customer", list.get(index));
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Customer customer) {
        iCustomerService.edit(customer);
        return new ModelAndView("redirect:/show");
    }

    @GetMapping("/delete/{index}")
    public ModelAndView delete(@PathVariable int index) {
        iCustomerService.delete(list.get(index));
        return new ModelAndView("redirect:/show");
    }
}
