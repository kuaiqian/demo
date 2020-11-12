package com.duobaoyu.web.argumentResolver;

import com.duobaoyu.web.annotation.Auth;
import com.duobaoyu.web.model.AuthData;
import com.google.common.collect.Lists;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author FS001338
 * @date 2020/10/30
 */
public class AuthDataMehotdArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Auth.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        AuthData authData=new AuthData();
        authData.setEmpId(1);
        authData.setOrgIds(Lists.newArrayList(1,2,3));
        return authData;
    }
}
