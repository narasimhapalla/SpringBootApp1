package com.palla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@GetMapping("customer")
	public String edureka() {
		return "CustomerInput";
	}
	
	@PostMapping("details")
	public String viewDetails(@RequestParam("cid") String cid,
			@RequestParam("cname") String cname,
			@RequestParam("cemail") String cemail, ModelMap modelMap) {
		modelMap.put("customerID", cid);
		modelMap.put("customerName", cname);
		modelMap.put("customerEmail", cemail);
		return "CustomerDetails";
	}

}
