package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ApiService {
     @Autowired
     ChildRepo cr;
     
     public Child postinfo(Child c)
     {
    	 return cr.save(c);
     }
     
     public List<Child> sortinfo(String s)
     {
    	 return cr.findAll(Sort.by(Sort.Direction.ASC,s));
     }
     
     public List<Child> getbypage0(int pgno,int size)
     {
    	 Page<Child> p=cr.findAll(PageRequest.of(pgno, size));
    	 return p.getContent(); 
     }
     
     public List<Child> getbypage(int pgno,int size,String s)
     {
    	 Page<Child> p=cr.findAll(PageRequest.of(pgno, size, (Sort.by(Sort.Direction.ASC,s))));
    	 return p.getContent();     }
}
