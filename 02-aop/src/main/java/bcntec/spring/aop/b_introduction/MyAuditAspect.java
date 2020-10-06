package bcntec.spring.aop.b_introduction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Documented;
import java.util.List;

@Aspect
public class MyAuditAspect {

    @Autowired
    private List<String> accumulator;


    @Pointcut("execution(public * bcntec.spring.aop.b_introduction.MyBusiness+.run*(..))")
    public void runMethods() {
    }

    @Before("runMethods()")
    public void before(JoinPoint joinPoint) {
        accumulator.add("Method  [" + joinPoint.getSignature().getName() + "] before");
    }

    @After("runMethods()")
    public void after(JoinPoint joinPoint) {
        System.out.println("Method  [" + joinPoint.getSignature().getName() + "] after");
    }


    @Around("@annotation(MyAudit)") //Cacheable
    public Object myAudit(ProceedingJoinPoint joinPoint) throws Throwable {

        MyAudit t = joinPoint.getTarget().getClass().getAnnotation(MyAudit.class);

        String methodName = t.value().isEmpty() ? joinPoint.getSignature().getName() :  t.value();
        accumulator.add("Call to " + methodName);
        Object obj = joinPoint.proceed();
        accumulator.add("Method called successfully: " + methodName);
        return obj;
    }

    @AfterThrowing(value = "execution(public * bcntec.spring.aop.b_introduction.MyBusiness+.*(..))", throwing = "ex")
    public void exceptions(MyException ex) {
        accumulator.add("Error MyException");
    }


}