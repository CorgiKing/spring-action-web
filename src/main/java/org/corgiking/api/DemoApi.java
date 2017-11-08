package org.corgiking.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoApi {

	@GetMapping("/s")
	public String getS(){
		System.out.println("SSS");
		return "SSS";
	}
	
}
