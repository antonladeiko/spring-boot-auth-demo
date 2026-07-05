package com.mustgen.spring_boot_auth_demo.converter;

public interface BaseContextConverter<T, C, K> {

    K convert(T source, C context);

}
