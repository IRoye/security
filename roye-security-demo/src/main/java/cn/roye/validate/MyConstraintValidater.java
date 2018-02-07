package cn.roye.validate;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 实现一个泛型的接口， 第一个就是需要验证的注解是什么？第二个就是需要验证的是什么类型的数据
 */
public class MyConstraintValidater implements ConstraintValidator<Myconstraint, Object>{



    @Override
    public void initialize(Myconstraint constraintAnnotation) {
        System.out.println("init!");
    }

    /**
     *
     * @param value 传进来的校验的值
     * @param context 包含的注解里面的一些值；
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("value：" + value);
        return false;
    }
}
