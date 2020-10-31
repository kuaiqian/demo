package com.duobaoyu.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author chengchen
 * @date 2020/9/28
 */
@Configuration
public class SentinelConfig implements InitializingBean {
    @Autowired
    private RequestOriginParser requestOriginParser;

    @Override
    public void afterPropertiesSet() throws Exception {
//        WebCallbackManager.setRequestOriginParser(requestOriginParser);
    }
}
