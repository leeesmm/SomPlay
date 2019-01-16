package com.openobject.template.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sample")
@Slf4j
public class SampleController {

	@GetMapping(value = "/test")
	public String test() throws Exception {
		log.info("## test");
		return "test";
	}
}
