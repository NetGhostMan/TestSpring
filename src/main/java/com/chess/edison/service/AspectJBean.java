package com.chess.edison.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJBean {

	@Before("execution(* *(..)) && args(a ..)")
	public void dolog(int a){
		System.out.println("执行: 如果有参数，参数是：" + a);
	}
}
