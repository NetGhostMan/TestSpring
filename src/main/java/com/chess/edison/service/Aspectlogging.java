package com.chess.edison.service;

import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Component
@Aspect
public class Aspectlogging {

	@Before("execution(* com.chess.edison.service.Service*.*(..))")
	public void dolog(JoinPoint jp) {
		String string = "日志：执行了:" + jp.getSignature().getName() + "方法。";
		String args = "";
		for (int i = 0; i < jp.getArgs().length; i++) {
			args = args + "," + jp.getArgs()[i];
		}
		if (!args.equals("")) {

			string = string + "这个方法的参数是：" + args;
		}else{
			string = string + "这个方法没有参数。";
		}
		System.out.println(string);
	}

	@AfterThrowing(pointcut = "execution(* com.chess.edison.service.Service*.*(..))", throwing = "ex")
	public void afterthrowdolog(Exception ex) {
		System.out.println("日志：这个方法抛出了异常，异常是:" + ex.getMessage());
	}

	@AfterReturning(pointcut = "execution(* com.chess.edison.service.Service*.*(..))", returning = "re")
	public void afterdolog(Object re) {
		if (re != null) {
			System.out.println("日志：这个函数正常运行。返回值是：" + re.toString());
		}else {
			System.out.println("日志：这个函数正常运行。没有返回值。");
		}
	}
}
