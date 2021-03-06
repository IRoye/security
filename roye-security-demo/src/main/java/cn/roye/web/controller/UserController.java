package cn.roye.web.controller;

import cn.roye.domain.ResultObj;
import cn.roye.domain.User;
import cn.roye.dto.UserCondition;
import cn.roye.exception.UserNotExistException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.validation.Valid;
import java.awt.print.Pageable;

@RestController // 告诉controller 提供rest 服务
@RequestMapping("/user")
public class UserController {
    /**
     * 虽然rest 的形式 用http的方法来表示执行的状态，但是 addUser, deleteUser 这种形式更直观便于理解；
     * @param user
     * @return
     */
    @GetMapping("/")
    public ResultObj query(
            // @RequestParam(name="username", required = false, defaultValue = "tom") String name
            UserCondition user){
        // 用来格式化打印；
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(user.getAge());
        ResultObj obj = new ResultObj();
        obj.setCode("0");
        return obj;
    }

    /**
     * id 必须匹配
     * {}： 中是可以写正则的
     * @param id
     * @return
     */
    // 注意，是这里写错了
    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable(name = "id") String id){
        System.out.println("404!");
        throw new UserNotExistException("11");
//                User user = new User();
//                System.out.println("****************************************************************");
//                System.out.println("id:" + id);
//                user.setUsername("tom");
//                return user;
    }

    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User user, BindingResult errors){

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                System.out.println("字段:" + fieldError.getField() + "   "+error.getDefaultMessage());
                    }
            );
        }

        user.setAge("16");
        System.out.println(user.getBirthday().getTime());
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        return user;
    }


}
