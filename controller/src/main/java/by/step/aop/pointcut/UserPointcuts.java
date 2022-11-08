package by.step.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class UserPointcuts {

    @Pointcut("execution(* by.step.controller.parent.BaseUserController.findAll())")
    public void findAllPoint() {
    }

//---------UserClientController------------------------------------------------

    @Pointcut("execution(* by.step.controller.user.UserClientController.findOneByName(..))")
    public void findOneByNamePoint() {
    }

    @Pointcut("execution(* by.step.controller.user.UserClientController.getAmountClient())")
    public void getAmountClientPoint(){
    }

//---------UserPhoneController------------------------------------------------

    @Pointcut("execution(* by.step.controller.user.UserPhoneController.findOneByNumber(..))")
    public void findOneByNumberPoint(){
    }

    @Pointcut("execution(* by.step.controller.user.UserPhoneController.findPhonesByTariffName(..))")
    public void findPhonesByTariffNamePoint(){
    }

    @Pointcut("execution(* by.step.controller.user.UserPhoneController.findPhonesByClient(..))")
    public void findPhonesByClientPoint(){
    }

//---------UserTariffController-------------------------------------------------

    @Pointcut("execution(* by.step.controller.user.UserTariffController.sortTariffByPrice())")
    public void sortTariffByPricePoint(){
    }

    @Pointcut("execution(* by.step.controller.user.UserTariffController.findTariffByParameters(..))")
    public void findTariffByParametersPoint(){
    }
}
