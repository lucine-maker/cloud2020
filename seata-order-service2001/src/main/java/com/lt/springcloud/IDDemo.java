package com.lt.springcloud;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lucine
 * @version 1.0 2021/1/19 09:59
 */
public class IDDemo {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}
