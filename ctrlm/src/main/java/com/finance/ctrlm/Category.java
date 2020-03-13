package com.finance.ctrlm;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.ui.Model;

public class Category {
    //Attributes
    int Times;
    int SpentMoney;


    //List to save the categories entered
//    static List<String> categoriesList = new ArrayList<>();
    static int size = 0;
    static String categoriesList [] = new String[size];


    //Method to add the categories to the list
    public static void addCategory(String name, Model model){
        String[] temp = categoriesList;
        String[] NewCategory = name.split(",");
        size += NewCategory.length;
        categoriesList = new String[size];
        for(int i = 0; i < size - NewCategory.length; i ++){
            if( i <= temp.length ) {
                categoriesList[i] = temp[i];

            } else{
                categoriesList[i] = NewCategory[i];
            }
        }
        System.out.println(Arrays.toString(NewCategory));
        System.out.println(Arrays.toString(categoriesList));

        model.addAttribute("categoriesList", categoriesList);
    }
}
