package me.amarpandey.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@PostMapping(value = "/submitXML", consumes = MediaType.APPLICATION_XML_VALUE)
	public String submitXML(@RequestBody String xmlData) {
		return xmlData;
	}
}