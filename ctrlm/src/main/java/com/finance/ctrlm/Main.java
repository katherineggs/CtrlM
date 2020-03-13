package com.finance.ctrlm;

import org.springframework.ui.Model;

public class Main {

    //Método para crear agregar la categoría a la lista y crear el objeto
    public static void NewCategory(String name, Model model){
        Category.addCategory(name, model);
        Category CategoryName = new Category();

    }

}
