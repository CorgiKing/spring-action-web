package org.corgiking.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class demoApi {

	@GetMapping("/s")
	public String getS(){
		return "SSS";
	}
	
}
