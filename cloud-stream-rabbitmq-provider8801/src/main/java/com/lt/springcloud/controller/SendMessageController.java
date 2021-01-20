package com.lt.springcloud.controller;

import com.lt.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucine
 * @version 1.0 2021/1/3 14:00
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;


    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return  messageProvider.send();
    }
}
