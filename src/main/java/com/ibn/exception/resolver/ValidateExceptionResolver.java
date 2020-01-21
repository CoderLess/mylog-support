package com.ibn.exception.resolver;

import com.ibn.base.entity.ResultInfo;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version 1.0
 * @description: 校验异常统一处理
 * @projectName：mylog-support
 * @see: com.ibn.exception.resolver
 * @author： RenBin
 * @createTime：2020/1/21 11:35
 */
@ControllerAdvice
public class ValidateExceptionResolver {
    /**
     * @description: 参数异常统一处理
     * @author：RenBin
     * @createTime：2020/1/21 12:41
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object exceptionHandler(MethodArgumentNotValidException e) {
        // 获取所有异常
        List<ObjectError> objectErrorList = e.getBindingResult().getAllErrors();
        String msg = "参数异常";
        if (!CollectionUtils.isEmpty(objectErrorList)) {
            msg = objectErrorList.get(0).getDefaultMessage();
        }
        return new ResultInfo<>().error(msg);
    }

}
