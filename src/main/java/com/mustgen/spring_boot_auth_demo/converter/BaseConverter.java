package com.mustgen.spring_boot_auth_demo.converter;

public interface BaseConverter<T, K> {

    K convert(T source);

}
