package com.springcloud;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api")
public class HystrixController {
	@GetMapping("/coffees/{param}")
	public List<String> getCoffees(@PathVariable String param) {
		if(!"pass".equals(param)) {
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				
			}
		}
		
		return Arrays.asList("latte", "mocha");
	}
	
	@GetMapping("/juices")
	public List<String> getJuices() {
		try {
			Thread.sleep(30);
		} catch(Exception e) {
			
		}		
		
		return Arrays.asList("orange", "apple", getGreeting());
	}
	
	@Autowired
	private IWebhook webhook;
	private String getGreeting() {
		String greeting = webhook.getGreeting("Hello");
		return greeting;
	}
	
	
}

