package com.finance.ctrlm;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.ui.Model;

public class Category {
    //Attributes
    static String Name;
    static int Times;
    static int SpentMoney;

    //Constructor
    Category(String name){
        Name = name;

    }

    //List to save the categories entered
    static int size = 0;
    static int cont = 0;
    static String categoriesList [] = new String[size];


    //Method to add the categories to the list
    public static void addCategory(String name, Model model){
        Boolean firstRound = true;
        String[] temp = categoriesList;
        String[] NewCategory = name.split(",");
        size += NewCategory.length;
        categoriesList = new String[size];

        for(int i = 0; i < size - NewCategory.length; i ++) {
            categoriesList[i] = temp[i];
        }
        for(int iN = 0; iN < NewCategory.length; iN++) {
            categoriesList[cont] = NewCategory[iN];
            cont++;
        }
        model.addAttribute("categoriesList", categoriesList);
    }

    public static String GetName(){
        System.out.println(Name);
        return Name;
    }


    //Method to classify expenses (assign values to the object)



}
