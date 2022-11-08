package by.step.aop.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j2
public class AdminAspects {

    @After("by.step.aop.pointcut.AdminPointcuts.findOneByIdPoint()")
    public void findOneById(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.findAllPoint()")
    public void findAll(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.removeByIdPoint()")
    public void removeById(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

//---------UserClientController------------------------------------------------

    @After("by.step.aop.pointcut.AdminPointcuts.saveClientPoint()")
    public void saveClient(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.addPhoneToClientPoint()")
    public void addPhoneToClient(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.getAmountClientPoint()")
    public void getAmountClient(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

//---------UserPhoneController------------------------------------------------

    @After("by.step.aop.pointcut.AdminPointcuts.savePhonePoint()")
    public void savePhone(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.addClientToPhonePoint()")
    public void addClientToPhone(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.addTariffToPhonePoint()")
    public void AddTariffToPhone(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.findPhonesByTariffNamePoint()")
    public void findPhonesByTariffName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.findPhonesByClientPoint()")
    public void findPhonesByClient(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

//---------UserTariffController-------------------------------------------------

    @After("by.step.aop.pointcut.AdminPointcuts.saveTariffPoint()")
    public void saveTariff(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.addPhoneByIdPoint()")
    public void addPhoneById(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.addPhoneByNumberPoint()")
    public void addPhoneByNumber(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.sortTariffByPricePoint()")
    public void sortTariffByPriceAll(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }

    @After("by.step.aop.pointcut.AdminPointcuts.findTariffByParametersPoint()")
    public void findTariffByParameters(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info(signature.getMethod());
    }
}
