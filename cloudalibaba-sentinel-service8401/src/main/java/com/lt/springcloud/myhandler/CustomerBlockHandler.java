package com.lt.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lt.springcloud.entities.CommonResult;

/**
 * @author lucine
 * @version 1.0 2021/1/15 22:36
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(4444,"自定义的异常4444----1");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(4444,"自定义的异常4444----2");
    }

}
