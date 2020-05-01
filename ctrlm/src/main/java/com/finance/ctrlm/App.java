package com.finance.ctrlm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class App {

    //First page = Get income
    @GetMapping("index")
    public String index(){

        return "GetIncome";
    }

    @GetMapping("getincome")
    public String income(@RequestParam int IncomeAmount, Model model){
        Prueba.Incomes(IncomeAmount, model);
        return "GetCategories";
    }

    //Expenses
    @GetMapping("getcategories")
    public String Add(@RequestParam String name, Model model){
        Main.NewCategory(name, model);

        return "GetExpenses";
    }


    @GetMapping("expenses")
    public String inputExpenses(@RequestParam(value = "Categories") String category, @RequestParam(value="amount") int money, Model model){
        Main.Expenses(category, money, model);
        CreateFile.fileCreate();
        return "ShowExpenses";
    }

    //------ MENU -------
    @GetMapping("/GetExpenses")
    public String showExpenses(){
        return "GetExpenses";
    }

    @GetMapping("/GetCategories")
    public String showCategories(){
        return "GetCategories";
    }

}
