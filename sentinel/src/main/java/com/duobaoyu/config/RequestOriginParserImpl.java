package com.duobaoyu.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chengchen
 * @date 2020/9/28
 */
@Component
public class RequestOriginParserImpl implements RequestOriginParser {

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public String parseOrigin(HttpServletRequest request) {
        return applicationName;
    }
}
