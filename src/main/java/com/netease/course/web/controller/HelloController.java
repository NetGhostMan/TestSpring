package com.netease.course.web.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/spring")
	public void spring(HttpServletResponse httpServletResponse) throws IOException {
		httpServletResponse.getWriter().write("Hello,Spring");
	}

	@RequestMapping("/writer")
	public void testWriters(Writer writer) throws IOException {
		writer.write("Hello,Spring web!");
	}

	@RequestMapping("/users/{userId}")
	public void testPath(@PathVariable("userId") String userId, @RequestParam("msg") String msg,
			@RequestHeader("host") String host, Writer writer) throws IOException {
		writer.write("Hello,Spring web!" + userId + ", " + msg + ", " + host);
	}
}
