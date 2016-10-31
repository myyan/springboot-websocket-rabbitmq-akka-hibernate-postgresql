package com.freeland.custom.annotation;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by chenhao on 2016/10/31.
 */
public class FieldAnnotationHandler {
    public void handle(Object object) throws Exception {
        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MyField.class)){
                MyField myField = field.getAnnotation(MyField.class);
                int maxLength = myField.maxLength();
                System.out.println("maxlength:"+maxLength);
                if (maxLength < field.get(object).toString().length()){
                    throw new Exception("you have entered string greater than max length:"+maxLength+"  your length:"+field.get(object).toString().length());
                }
            }
        }
    }
}
