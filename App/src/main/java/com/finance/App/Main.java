package com.finance.App;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Main {
    List<String> items = new ArrayList<>();

    @GetMapping("ingreso")
    public String Ingreso(@RequestParam String amount, String category, Model model){
        String input = amount + " " + category;
        items.add(input);
        model.addAttribute("items", items);
        return "List";
    }
    @GetMapping("form")
    public String inputForm(){
        return "form";
    }
}
