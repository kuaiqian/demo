package com.duobaoyu.seata.config;

import com.taobao.txc.seata.SeataOnTxcAutoConfiguration;
import io.seata.spring.boot.autoconfigure.provider.SpringApplicationContextProvider;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.seata.common.Constants.BEAN_NAME_SPRING_APPLICATION_CONTEXT_PROVIDER;

/**
 * @author FS001338
 * @date 2020/12/2
 */
@Configuration
@AutoConfigureBefore(SeataOnTxcAutoConfiguration.class)
public class SeataCustomerConfig {

    @Bean(BEAN_NAME_SPRING_APPLICATION_CONTEXT_PROVIDER)
    @ConditionalOnMissingBean(name = {BEAN_NAME_SPRING_APPLICATION_CONTEXT_PROVIDER})
    public SpringApplicationContextProvider springApplicationContextProvider() {
        return new SpringApplicationContextProvider();
    }
}
