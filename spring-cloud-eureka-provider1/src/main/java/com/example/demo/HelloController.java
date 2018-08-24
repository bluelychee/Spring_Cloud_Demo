package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Create by lizhihui on 2018/5/16
 */
@RestController
public class HelloController {
    @Autowired
    DiscoveryClient client;

    @Value("${server.port}")
    private String port;


    private final Logger logger = Logger.getLogger(getClass().getName());

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance =client.getLocalServiceInstance();
        logger.info("/hello,host "+instance.getHost()+" ,service_id "+instance.getServiceId());
        return "World from "+port;
    }
}
