package com.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 以注解方式配置AOP
 * @Aspect: 注解表示声明一个类为一个切面
 * @Pointcut:定义一个关注点
 * 关注点表达式格式:execution(修饰符 返回类型 包名.[..表示包括子包下所有类]类.方法(参数))
 *  
 * @author Administrator
 *
 */
@Aspect
public class MyInterceptor {

	//定义一个关注点
//	@Pointcut("execution(* com.service..*.*(..))")
//	private void pointcutMethod(){}
	
	/**
	 * 前置通知
	 */
	@Before("execution(* com.service.impl.UserServiceImpl.add())")
	public void beforeMethod(){
		System.out.println("前置通知...");
	}
//	
//	/**
//	 * 后置通知
//	 */
//	@AfterReturning("execution(* com.service..*.*(..))")
//	public void afterReturningMethod(){
//		System.out.println("后置通知...");
//	}
//	
//	/**
//	 * 最终通知
//	 */
//	@After("execution(* com.service..*.*(..))")
//	public void afterMethod(){
//		System.out.println("最终通知...");
//	}
//	
//	/**
//	 * 异常通知
//	 */
//	@AfterThrowing("execution(* com.service..*.*(..))")
//	public void throwsMethod(){
//		System.out.println("异常通知...");
//	}
	
	/**
	 * 环绕通知
	 * @param p
	 * @return
	 */
	@Around("execution(* com.service..*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint p){
		Object result=null;
		System.out.println("环绕通知之前置通知...");
		try {
			result=p.proceed();
		} catch (Throwable e) {
			//e.printStackTrace();
			System.out.println("环绕通知之异常通知...");
		}finally{
			System.out.println("环绕通知之最终通知...");
		}
		System.out.println("环绕通知之后置通知...");
		return result;
	}
}
