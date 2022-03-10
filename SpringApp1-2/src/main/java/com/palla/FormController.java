package com.palla;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FormController {
	@Autowired
	CustomerRep rep;
	
	@RequestMapping("/")
	public String edureka() {
		return "CustomerInput";
	}
	
	@RequestMapping("/details")
	public String details(Customers customers) {
		rep.save(customers);
		return "CustomerInput";
	}
	
	@RequestMapping("/getDetails")
	public String getDetails() {
		System.out.println("getDetails called");
		return "CustomerDetails";
	}
	
	
	@PostMapping("/getDetails")
	public ModelAndView getDetails(@RequestParam("cid") int cid) {
		ModelAndView model = new ModelAndView("Retrieve");
		Customers customers = rep.findById(cid).orElse(null); 
		model.addObject(customers);
		return model;
	}
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers() {
		
		return rep.findAll();
	}

	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomersById(@PathVariable("cid")int cid) {
		
		return rep.findById(cid);
	}
	@PostMapping("/customers")
	public Customers postCustomer(@RequestBody Customers customer) {
		rep.save(customer);
		return customer;
	}
}
