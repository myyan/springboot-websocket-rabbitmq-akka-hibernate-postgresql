package com.freeland.custom.annotation;

import lombok.Data;

/**
 * Created by chenhao on 2016/10/31.
 */
@Data
public class TestExample {

    @MyField
    public String name;

    @Test
    public void testA() {
        if (true) {
            System.out.println("this test always failed");
        }
    }

    @Test(enable = false)
    public void testB() {
        if (false) {
            System.out.println("this test always passed");
        }
    }

    @Test(enable = true)
    public void testC() {
        if (10 > 1) {
            System.out.println("ok");
        }
    }


}
