package com.hnyhgw.handle;

import com.hnyhgw.util.MyException;
import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Writer;

@Component
public class FreemarkTemplateExceptionHandle implements TemplateExceptionHandler {

    protected static final Logger logger = LoggerFactory.getLogger(FreemarkTemplateExceptionHandle.class);

    @Override
    public void handleTemplateException(TemplateException e, Environment environment, Writer writer) throws TemplateException {
        logger.error( "Failed to print error message. Cause: " + e, environment);
        throw new MyException("error","系统错误");
    }
}
