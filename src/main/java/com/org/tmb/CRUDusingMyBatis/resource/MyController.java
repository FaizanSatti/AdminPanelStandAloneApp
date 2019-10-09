package com.org.tmb.CRUDusingMyBatis.resource;

import com.org.tmb.CRUDusingMyBatis.mapper.UserMapper;
import com.org.tmb.CRUDusingMyBatis.model.Admin;
import com.org.tmb.CRUDusingMyBatis.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @Resource
    private UserMapper userMapper;

    @GetMapping("/adminLogin")
    public String sendForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminLogin";
    }

    @PostMapping("/adminLogin")
    public String processForm(Admin admin, ModelMap modelMap, Model model) {
        String adminEmail = userMapper.findAdminEmail();
        String adminPassword = userMapper.findAdminPassword();

        System.out.println("email :"+adminEmail+"password :"+adminPassword);


        if (admin.getEmail().equals(adminEmail) && admin.getPassword().equals(adminPassword)) {

            List<Product> Products = userMapper.findAll();
            modelMap.addAttribute("Products", Products);
            model.addAttribute("user", new Product());
            return "showProduct";

        } else
            return "adminLogin";

    }

    @GetMapping("/NewProduct")
    public String defectDetails(Product product) {
        return "NewProduct";
    }

    @PostMapping("/NewProduct")
    public String insertProduct(Product product, ModelMap modelMap) {
        if (product.getName().equals("") || product.getImg_src().equals("") || product.getPrice() == 0 || product.getCategory_id() == 0 || product.getDescription().equals("")) {
            return "NewProduct";
        } else {

            userMapper.insertOne(product);
            return "redirect:/show";
        }
    }

    @GetMapping("/show")
    public String sow(ModelMap modelMap, Model model) {
        List<Product> Products = userMapper.findAll();
        modelMap.addAttribute("Products", Products);
        model.addAttribute("user", new Product());
        return "showProduct";
    }

    @PostMapping("/delete")
    public String delete(Product product, ModelMap modelMap) {
        List<Product> Products = userMapper.findAll();
        modelMap.addAttribute("Products", Products);
        int res = userMapper.deleteOne(product.getId());
        if (res == 1) {
            System.out.println("result is  " + res);
            return "redirect:/show";
        } else {
            System.out.println("result is  " + res);
            return "redirect:/show";
        }
    }

    @PostMapping("/update")
    public String update(Product product, ModelMap modelMap,Model model) {
        //System.out.println("id is : "+product.getId());
//        int Products = userMapper.update(product.getId());

        List<Product> Products = userMapper.findOne(product.getId());
        modelMap.addAttribute("Products", Products);
        model.addAttribute("user", new Product());
        System.out.println("this is update: "+Products);

        return "updateProduct";
//        if (res == 1) {
//            System.out.println("result is  " + res);
//            return "redirect:/show";
//        } else {
//            System.out.println("result is  " + res);
//            return "redirect:/show";
//        }
    }
}


