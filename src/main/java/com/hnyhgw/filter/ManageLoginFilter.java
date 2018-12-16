package com.hnyhgw.filter;

import com.hnyhgw.common.KeysCommon;
import com.hnyhgw.common.ManagePathCommon;
import com.hnyhgw.entity.UserEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManageLoginFilter implements Filter {

    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<String> patterns = Arrays.asList("login", "ajaxLogin");


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI().substring(request.getContextPath().length());
        if (url.indexOf("/manage") != -1) {
            UserEntity userEntity = (UserEntity) request.getSession().getAttribute(KeysCommon.MANAGE_USER_KEY);
            url = url.substring(url.indexOf(ManagePathCommon.COMMON_START_URL) + 7, url.length());
            if (userEntity == null) {
                if (isParentUrl(url)) {
                     RequestDispatcher dispatcher = request.getRequestDispatcher("/manage/login");
                    dispatcher.forward(request, response);
                    return;
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    /**
    * 过滤url
    **/
    private boolean isParentUrl(String url) {
        if (StringUtils.isNotBlank(url)) {
            List<String> ns = patterns.stream().filter(s -> {
                if (!url.startsWith(s)) {
                    return true;
                } else {
                    return false;
                }
            }).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(ns)) {
                if(ns.size()>=2){
                    return true;
                }else{
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }
}
