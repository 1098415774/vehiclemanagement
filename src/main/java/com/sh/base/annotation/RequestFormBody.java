package com.sh.base.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestFormBody {
    boolean required() default true;
    String value() default "requestFormBody";
}
