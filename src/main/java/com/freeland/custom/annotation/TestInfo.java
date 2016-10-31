package com.freeland.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chenhao on 2016/10/31.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//on class level
public @interface TestInfo {
    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    Priority priority() default Priority.MEDIUM;

    String[] tags() default "";

    String createBy() default "Freeland";

    String lastModified() default "20161031";
}
