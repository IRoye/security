package cn.roye.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细节。
 * 在定义注解时，不能继承其他的注解或接口
 */
// 标注在方法和字段上面；
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) // 运行时的注解
@Constraint(validatedBy = MyConstraintValidater.class) // 用什么样的类去校验， 也就是校验逻辑你要写在哪里呢？
public @interface Myconstraint {
    String message() default "{org.hibernate.validator.constraints.NotEmpty.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
