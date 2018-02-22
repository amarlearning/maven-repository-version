package me.amarpandey.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(@RequestBody String pomxml) {
		return pomxml;
	}
}