package com.precisionbio.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.precisionbio.restfulwebservices.helloworld.HelloWorldBean;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloworld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloworldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
