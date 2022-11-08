package by.step.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class AdminPointcuts {

    @Pointcut("execution(* by.step.controller.parent.BaseAdminController.findOneById(..))")
    public void findOneByIdPoint() {
    }

    @Pointcut("execution(* by.step.controller.parent.BaseUserController.findAll())")
    public void findAllPoint() {
    }

    @Pointcut("execution(* by.step.controller.parent.BaseAdminController.removeById(..))")
    public void removeByIdPoint() {
    }

//---------UserClientController------------------------------------------------

    @Pointcut("execution(* by.step.controller.admin.AdminClientController.save(..))")
    public void saveClientPoint() {
    }

    @Pointcut("execution(* by.step.controller.admin.AdminClientController.addPhoneToClient(..))")
    public void addPhoneToClientPoint() {
    }

    @Pointcut("execution(* by.step.controller.user.UserClientController.getAmountClient())")
    public void getAmountClientPoint(){
    }

//---------UserPhoneController------------------------------------------------

    @Pointcut("execution(* by.step.controller.admin.AdminPhoneController.save(..))")
    public void savePhonePoint() {
    }

    @Pointcut("execution(* by.step.controller.admin.AdminPhoneController.addClientToPhone(..))")
    public void addClientToPhonePoint() {
    }

    @Pointcut("execution(* by.step.controller.admin.AdminPhoneController.addTariffToPhone(..))")
    public void addTariffToPhonePoint(){
    }

    @Pointcut("execution(* by.step.controller.admin.AdminPhoneController.findPhonesByTariffName(..))")
    public void findPhonesByTariffNamePoint(){
    }

    @Pointcut("execution(* by.step.controller.admin.AdminPhoneController.findPhonesByClient(..))")
    public void findPhonesByClientPoint(){
    }

//---------UserTariffController-------------------------------------------------

    @Pointcut("execution(* by.step.controller.admin.AdminTariffController.save(..))")
    public void saveTariffPoint() {
    }

    @Pointcut("execution(* by.step.controller.admin.AdminTariffController.addPhoneById(..))")
    public void addPhoneByIdPoint() {
    }

    @Pointcut("execution(* by.step.controller.admin.AdminTariffController.addPhoneByNumber(..))")
    public void addPhoneByNumberPoint() {
    }

    @Pointcut("execution(* by.step.controller.admin.AdminTariffController.sortTariffByPrice())")
    public void sortTariffByPricePoint(){
    }

    @Pointcut("execution(* by.step.controller.admin.AdminTariffController.findTariffByParameters(..))")
    public void findTariffByParametersPoint(){
    }
}
