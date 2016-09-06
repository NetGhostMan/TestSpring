package com.netease.course.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/spring")
	public void spring(HttpServletResponse httpServletResponse) throws IOException{
		httpServletResponse.getWriter().write("Hello,Spring");
	}
}
