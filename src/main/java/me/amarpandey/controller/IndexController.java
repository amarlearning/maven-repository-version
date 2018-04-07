package me.amarpandey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.amarpandey.service.IndexService;

@RestController
public class IndexController {

  @Autowired private IndexService indexService;

  @PostMapping(value = "/submitXML", consumes = MediaType.APPLICATION_XML_VALUE)
  public String submitXML(@RequestBody String xmlData) {
    return indexService.submitXML(xmlData);
  }
}
