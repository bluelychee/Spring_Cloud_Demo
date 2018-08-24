package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/ribbon-consumer")
	@HystrixCommand(fallbackMethod = "helloConsumerError")
	public  String helloConsumer() {
		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}


	public  String helloConsumerError() {
		return "false";
	}
}
