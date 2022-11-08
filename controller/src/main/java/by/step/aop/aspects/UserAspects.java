package by.step.aop.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@Aspect
public class UserAspects {

    @After("by.step.aop.pointcut.UserPointcuts.findAllPoint()")
    public void findAll(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

//---------UserClientController------------------------------------------------

    @After("by.step.aop.pointcut.UserPointcuts.findOneByNamePoint()")
    public void findOneByName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.UserPointcuts.getAmountClientPoint()")
    public void getAmountClient(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

//---------UserPhoneController------------------------------------------------

    @After("by.step.aop.pointcut.UserPointcuts.findOneByNumberPoint()")
    public void findOneByNumber(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.UserPointcuts.findPhonesByTariffNamePoint()")
    public void findPhonesByTariffName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.UserPointcuts.findPhonesByClientPoint()")
    public void findPhonesByClient(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

//---------UserTariffController-------------------------------------------------

    @After("by.step.aop.pointcut.UserPointcuts.sortTariffByPricePoint()")
    public void sortTariffByPriceAll(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.UserPointcuts.findTariffByParametersPoint()")
    public void findTariffByParameters(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }
}
