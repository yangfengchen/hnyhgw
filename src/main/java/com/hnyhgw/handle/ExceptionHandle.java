package com.hnyhgw.handle;

import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.util.MyException;
import com.hnyhgw.vo.AjaxResultVo;
import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Writer;

@ControllerAdvice
public class ExceptionHandle{

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = Exception.class)
    public AjaxResultVo ajaxErrorHandler(Exception ex) {
        logger.debug("错误信息",ex);
        return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).message(ex.getMessage()).build();
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = MyException.class)
    public AjaxResultVo ajaxMyErrorHandler(MyException ex) {
        logger.debug("错误信息",ex);
        return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).message(ex.getMessage()).build();
    }

/*
    @ExceptionHandler(value = MyException.class)
    public ModelAndView myErrorHandler(MyException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }*/
}
