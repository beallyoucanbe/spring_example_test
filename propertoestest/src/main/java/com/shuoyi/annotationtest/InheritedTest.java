package com.shuoyi.annotationtest;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zhaosy-c on 2017/12/25.
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InheritedTest {
    String value();
}
