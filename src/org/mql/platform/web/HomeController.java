package org.mql.platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chermehdi
 */
@Controller
public class HomeController {

	@GetMapping("/demo")
	public String get(Model model) {

		// added a comment
		model.addAttribute("message", "hello world");
		return "demo";
	}
}
