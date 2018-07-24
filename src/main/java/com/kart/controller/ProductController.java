package com.kart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kart.domain.Demo;
import com.kart.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@ComponentScan(basePackages = { "com.kart" })
public class ProductController {
	
	@Autowired
	public ProductService productService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/hello")
	@ApiOperation(value = "Get Hello World", nickname = "GET Method", 
	notes = "This endpoint retrieves Hello World", produces = "application/json")
	public String getHelloWorld(@RequestHeader(value = "authToken", required = false) String authToken,
			@RequestParam(value = "id", required = false) Integer id) throws Exception {
		logger.info("I'm in getHelloWorld() to return Hello World!");
		return "Hello World";
	}
	
	@GetMapping(value = "/helloFromDB")
	@ApiOperation(value = "Get Hello World From DB", nickname = "GET Method", 
	notes = "This endpoint retrieves Hello World From DB", produces = "application/json")
	public Demo getHelloWorldFromDB(@RequestHeader(value = "authToken", required = false) String authToken,
			@RequestParam(value = "id", required = false) Integer id) throws Exception {
		logger.info("I'm in getHelloWorld() to return Hello World! From DB");
		return productService.getDemoObjById(id);
	}
	
}
