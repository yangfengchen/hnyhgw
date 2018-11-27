package com.hnyhgw.handle;

import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.util.MyException;
import com.hnyhgw.vo.AjaxResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public AjaxResultVo errorHandler(Exception ex) {
        logger.debug("错误信息",ex);
        return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).message(ex.getMessage()).build();
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public AjaxResultVo myErrorHandler(MyException ex) {
        logger.debug("错误信息",ex);
        return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).message(ex.getMessage()).build();
    }


}
