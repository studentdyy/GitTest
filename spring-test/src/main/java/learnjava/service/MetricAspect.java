package learnjava.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricAspect {
    @Around("@annotation(metricTime)")
    public Object metric(ProceedingJoinPoint joinPoint,MetricTime metricTime) throws Throwable{
        String name = metricTime.value();
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        }finally {
            long time = System.currentTimeMillis() - start;
            System.out.println("[Metrics]" + name + ": " + time + "ms");
        }
    }
}
