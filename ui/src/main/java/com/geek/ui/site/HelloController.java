package com.geek.ui.site;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Controller
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    private final DiscoveryClient client;
    private final RestTemplate restTemplate;

    @Autowired
    public HelloController(@Qualifier("discoveryClient") DiscoveryClient client, RestTemplate restTemplate) {
        this.client = client;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String hello(Model model) throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();
        // 等待几秒钟
        int sleepTime = new Random().nextInt(2000);
        logger.info("sleepTime: " + sleepTime);
        Thread.sleep(sleepTime);
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

        String message = restTemplate.getForObject("http://BREEZE-APPLY/hello", String.class);

        model.addAttribute("message", message);

        return "hello";
    }
}
