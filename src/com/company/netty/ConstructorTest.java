package com.company.netty;

import java.lang.reflect.Constructor;

public class ConstructorTest {
    public static void main(String[] args) throws Exception {
        Constructor constructor = HLS.class.getConstructor();
        Object o = constructor.newInstance();
        
    }
}
