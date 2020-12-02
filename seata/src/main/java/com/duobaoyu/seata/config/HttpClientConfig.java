//package com.duobaoyu.seata.config;
//
//import feign.Client;
//import okhttp3.ConnectionPool;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.cloud.commons.httpclient.OkHttpClientConnectionPoolFactory;
//import org.springframework.cloud.commons.httpclient.OkHttpClientFactory;
//import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PreDestroy;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author FS001338
// * @date 2020/11/29
// */
//@Configuration
//public class HttpClientConfig {
//
//    private okhttp3.OkHttpClient okHttpClient;
//
//    @Bean
//    public okhttp3.OkHttpClient client(OkHttpClientFactory httpClientFactory,
//                                       ConnectionPool connectionPool,
//                                       FeignHttpClientProperties httpClientProperties) {
//        Boolean followRedirects = httpClientProperties.isFollowRedirects();
//        Integer connectTimeout = httpClientProperties.getConnectionTimeout();
//        Boolean disableSslValidation = httpClientProperties.isDisableSslValidation();
//        this.okHttpClient = httpClientFactory.createBuilder(disableSslValidation)
//                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
//                .followRedirects(followRedirects).connectionPool(connectionPool)
//                .build();
//        return this.okHttpClient;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(ConnectionPool.class)
//    public ConnectionPool httpClientConnectionPool(
//            FeignHttpClientProperties httpClientProperties,
//            OkHttpClientConnectionPoolFactory connectionPoolFactory) {
//        Integer maxTotalConnections = httpClientProperties.getMaxConnections();
//        Long timeToLive = httpClientProperties.getTimeToLive();
//        TimeUnit ttlUnit = httpClientProperties.getTimeToLiveUnit();
//        return connectionPoolFactory.create(maxTotalConnections, timeToLive, ttlUnit);
//    }
//
//    @PreDestroy
//    public void destroy() {
//        if (this.okHttpClient != null) {
//            this.okHttpClient.dispatcher().executorService().shutdown();
//            this.okHttpClient.connectionPool().evictAll();
//        }
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(Client.class)
//    public Client feignClient(okhttp3.OkHttpClient client) {
//        return new feign.okhttp.OkHttpClient(client);
//    }
//}
