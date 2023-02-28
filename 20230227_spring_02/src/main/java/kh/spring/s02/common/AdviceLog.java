package kh.spring.s02.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service //@component, bean 가능 하지만 의미상 service가 낫다.
@Aspect
public class AdviceLog {
	
	private static final Logger logger = LoggerFactory.getLogger(AdviceLog.class);
	
	
	// * 1개 이상이 종류 상관 없이 존재함
	// .. 0개 이상이 종류 상관 없이 존재함
	//                                           ~Controller
	@Pointcut("execution(public * kh.spring.s02..*Controller.*(..) )")
	public void controllerPointCut() {}
	// 위 pointcut의 이름은 "controllerPointCut()" 
	
	@Pointcut("execution(public * kh.spring.s02..*DAO.*(..) )")
	public void daoPointCut() {}
	
	@Pointcut("execution(public * kh.spring.s02..*ServiceImpl.*(..) )")
	public void serviceImplPointCut() {}
	
	@Around("controllerPointCut()")
	public Object aroundControllerPointCut(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObj =null;
		Object[] args= pjp.getArgs();//메서드의 매개변수들을 배열로 받는다.
		for(int i=0; i<args.length;i++) {
			logger.info("▶args["+i+"]:"+args[i]);
		}
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		returnObj = pjp.proceed();
		stopwatch.stop();
		
		logger.info("▶Controller Return["+stopwatch.getTotalTimeMillis()+"Millis]"+ returnObj);
		return returnObj;
	}
	@Around("daoPointCut()")
	public Object aroundDaoPointCut(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObj =null;
		Object[] args= pjp.getArgs();//
		for(int i=0; i<args.length;i++) {
			logger.info("▶▶args["+i+"]:"+args[i]);
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		returnObj = pjp.proceed();
		stopwatch.stop();
		
		logger.info("▶▶DAO Return["+stopwatch.getTotalTimeMillis()+"Millis]"+ returnObj);
		return returnObj;
	}
	
	@Around("serviceImplPointCut()")
	public Object aroundServiceImpl(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObj =null;
		Object[] args= pjp.getArgs();//
		for(int i=0; i<args.length;i++) {
			logger.info("▶▶▶args["+i+"]:"+args[i]);
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		returnObj = pjp.proceed();
		stopwatch.stop();
		
		logger.info("▶▶▶Service Return["+stopwatch.getTotalTimeMillis()+"Millis]"+ returnObj);
		return returnObj;
	}
	

	
	
	
}
