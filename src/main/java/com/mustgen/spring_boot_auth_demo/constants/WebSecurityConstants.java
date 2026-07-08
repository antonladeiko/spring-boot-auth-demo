package com.mustgen.spring_boot_auth_demo.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class WebSecurityConstants {

    public static final String H2_CONSOLE_PATH = "/h2-console/**";
    public static final String LOGOUT_PATH_PATTERN = "/api/auth/logout";
    public static final String REGISTRATION_URL = "/api/auth/register";
    public static final String LOGIN_COOKIE = "JSESSIONID";

}
