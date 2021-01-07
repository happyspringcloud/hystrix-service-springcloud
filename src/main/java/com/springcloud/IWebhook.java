package com.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@FeignClient( name="webhook", url="${webhook_url:http://localhost:9999}" )
public interface IWebhook {
	@GetMapping("/greeting/{param}")
    @ApiOperation(value="Get Greeting message")
    public String getGreeting(@PathVariable String param);
}
