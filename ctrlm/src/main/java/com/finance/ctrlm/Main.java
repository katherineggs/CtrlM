package com.finance.ctrlm;

import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class Main {

    //Method to add a new category and create the object
    public static void NewCategory(String name, Model model){
        Prueba.addCategory(name, model);

    }

    public static void Expenses(String category, int money, Model model){
        Prueba.CalculateExpenses(category, money, model);
    }

    //NAV BAR
    public static void newExpense(String category, int money, Model model){
        model.addAttribute("categoriesList", Prueba.namesList);
        Prueba.CalculateExpenses(category, money, model);

    }


}
