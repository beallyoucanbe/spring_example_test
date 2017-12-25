package com.shuoyi.annotationtest;

/**
 * Created by zhaosy-c on 2017/12/25.
 */
@InheritedTest("有Inherited 注解 class")
@InheritedTest2("没有Inherited 注解 class")
public class Parent {

    @InheritedTest("有Inherited 注解 method")
    @InheritedTest2("没有Inherited 注解 method")
    public void method(){

    }

    @InheritedTest("有Inherited 注解 method2")
    @InheritedTest2("没有Inherited 注解 method2")
    public void method2(){

    }

    @InheritedTest("有Inherited 注解 field")
    @InheritedTest2("没有Inherited 注解 field")
    public String a;
}
