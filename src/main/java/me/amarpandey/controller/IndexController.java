package me.amarpandey.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@PostMapping(value = "/submitXML", consumes = "application/x-www-form-urlencoded")
	public String submitXML(@RequestParam("xmlData") String xmlData) {
		return xmlData;
	}
}