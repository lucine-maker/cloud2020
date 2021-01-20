package com.lt.springcloud.controller;

import com.lt.springcloud.domain.CommonResult;
import com.lt.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucine
 * @version 1.0 2021/1/17 18:19
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId ,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }

}
