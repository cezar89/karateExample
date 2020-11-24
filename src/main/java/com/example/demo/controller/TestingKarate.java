package com.example.demo.controller;

import com.example.demo.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class TestingKarate {
    private final RestTemplate restTemplate;

    @Autowired
    public TestingKarate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/show")
    @ResponseBody
    public ResponseModel showKarate(){

        ResponseModel responseModel = restTemplate.getForObject("http://127.0.0.1:8081", ResponseModel.class);
        String response = responseModel.getResponse();
        System.out.println("The response is: " + response);

        return responseModel;
    }
}
