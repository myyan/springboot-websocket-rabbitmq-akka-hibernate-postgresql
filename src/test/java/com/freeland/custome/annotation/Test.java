package com.freeland.custome.annotation;

import com.freeland.custom.annotation.FieldAnnotationHandler;
import com.freeland.custom.annotation.TestExample;

/**
 * Created by chenhao on 2016/10/31.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing ....");

        FieldAnnotationHandler parser  = new FieldAnnotationHandler();
        TestExample testExample1 = new TestExample();
        testExample1.setName("12345678910");
        parser.handle(testExample1);

    }
}
