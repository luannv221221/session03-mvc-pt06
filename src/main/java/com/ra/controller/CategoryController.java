package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/categories")
    public String index(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "list-category";
    }

    @GetMapping("/add-category")
    public String add(){
        return "add-category";
    }
//    @PostMapping("/add-category")
//    public String save(@RequestParam("name") String name,@RequestParam("status") boolean status){
//        // Lấy dữ liệu từ form để thêm mưới vao database
//        System.out.println("name"+name+"status"+status);
//        return "hihi";
//    }
    @PostMapping("/add-category")
    public String save(HttpServletRequest httpServlet){
        // Lấy dữ liệu từ form để thêm mưới vao database
        String name = httpServlet.getParameter("name");
        boolean status = Boolean.parseBoolean(httpServlet.getParameter("status"));

        Category category = new Category();
        category.setCategoryName(name);
        category.setCategoryStatus(status);
        // gọi đến service để thêm mới
        categoryService.create(category);
        return "redirect:/categories";
    }
}
