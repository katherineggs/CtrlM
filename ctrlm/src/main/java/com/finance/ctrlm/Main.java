package com.finance.ctrlm;

import org.springframework.ui.Model;

import java.util.Arrays;

public class Main {

    //Method to add a new category and create the object
    public static void NewCategory(String name, Model model){
        Category.addCategory(name, model);
        Category.CreateObject();

    }


}
