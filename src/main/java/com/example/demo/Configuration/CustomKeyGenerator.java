package com.example.demo.Configuration;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import com.example.demo.utils.LoggedInUserDetails;

@Component("customKeyGenerator")
public class CustomKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return LoggedInUserDetails.getCurrentLoggedInUsername();
    }
}
