package com.finance.ctrlm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class App {

    //Para
    @GetMapping("getcategories")
    public String Add(@RequestParam String name, Model model){
        Main.NewCategory(name, model);

        return "GetExpenses";
    }

    @GetMapping("index")
    public String index(){

        return "GetCategories";
    }

    @GetMapping("expenses")
    public String inputExpenses(){

        return "GetExpenses";
    }

}
