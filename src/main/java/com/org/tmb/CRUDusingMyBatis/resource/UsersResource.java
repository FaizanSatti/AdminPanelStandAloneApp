package com.org.tmb.CRUDusingMyBatis.resource;

import com.org.tmb.CRUDusingMyBatis.mapper.UserMapper;
import com.org.tmb.CRUDusingMyBatis.model.Admin;
import com.org.tmb.CRUDusingMyBatis.model.Product;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersResource {
    @Resource
    private UserMapper userMapper;


//    @PostMapping("/insert")
//    public int insert(@RequestBody Product product){
//        return userMapper.insertOne(product);
//    }

//    @GetMapping("/all")
//    public String get(ModelMap modelMap){
//        List<Product> Products = userMapper.findAll();
//        modelMap.addAttribute("Products",Products);
//        return "showProduct";
//    }

//    @GetMapping("/one")
//    public List<Product> getOne(@RequestBody Product product) {
//        return userMapper.findOne(product);
//    }

//    @DeleteMapping("/delete")
//    public int delete(@RequestBody Product product){
//        return userMapper.deleteOne(product);
//    }

}
