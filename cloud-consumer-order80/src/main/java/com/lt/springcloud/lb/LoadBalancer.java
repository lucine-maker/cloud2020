package com.lt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.*;

/**
 * @author lucine
 * @version 1.0 2020/12/14 21:52
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);

}
