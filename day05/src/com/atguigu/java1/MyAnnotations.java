package com.atguigu.java1;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/17 11:48
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
