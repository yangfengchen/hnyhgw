package com.hnyhgw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBaseController {

    //日志
    protected static final Logger logger = LoggerFactory.getLogger(AbstractBaseController.class);

    //重定向
    protected static final String REDIRECT = "redirect:/";

}
