package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
    @Autowired
    ApiService as;
    
    @PostMapping("post")
    public Child saveinfo(@RequestBody Child c)
    {
    	return as.postinfo(c);
    }
    
    @GetMapping("get/{name}")
    public List<Child> getsortinfo(@PathVariable String name)
    {
    	return as.sortinfo(name);
    }
    

    @GetMapping("page/{pageno}/{pagesize}")
    public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
    {
    	return as.getbypage0(pageno, pagesize);
    }
    
    @GetMapping("paging/{pageno}/{pagesize}/{name}")
    public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String name)
    {
    	return as.getbypage(pageno, pagesize, name);
    }
}
