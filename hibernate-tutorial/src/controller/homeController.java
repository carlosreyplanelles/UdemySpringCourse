package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class homeController {
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	
}
