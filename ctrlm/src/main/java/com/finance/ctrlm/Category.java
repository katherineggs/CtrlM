package com.finance.ctrlm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

public class Category {
    //Attributes
    int Times;
    int SpentMoney;

    //List to save the categories entered
    static List<String> categoriesList = new ArrayList<>();

    //Method to add the categories to the list
    public static void addCategory(String name, Model model){
        String NewCategory = name;
        categoriesList.add(NewCategory);
        model.addAttribute("categoriesList", categoriesList);

    }

}