package cn.roye.web.controller;


import cn.roye.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 将自定义异常传递的参数传递给前台页面;
 * 处理其他的controller 抛出来的异常
 *
 * 这个的执行是放到afterCompletion 之前的
 * 当然没有被异常处理器处理掉的话， 那么afterCompletion就可以正常使用了
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
     public Map<String, Object> handlerUserNotExistException(UserNotExistException ex){
      Map<String, Object> result = new HashMap<>();
      result.put("id", ex.getId());
      result.put("message", ex.getMessage());
      return result;
}
}
