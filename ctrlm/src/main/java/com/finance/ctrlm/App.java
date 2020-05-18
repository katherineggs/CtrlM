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
//        String path = "C:\\Users\\kgrac\\Desktop\\CtrlM\\JSON\\";
//        String nameFile = CreateFile.lastModified(path);
//        System.out.println(nameFile);
//        CreateFile.readJson(path+nameFile);
        return "GetUserName";
    }

    static String userName;
    @GetMapping("getusername")
    public String userName(@RequestParam String UserName){
        userName = UserName;
        return "GetIncome";
    }

    @GetMapping("getincome")
    public String income(@RequestParam int IncomeAmount, int SavingGoal){
        Prueba.Incomes(IncomeAmount, SavingGoal);
        return "GetSaving";
    }

    @GetMapping("getsaving")
    public String saving(@RequestParam(value = "SavingAmount") int SavingAmount){
        Prueba.Saving(SavingAmount);
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
        model.addAttribute("expensesList", Prueba.expensesList);
        model.addAttribute("objectList", Prueba.objectList);

        Main.Expenses(category, money, model);
        CreateFile.fileCreate();
        //CreateFile.readJson();
        System.out.println("--------------------------------------");
        return "ShowExpenses";
    }

    //------ MENU -------
    @GetMapping("/GetExpenses")
    public String showExpenses(Model model){
        model.addAttribute("categoriesList", Prueba.namesList);

        return "GetExpenses";
    }

    @GetMapping("/GetCategories")
    public String showCategories(Model model){
        model.addAttribute("categoriesList", Prueba.namesList);
        //Expenses
        model.addAttribute("expensesList", Prueba.expensesList);
        model.addAttribute("objectList", Prueba.objectList);
        return "GetNewCategory";
    }

    @GetMapping("/GetNewCategory")
    public String getNewCategory(@RequestParam String name, Model model){
        Main.NewCategory(name, model);

        model.addAttribute("categoriesList", Prueba.namesList);
        //Expenses
        model.addAttribute("expensesList", Prueba.expensesList);
        model.addAttribute("objectList", Prueba.objectList);
        //Income
        model.addAttribute("TotalIncome", Prueba.TotalIncome);
        model.addAttribute("balance", Prueba.balance);
        //Savings
        model.addAttribute("totalSavings", Prueba.totalSavings);
        model.addAttribute("savingsList", Prueba.savingsList);
        model.addAttribute("SavingGoal", Prueba.savingAmount);
        return "ShowExpenses";
    }

    @GetMapping("/GetSaving")
    public String GetSavings(Model model){
        //model.addAttribute("totalSavings", Prueba.totalSavings);

        return "GetNewSaving";
    }

    @GetMapping("/GetNewSaving")
    public String getNewSaving(@RequestParam(value = "SavingAmount") int SavingAmount, Model model){
        Prueba.Saving(SavingAmount);
        Prueba.CalculateBalance();

        //Expenses
        model.addAttribute("expensesList", Prueba.expensesList);
        model.addAttribute("objectList", Prueba.objectList);
        //Income
        model.addAttribute("TotalIncome", Prueba.TotalIncome);
        model.addAttribute("balance", Prueba.balance);
        //Savings
        model.addAttribute("totalSavings", Prueba.totalSavings);
        model.addAttribute("savingsList", Prueba.savingsList);
        model.addAttribute("SavingGoal", Prueba.savingAmount);

        return "ShowExpenses";
    }

    @GetMapping("/Summary")
    public String Summary(Model model){
        Prueba.Total();
        //Most and Least Expenses
        model.addAttribute("objectList", Prueba.objectList);
        model.addAttribute("mostExpend", Prueba.mostExpend());
        model.addAttribute("leastExpend", Prueba.leastExpend());
        //Savings
        model.addAttribute("SavingGoal", Prueba.goal);
        model.addAttribute("totalSavings", Prueba.totalSavings);
        model.addAttribute("spentmoney",Prueba.spentMoney);
        model.addAttribute("TotalExpenses",Prueba.TotalExpenses);

        return "Summary";
    }

    @GetMapping("/ShowExp")
    public String show(Model model){
        //Expenses
        model.addAttribute("expensesList", Prueba.expensesList);
        model.addAttribute("objectList", Prueba.objectList);
        //Income
        model.addAttribute("TotalIncome", Prueba.TotalIncome);
        model.addAttribute("balance", Prueba.balance);
        //Savings
        model.addAttribute("totalSavings", Prueba.totalSavings);
        model.addAttribute("savingsList", Prueba.savingsList);
        model.addAttribute("SavingGoal", Prueba.savingAmount);

        return "ShowExpenses";
    }

}

