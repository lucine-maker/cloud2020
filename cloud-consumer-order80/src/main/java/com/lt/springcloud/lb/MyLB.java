package com.lt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lucine
 * @version 1.0 2020/12/14 21:55
 */
@Component
public class MyLB implements LoadBalancer {

    AtomicInteger  atomicInteger = new AtomicInteger(0);

    public final  int getAndIncrement(){
        int current;
        int next ;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 :current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****第"+next+"次访问");

        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
