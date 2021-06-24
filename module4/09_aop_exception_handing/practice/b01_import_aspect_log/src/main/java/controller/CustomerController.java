package controller;

import model.Customer;
//import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
//import service.ProvinceService;

import java.util.Optional;

@Controller
@RequestMapping(value = {"","/customers"})
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    @Autowired
//    private ProvinceService provinceService;

//    @ModelAttribute("provinces")
//    public Iterable<Province> allProvinces() {
//        return provinceService.findAll();
//    }

    @GetMapping(value = "")
    public ModelAndView showList(Optional<String> s, Pageable pageInfo) {
        ModelAndView modelAndView = new ModelAndView("/list");
        Page<Customer> customers = s.isPresent() ? search(s, pageInfo) : getPage(pageInfo);
        modelAndView.addObject("keyword", s.orElse(null));
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/info");
            Optional<Customer> customerOptional = customerService.findOne(id);
            modelAndView.addObject("customer", customerOptional.get());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }

    @PostMapping
    public ModelAndView updateCustomer(Customer customer) {
        customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }

    private Page<Customer> getPage(Pageable pageInfo) {
        return customerService.findAll(pageInfo);
    }

    private Page<Customer> search(Optional<String> s, Pageable pageInfo) {
        return customerService.search(s.get(), pageInfo);
    }
}
